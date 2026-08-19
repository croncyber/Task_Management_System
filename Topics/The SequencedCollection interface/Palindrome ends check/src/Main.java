import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SequencedCollection;

public class Main {
    public static boolean checkEndsMatch(SequencedCollection<String> chars) {
        // Your code here

    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SequencedCollection<String> items = new ArrayDeque<>();

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                items.addAll(Arrays.asList(line.split("\\s+")));
            }
        }

        System.out.println(checkEndsMatch(items));
    }
}