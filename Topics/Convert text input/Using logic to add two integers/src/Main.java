import java.util.Scanner;

class IfTrueAdd {

    public static int checkOperator(String b, String si, String sj) {
        // Write your code here
        // ...

        // Do not change this code
        if (operator) {
            return i + j;
        } else {
            return i - j;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operator = scanner.next();
        String i = scanner.next();
        String j = scanner.next();
        System.out.printf("%d", checkOperator(operator, i, j));     
    }
}