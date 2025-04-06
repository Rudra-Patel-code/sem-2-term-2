public class PrintAscii {
    public static void main(String[] args) {
        System.out.println("ASCII values for characters 0 to 127");

        for (int i = 0; i <= 127; i++) {
            System.out.println("Character: " + (char) i + ", ASCII value: " + i);
        }
    }
}
