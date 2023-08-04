package programmers_real.level2;

import java.util.Arrays;

public class Thaad {

    public static void main(String[] args) {
        int[][] target = {{4,5}, {4,8}, {10,14}, {11,13}, {5,12}, {3,7}, {1,4}};
        System.out.println(solution(target));
    }

    public static int solution(int[][] target) {
        int answer = 0;
        int endPoint = 0;
        Arrays.sort(target, ((o1, o2) -> o1[1] - o2[1]));
        for(int i=0; i< target.length; i++) {
            int start = target[i][0];
            int end = target[i][1];

            if(endPoint <= start) {
                endPoint = end;
                answer++;
            }
        }
        return answer;
    }
}
