import java.util.Scanner;

class Rectangle {
    // area = l × w
    public static float area(String l, String w) {
        //Write your code here
        //...
        return; // return float here
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String l = scanner.next();
        String w = scanner.next();
        System.out.printf("%.0f", area(l, w));
    }
}