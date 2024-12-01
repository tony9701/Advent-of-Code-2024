package Day01;

import java.util.List;
import java.util.Scanner;

public class ListCreator {
    public static void createLists(List<Integer> listOne, List<Integer> listTwo) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Paste your input and hit 'Enter' 2 times!");

        while (sc.hasNextLine()) {
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                break;
            }

            String[] inputArr = input.split("\\s+");

            listOne.add(Integer.parseInt(inputArr[0]));
            listTwo.add(Integer.parseInt(inputArr[1]));
        }
    }
}
