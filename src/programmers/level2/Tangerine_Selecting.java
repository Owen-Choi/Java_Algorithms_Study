package programmers.level2;

import java.util.Arrays;
import java.util.Collections;

public class Tangerine_Selecting {

    public static void main(String[] args) {
        int[] tangerine = {1, 1, 1, 1, 1};
        int k = 1;
        System.out.println(solution(k, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
        int[] indexes = new int[tangerine.length];
        for (int i : tangerine) {
            indexes[i - 1]++;
        }
        int count = 0;
        Arrays.sort(indexes);
        while(k > 0) {
            k -= indexes[tangerine.length - count - 1];
            count++;
        }
        return count;
    }
}
