import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Unique {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Character>  chars = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if(chars.contains(input.charAt(i))) {
                System.out.println("false");
                return;
            } else {
                chars.add(input.charAt(i));
            }
        }



        System.out.println("true");
    }
}
