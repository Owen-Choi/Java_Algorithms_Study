package programmers.level2;

import java.util.*;

public class Tangerine_Selecting {

    public static void main(String[] args) {
        int[] tangerine = {1,2,3,4,5,6,7};
        int k = 1;
        System.out.println(solution(k, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
//        int[] indexes = new int[tangerine.length];
//        // 오답 원인 : 크기로 주어진 정수가 배열의 길이보다 작다는 보장이 없음.
//        for (int i : tangerine) {
//            indexes[i - 1]++;
//        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i - 1, map.getOrDefault(i - 1, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        int count = 0;
        while(k > 0) {
            k -= list.get(count);
            count++;
        }
        return count;
    }
}
