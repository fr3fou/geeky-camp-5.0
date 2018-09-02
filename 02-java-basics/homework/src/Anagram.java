import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().toLowerCase().split(" ");

        char[] firstCharArr = input[0].toCharArray();
        char[] secondCharArr = input[1].toCharArray();

        List<Character> first = new ArrayList<>();
        List<Character> second = new ArrayList<>();

        for (char letter : firstCharArr) {
            if(letter > 97 && letter < 125) {
                first.add(letter);
            }
        }

        for (char letter : secondCharArr) {
            if(letter > 97 && letter < 125) {
                second.add(letter);
            }
        }

        if(first.size() != second.size()) {
            System.out.println("false");
            return;
        }

        for (int i = 0; i < first.size(); i++) {
            if(second.contains(first.get(i)) == false) {
                System.out.println("false");
                return;
            }
        }

        System.out.println("true");
    }
}
