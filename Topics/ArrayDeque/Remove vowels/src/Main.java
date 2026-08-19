import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public static String removeVowels(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (!isVowel(ch)) {
                ...
            }
        }

        StringBuilder result = new StringBuilder(deque.size());
        while (!deque.isEmpty()) {
            ...
        }

        return result.toString();
    }

    private static boolean isVowel(char ch) {
        return VOWELS.contains(Character.toLowerCase(ch));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        System.out.println(removeVowels(inputStr));
    }
}