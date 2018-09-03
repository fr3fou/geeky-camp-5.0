import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BullsAndCows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cows & Bulls!");
        System.out.print("Input digit amount: ");
        int digitLength = Integer.parseInt(scanner.nextLine());
        Game game = new Game(digitLength);

        System.out.println("The computer has generated a random " + digitLength + " digit long number.");
        System.out.println("Your goal is to try and guess the number by the hints given.");
        System.out.println("The input mustn't have duplicate digits and be exactly " + digitLength + " digits long.");

        int attemptCounter = 0;
        while (game.getCorrect() == false) {
            System.out.print("Your guess is: ");
            String input = scanner.nextLine();
            try {
                game.setNumber(input);
            } catch (Exception e) {
                System.out.println("Invalid input! Try again...");
                continue;
            }
            game.guess();
            attemptCounter++;

            if(game.getCorrect()) {
                break;
            }

            System.out.println(game.getCowsAmount() + " cow(s) " + game.getBullsAmount() + " bull(s)");
        }

        System.out.println("4 Bulls! You win!");
        System.out.println("It took " + attemptCounter + " attempts!");
    }

}


class Game {

    // --------------- ----------- ---------------
    // --------------- F I E L D S ---------------
    // --------------- ----------- ---------------

    private Boolean isCorrect = false;

    private int cowsAmount;
    private int bullsAmount;

    private int digitLength;
    private String number;
    private final String generatedNumber;

    // --------------- --------------------- ---------------
    // --------------- C O N S T R U C T O R ---------------
    // --------------- --------------------- ---------------

    public Game(int length) {
        this.digitLength = length;
        this.generatedNumber = Utility.generateNumber(digitLength);
    }

    // --------------- ------------- --------------
    // --------------- M E T H O D S ---------------
    // --------------- ------------- ---------------

    public void guess() {
        // Reset bulls and cows to clear the state from the previous search
        this.bullsAmount = 0;
        this.cowsAmount = 0;

        // Search for matching cows and bulls
        findCows();
        findBulls();

        // If all bulls (numbers) have been found, then user has guessed correctly
        this.isCorrect = (this.bullsAmount == this.digitLength);
    }

    private void findCows() {
        // We use a LinkedList to remove the already found numbers
        List<Character> temp = new LinkedList<>();
        for (char letter : this.generatedNumber.toCharArray()) {
            temp.add(letter);
        }

        for (int i = 0; i < this.number.length(); i++) {
            for (int j = 0; j < temp.size(); j++) {
                if(this.number.charAt(i) == temp.get(j)) {
                    this.cowsAmount++;
                    temp.remove(j);
                    break;
                }
            }
        }
    }

    private void findBulls() {
        for (int i = 0; i < this.generatedNumber.length(); i++) {
            if (this.number.charAt(i) == this.generatedNumber.charAt(i)) {
                this.bullsAmount++;
            }
        }
    }

    // --------------- --------------- ---------------
    // --------------- M U T A T O R S ---------------
    // --------------- --------------- ---------------

    public void setNumber(String number) throws Exception {
        // Prevents invalid input (make sure the length is the exact same and there are only numbers)
        if (number.length() == this.generatedNumber.length() && number.matches("^[0-9]+$") && Utility.IsNumberUnique(number)) {
            this.number = number;
        } else {
            throw new Exception("Invalid input exception.");
        }
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public int getCowsAmount() {
        return cowsAmount;
    }

    public int getBullsAmount() {
        return bullsAmount;
    }

    // --------------- -------------------------- ---------------
    // --------------- S T A T I C  C L A S S E S ---------------
    // --------------- -------------------------- ---------------

    private static class Utility {

        public static String generateNumber(int length) {
            StringBuilder sb = new StringBuilder(length);

            while (sb.length() < length) {
                String generatedDigit = Integer.toString((int) (Math.random() * 10));
                if (sb.indexOf(generatedDigit) == -1) {
                    sb.append(generatedDigit);
                }
            }

            return sb.toString();
        }

        public static boolean IsNumberUnique(String str) {
            List<Character> nums = new ArrayList<>();

            for (int i = 0; i < str.length(); i++) {
                if (nums.contains(str.charAt(i))) {
                    return false;
                } else {
                    nums.add(str.charAt(i));
                }
            }
            return true;
        }
    }
}





