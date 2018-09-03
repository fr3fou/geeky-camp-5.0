import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PatternMatcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        if (input.length != 2) {
            System.out.println(true);
            return;
        }

        String s = input[0];
        String p = input[1];

        // we can just do a normal ".contains" if there are no special characters
        if (p.contains("*") || p.contains("?")) {
            System.out.println(findMatch(s, p));
        } else {
            System.out.println(s.contains(p));
        }

    }

    public static Boolean findMatch(String text, String pattern) {

        
//        // fuck this lmao
//        pattern = pattern.replace('?', '.');
//        pattern = pattern.replaceAll("\\*", ".*");
//
//        return text.matches(pattern);
    }


}
