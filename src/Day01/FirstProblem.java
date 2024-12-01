package Day01;

import java.util.*;

public class FirstProblem {
    public static void main(String[] args) {

        List<Integer> leftList = new ArrayList<Integer>();
        List<Integer> rightList = new ArrayList<Integer>();

        ListCreator.createLists(leftList, rightList);

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