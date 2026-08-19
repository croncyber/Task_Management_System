import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static String reverseString(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        // Push all characters of the string onto the stack
        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder reversed = new StringBuilder(s.length());
        while (!stack.isEmpty()) {
            // Pop the characters off the stack and append them to the result
            ...
        }
        ...
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        System.out.println(reverseString(inputStr)); 
    }
}