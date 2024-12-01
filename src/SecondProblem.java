import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondProblem {
    public static void main(String[] args) {

        List<Integer> leftList = new ArrayList<Integer>();
        List<Integer> rightList = new ArrayList<Integer>();

        ListCreator.createLists(leftList, rightList);

        int answer = 0;

        for (Integer left : leftList) {
            int repeatCounter = 0;

            for (Integer right : rightList) {
                if ((int)left == right) {
                    repeatCounter++;
                }
            }

            answer += left * repeatCounter;
        }

        System.out.println(answer);
    }
}
