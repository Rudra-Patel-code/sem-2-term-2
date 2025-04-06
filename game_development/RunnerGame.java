import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.sound.sampled.*;
import java.io.*;

public class RunnerGame extends JPanel implements ActionListener, KeyListener {

    // --- Game Window Constants ---
    private final int WIDTH = 800;
    private final int HEIGHT = 400;
    
    // --- Game Loop Timer ---
    private Timer timer;
    private final int DELAY = 20; // ~50 FPS
    
    // --- Player Properties ---
    private final int playerWidth = 40;
    private final int playerHeight = 60;
    private int playerX = 100;
    private int playerY;
    private boolean isJumping = false;
    private double velocityY = 0;
    private final double GRAVITY = 0.8;
    private final int groundLevel = HEIGHT - 80; // ground y coordinate
    
    // --- Obstacles ---
    private ArrayList<Rectangle> obstacles;
    private final int obstacleWidth = 30;
    private final int obstacleHeight = 50;
    private int obstacleSpeed;
    private int obstacleSpawnCounter = 0;
    private int obstacleSpawnRate; // frames until next obstacle spawn

    // --- Score & Game State ---
    private int score = 0;
    private boolean gameOver = false;
    
    // Random number generator for obstacle spawns.
    private Random rand = new Random();
    
    // Difficulty level (Easy, Medium, Hard)
    private String difficultyLevel;
    
    // Sound clips
    private Clip bgClip;
    private Clip jumpClip;
    private Clip collisionClip;

    // Constructor: accepts difficulty level and sets up game objects and sound.
    public RunnerGame(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.CYAN.darker());
        setFocusable(true);
        addKeyListener(this);
        // Set starting player Y (on the ground)
        playerY = groundLevel - playerHeight;
        
        obstacles = new ArrayList<>();
        
        // Set difficulty parameters (obstacle speed & spawn rate)
        setDifficulty(difficultyLevel);
        
        timer = new Timer(DELAY, this);
        timer.start();
        
