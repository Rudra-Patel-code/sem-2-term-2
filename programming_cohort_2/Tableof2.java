public class Tableof2 {

    public void run() {

        int tableno = 2;
        // Loop from 1 to 10
        int i = 0;
        for (i = 0; i < 10; i++) {

            // Print the multiplication of 2 and the current number
            System.out.println(tableno + " * " + i + " = " + (tableno * i));

        }

    }

    public void run(int tableno) {

        // Loop from 1 to 10
        int i = 0;
        for (i = 0; i < 10; i++) {

            // Print the multiplication of 2 and the current number
            System.out.println(tableno + " * " + i + " = " + (tableno * i));

        }

    }

    public static void main(String[] args) {

        // Create an instance of Table2

        Tableof2 table = new Tableof2();
        Tableof2 table1 = new Tableof2();

        // Call the run method to print the table

        table.run();
        table1.run(5);

    }

}