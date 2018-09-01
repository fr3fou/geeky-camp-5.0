import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plateau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if(input.length() == 1) {
            System.out.println(1);
            return;
            }

        List<Character> numbs = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbs.add(Character.toLowerCase(input.charAt(i)));
        }

        long currentSeqLen = 1;
        long bestSeqLen = 0;

        for (int i = 1; i < numbs.size(); i++) {
            if (numbs.get(i) != numbs.get(i - 1)) {
                currentSeqLen = 1;
            } else {
                currentSeqLen++;
            }
            if (currentSeqLen > bestSeqLen) {
                bestSeqLen = currentSeqLen;
            } else {
                bestSeqLen = bestSeqLen;
            }
        }

        System.out.println(bestSeqLen);
    }
}

