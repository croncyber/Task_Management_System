import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SequencedCollection;

public class Main {
    public static SequencedCollection<String> transferBackwards(SequencedCollection<String> source, SequencedCollection<String> destination) {
        // Your code here

    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SequencedCollection<String> source = new ArrayDeque<>();
        SequencedCollection<String> dest = new ArrayDeque<>();

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                source.addAll(Arrays.asList(line.split("\\s+")));
            }
        }

        SequencedCollection<String> result = transferBackwards(source, dest);
        System.out.println(result);
    }
}