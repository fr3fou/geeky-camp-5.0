import java.util.Scanner;

public class Champion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        if(input.length == 1) {
            System.out.println(input[0] + " " + 1);
            return;
        }


        int[] numbs = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbs[i] = Integer.parseInt(input[i]);
        }

        int currentSeqLen = 1;
        int currentSeqIndex = 0;

        int bestSeqLen = 0;

        int champion = numbs[0];

        for (int i = 1; i < numbs.length; i++) {
            if (numbs[i] == numbs[i - 1]) {
                currentSeqLen++;
            } else {
                currentSeqIndex = i;
                currentSeqLen = 1;
            }
            if (currentSeqLen > bestSeqLen || (champion >= numbs[currentSeqIndex] && currentSeqLen == bestSeqLen)) {
                bestSeqLen = currentSeqLen;
                champion = numbs[currentSeqIndex];
            }
        }

        System.out.println(champion + " " + bestSeqLen);
    }
}
