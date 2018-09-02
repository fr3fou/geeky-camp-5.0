import java.util.Scanner;

public class PatternMatcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String s = input[0];
        String p = input[1];

        System.out.println(s.contains(p));
    }
}
