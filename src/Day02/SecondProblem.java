package Day02;

import java.util.ArrayList;
import java.util.List;

import static Day02.Helper.isSafe;
import static Day02.Helper.listCreator;

public class SecondProblem {
    public static void main(String[] args) {

        List<List<Integer>> numbersList = new ArrayList<>();

        //fill the list from console
        listCreator(numbersList);

        int safe = 0;

        for (List<Integer> numbers: numbersList) {
            //check if the numbers are safe
            if (isSafe(numbers, true)) {
                safe++;
            }
        }

        System.out.println(safe);
    }
}
