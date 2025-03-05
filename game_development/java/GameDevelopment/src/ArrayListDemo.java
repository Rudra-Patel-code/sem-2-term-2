import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) throws Exception {
        List<String> list_strings = new ArrayList<String>();

        list_strings.add("red");
        list_strings.add("green");
        list_strings.add("orange");
        list_strings.add("white");
        list_strings.add("black");

        // for (String element : list_strings)
        // System.out.println(element);

        String element = list_strings.get(0);
        System.out.println("First Element: " + element);
        element = list_strings.get(1);
        System.out.println("Second Element: " + element);

    }
}
