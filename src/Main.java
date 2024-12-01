import java.util.*;

public class Main {
    public static void main(String[] args) {

        //PART ONE
        Scanner sc = new Scanner(System.in);
        List<Integer> leftList = new ArrayList<Integer>();
        List<Integer> rightList = new ArrayList<Integer>();

        System.out.println("Paste your input and hit 'Enter' 2 times!");

        while (sc.hasNextLine()) {
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                break;
            }

            String[] inputArr = input.split("\\s+");

            leftList.add(Integer.parseInt(inputArr[0]));
            rightList.add(Integer.parseInt(inputArr[1]));
        }

        Collections.sort(leftList);
        Collections.sort(rightList);
        int answer = 0;

        for (int i = 0; i < leftList.size(); i++) {
            int leftInt = leftList.get(i);
            int rightInt = rightList.get(i);

            answer += Math.max(leftInt, rightInt) - Math.min(leftInt, rightInt);
        }

        System.out.println(answer);
    }
}