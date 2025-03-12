import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ChessGameGUI extends JPanel {
    private static final int TILE_SIZE = 80;
    private static final int BOARD_SIZE = 8;
    private static final ChessBoard chessBoard = new ChessBoard();
    private Point selectedPiece = null;
    private boolean dragging = false;
    private int dragX, dragY;

    public ChessGameGUI() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int col = e.getX() / TILE_SIZE;
                int row = e.getY() / TILE_SIZE;
                if (chessBoard.getPiece(row, col) != ' ') {
                    selectedPiece = new Point(col, row);
                    dragging = true;
                    dragX = e.getX();
                    dragY = e.getY();
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (selectedPiece != null && dragging) {
                    int col = e.getX() / TILE_SIZE;
                    int row = e.getY() / TILE_SIZE;
                    if (chessBoard.movePiece(selectedPiece.y, selectedPiece.x, row, col)) {
                        chessBoard.makeAIMove();
                    }
                    selectedPiece = null;
                    dragging = false;
                    repaint();
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (dragging) {
                    dragX = e.getX();
                    dragY = e.getY();
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        drawPieces(g);
        if (selectedPiece != null) {
            drawLegalMoves(g, selectedPiece.y, selectedPiece.x);
        }
    }

    private void drawBoard(Graphics g) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                g.setColor((row + col) % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY);
                g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    private void drawPieces(Graphics g) {
        g.setFont(new Font("SansSerif", Font.BOLD, 40));
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                char piece = chessBoard.getPiece(row, col);
                if (piece != ' ') {
                    g.setColor(Color.BLACK);
                    if (selectedPiece != null && selectedPiece.x == col && selectedPiece.y == row && dragging) {
                        g.drawString(String.valueOf(piece), dragX - 20, dragY + 10);
                    } else {
                        g.drawString(String.valueOf(piece), col * TILE_SIZE + 30, row * TILE_SIZE + 50);
                    }
                }
            }
        }
    }

    private void drawLegalMoves(Graphics g, int row, int col) {
        List<Point> legalMoves = chessBoard.getLegalMoves(row, col);
        g.setColor(Color.GREEN);
        for (Point move : legalMoves) {
            g.fillOval(move.x * TILE_SIZE + 30, move.y * TILE_SIZE + 30, 20, 20);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess Game");
        ChessGameGUI game = new ChessGameGUI();
        frame.add(game);
        frame.setSize(BOARD_SIZE * TILE_SIZE, BOARD_SIZE * TILE_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class ChessBoard {
    private char[][] board;
    private ChessEngine engine;

    public ChessBoard() {
        initializeBoard();
        engine = new ChessEngine();
    }

    private void initializeBoard() {
        String[] initialSetup = {
                "rnbqkbnr",
                "pppppppp",
                "        ",
                "        ",
                "        ",
                "        ",
                "PPPPPPPP",
                "RNBQKBNR"
        };
        board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            board[i] = initialSetup[i].toCharArray();
        }
    }

    public char getPiece(int row, int col) {
        return board[row][col];
    }

    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        // Validate move logic here
        board[endRow][endCol] = board[startRow][startCol];
        board[startRow][startCol] = ' ';
        return true;
    }

    public void makeAIMove() {
        Point[] move = engine.getBestMove(board);
        movePiece(move[0].y, move[0].x, move[1].y, move[1].x);
    }

    public List<Point> getLegalMoves(int row, int col) {
        return new ArrayList<>(); // Implement proper logic
    }
}

class ChessEngine {
    public Point[] getBestMove(char[][] board) {
        // Implement AI move logic here
        return new Point[] { new Point(1, 4), new Point(3, 4) }; // Example move
    }
}
