package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

// 레벨3, 인사고과
public class Section_of_personnel {

    public static void main(String[] args) {
        int[][] scores = new int[5][2];
        scores[0][0] = 2;   scores[0][1] = 2;
        scores[1][0] = 1;   scores[1][1] = 4;
        scores[2][0] = 3;   scores[2][1] = 2;
        scores[3][0] = 3;   scores[3][1] = 2;
        scores[4][0] = 2;   scores[4][1] = 1;


        System.out.println(solution(scores));
    }



    public static int solution(int[][] scores) {
        // 등수이기 때문에 0부터 시작이 아니라 1부터 시작한다.
        int answer = 1;
        int maximum = Integer.MIN_VALUE;
        int wonhoAttitudeScore = scores[0][0];
        int wonhoPeer = scores[0][1];

        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });

        for(int i=0; i<scores.length; i++) {
            if(maximum < scores[i][1]) {
                maximum = scores[i][1];
            }

            // scores[i][1]이 현재 가장 큰 값보다 작다면 :
            if(maximum > scores[i][1]) {
                // 그 작은 점수가 원호의 점수인지 먼저 확인. 원호의 점수라면 -1을 반환해야 한다.
                if(wonhoAttitudeScore == scores[i][0] && wonhoPeer == scores[i][1]) {
                    return -1;
                } else {
                    // 원호의 점수가 아니라면 아래의 조건문이 실행되선 안되므로 continue한다.
                    continue;
                }
            }
            if(wonhoAttitudeScore + wonhoPeer < scores[i][0] + scores[i][1])
                answer++;
        }

        return answer;
    }
}