        // Load and start background music
        playBackgroundMusic();
        // Preload jump and collision sounds
        loadJumpSound();
        loadCollisionSound();
    }

    // Adjust difficulty: Easy (slower obstacles, less frequent), Medium, Hard (faster obstacles, more frequent, group spawns)
    private void setDifficulty(String diff) {
        if (diff.equalsIgnoreCase("Easy")) {
            obstacleSpeed = 4;
            obstacleSpawnRate = 150;
        } else if (diff.equalsIgnoreCase("Hard")) {
            obstacleSpeed = 10;
            obstacleSpawnRate = 50;
        } else { // Medium as default
            obstacleSpeed = 6;
            obstacleSpawnRate = 100;
        }
    }

    // Load and loop background music from "bg.wav"
    private void playBackgroundMusic() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("bg.wav"));
            bgClip = AudioSystem.getClip();
            bgClip.open(audioIn);
            bgClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            System.err.println("Error loading background music: " + ex.getMessage());
        }
    }

    // Load jump sound from "jump.wav"
    private void loadJumpSound() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("jump.wav"));
            jumpClip = AudioSystem.getClip();
            jumpClip.open(audioIn);
        } catch (Exception ex) {
            System.err.println("Error loading jump sound: " + ex.getMessage());
        }
    }
    
    // Load collision sound from "collision.wav"
    private void loadCollisionSound() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("collision.wav"));
            collisionClip = AudioSystem.getClip();
            collisionClip.open(audioIn);
        } catch (Exception ex) {
            System.err.println("Error loading collision sound: " + ex.getMessage());
        }
    }

    // Play jump sound effect (restart clip if already running)
    private void playJumpSound() {
        if (jumpClip != null) {
            if (jumpClip.isRunning()) {
                jumpClip.stop();
            }
            jumpClip.setFramePosition(0);
            jumpClip.start();
        }
    }
    
    // Play collision sound effect
    private void playCollisionSound() {
        if (collisionClip != null) {
            if (collisionClip.isRunning()) {
                collisionClip.stop();
            }
            collisionClip.setFramePosition(0);
            collisionClip.start();
        }
    }

    // Main game loop (called every DELAY milliseconds)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            updateGame();
        }
        repaint();
    }

    // Update game state: player physics, obstacles movement, collisions and score.
    private void updateGame() {
        // Update score
        score++;

        // Handle jumping physics
        if (isJumping) {
            playerY -= velocityY;
            velocityY -= GRAVITY;
            // If player lands back on ground, stop jump.
            if (playerY >= groundLevel - playerHeight) {
                playerY = groundLevel - playerHeight;
                isJumping = false;
                velocityY = 0;
            }
        }
        
        // Move obstacles leftward
        Iterator<Rectangle> iter = obstacles.iterator();
        Rectangle playerRect = new Rectangle(playerX, playerY, playerWidth, playerHeight);
        while (iter.hasNext()) {
            Rectangle obstacle = iter.next();
            obstacle.x -= obstacleSpeed;
            // Remove obstacles that move off the screen.
            if (obstacle.x + obstacle.width < 0) {
                iter.remove();
            }
            // Collision detection with player rectangle
            if (obstacle.intersects(playerRect)) {
                playCollisionSound();
                gameOver = true;
                timer.stop();
                if (bgClip != null && bgClip.isRunning()) {
                    bgClip.stop();
                }
            }
        }
        
        // Spawn obstacles at regular intervals.
        obstacleSpawnCounter++;
        if (obstacleSpawnCounter >= obstacleSpawnRate) {
            obstacleSpawnCounter = 0;
            // For "Hard" difficulty, spawn a group (2 obstacles)
            if (difficultyLevel.equalsIgnoreCase("Hard")) {
                spawnObstacle();
                spawnObstacle();
            } else {
                spawnObstacle();
            }
        }
    }

    // Spawn a new obstacle on the ground.
    private void spawnObstacle() {
        int x = WIDTH;
        int y = groundLevel - obstacleHeight;
        obstacles.add(new Rectangle(x, y, obstacleWidth, obstacleHeight));
    }
    
    // Render game state.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Enable anti-aliasing for smoother graphics.
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw ground
        g2.setColor(Color.GREEN.darker());
        g2.fillRect(0, groundLevel, WIDTH, HEIGHT - groundLevel);

        // Draw player: body and head.
        g2.setColor(Color.BLACK);
        g2.fillRect(playerX, playerY, playerWidth, playerHeight); // body
        g2.setColor(Color.PINK);
        g2.fillOval(playerX + 5, playerY - 20, playerWidth - 10, playerWidth - 10); // head

        // Draw obstacles
        g2.setColor(Color.RED);
        for (Rectangle obstacle : obstacles) {
            g2.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
        }

        // Draw score and instructions
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 20));
        g2.drawString("Score: " + score, 10, 25);
        g2.drawString("Press SPACE to jump", 10, 50);
        
        // If game over, display a message centered on the canvas.
        if (gameOver) {
            g2.setFont(new Font("Arial", Font.BOLD, 40));
            g2.setColor(Color.YELLOW);
            String msg = "Game Over!";
            int msgWidth = g2.getFontMetrics().stringWidth(msg);
            g2.drawString(msg, (WIDTH - msgWidth) / 2, HEIGHT / 2 - 20);
            g2.setFont(new Font("Arial", Font.BOLD, 20));
            String restartMsg = "Press R to Restart";
            int restartMsgWidth = g2.getFontMetrics().stringWidth(restartMsg);
            g2.drawString(restartMsg, (WIDTH - restartMsgWidth) / 2, HEIGHT / 2 + 20);
        }
    }

    // --- KeyListener methods ---
    @Override
    public void keyPressed(KeyEvent e) {
        if (!gameOver) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                // Initiate jump if not already jumping
                if (!isJumping) {
                    isJumping = true;
                    velocityY = 15; // initial jump velocity
                    playJumpSound();
                }
            }
        } else {
            // If game over, allow restart on pressing R key.
            if (e.getKeyCode() == KeyEvent.VK_R) {
                restartGame();
                if (bgClip != null) {
                    bgClip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No continuous actions needed here.
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    // Restart game by resetting game variables.
    private void restartGame() {
        gameOver = false;
        score = 0;
        obstacles.clear();
        playerY = groundLevel - playerHeight;
        isJumping = false;
        velocityY = 0;
        obstacleSpawnCounter = 0;
        timer.start();
    }

    // Main method to start the game: ask for difficulty level.
    public static void main(String[] args) {
        String[] options = {"Easy", "Medium", "Hard"};
        String difficulty = (String) JOptionPane.showInputDialog(null,
                "Select Difficulty Level:",
                "Runner Game",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]); // default to Medium

        if (difficulty == null) {
            System.exit(0);
        }

        JFrame frame = new JFrame("Endless Runner Game");
        RunnerGame gamePanel = new RunnerGame(difficulty);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}