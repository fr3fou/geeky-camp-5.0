import java.util.*;

public class HowMany {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");


        Map<Integer, Integer> numCount = new LinkedHashMap<>();

        for (String num : input) {
            if (numCount.containsKey(Integer.parseInt(num))) {
                int count = numCount.get(Integer.parseInt(num)) + 1;
                numCount.put(Integer.parseInt(num), count);
            } else {
                numCount.put(Integer.parseInt(num), 1);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, Integer> KvP : numCount.entrySet()) {
           sb.append(KvP.getKey() + " " + KvP.getValue() + " ");
        }

        System.out.println(sb.toString().trim());
    }
}
