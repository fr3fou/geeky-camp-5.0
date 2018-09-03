import java.util.Scanner;

public class PatternMatcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String s = input[0];
        String p = input[1];

        if (p.matches("^[*]*$")) {
            System.out.println(true);
            return;
        }

        if (p.charAt(0) == '*') {
            p = p.substring(1);
        }

        if (p.charAt(p.length() - 1) == '*') {
            p = p.substring(0, p.length() - 1);
        }

        System.out.println(findMatch(s, p, 0, 0));

    }

    public static Boolean findMatch(String s, String p, int i, int j) {
        if (i < s.length() && j == p.length() - 1 && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
            return true;
        }

        if (i >= s.length() || j >= p.length()) {
            return false;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return findMatch(s, p, i + 1, j + 1);
        }

        if (p.charAt(j) == '*') {
            boolean isMatch = false;

            int offset = 0;
            while (p.charAt(j + offset) == '*') {
                offset++;
            }

            for (int k = 0; k < p.length(); k++) {
                isMatch = isMatch | findMatch(s, p, i + k, j + offset);
            }

            return isMatch;
        }

        // if there is no match yet, call again
        return findMatch(s, p, i + 1, 0);
    }
}
