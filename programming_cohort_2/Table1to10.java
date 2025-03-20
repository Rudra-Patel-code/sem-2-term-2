public class Table1to10 {
  public static void main(String[] args) {
    int i = 0;

    while (i < 10) {
      System.out.println("Table of: " + i);
      System.out.println("----------");
      int j = 0;
      do {
        System.out.println((i + 1) + " * " + (j + 1) + " = " + (i + 1) * (j + 1) + " ");
        j++;
      } while (j < 10);
      System.out.println("\n");
      i++;
    }

  }

}