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

        long currentSeqLen = 1;
        long bestSeqLen = 0;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(i - 1)) {
                currentSeqLen = 1;
            } else {
                currentSeqLen++;
            }
            if (currentSeqLen > bestSeqLen) {
                bestSeqLen = currentSeqLen;
            }
        }

        System.out.println(bestSeqLen);
    }
}
