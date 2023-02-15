package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Electronic_Cable {

    static int total;
    static int[] dp;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[500];
        Arrays.fill(map, -1);
        for(int i=0; i<total; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            map[second] = first;
        }

        dp = new int[500];

        // map은 B 전봇대에 해당, 즉 map[i]는 B전봇대의 i번에 연결된 A전봇대의 인덱스를 의미함.

        // dp 시작
        if(map[0] != -1) {
            dp[0] = 1;
        }
        for(int i=1; i<500; i++) {
            if(map[i] > map[i - 1]) {
                dp[i] = Math.max(dp[i] + 1, dp[i - 1] + 1);
            } else if(map[i] < map[i - 1]) {
                dp[i]++;
            }
        }

        // 완성된 dp 배열에서 최대값을 찾아준다.
        int max = 0;
        for(int i=0; i<500; i++) {
            if(dp[i] > max) {
                max = dp[i];
            }
        }

        // 우리는 B 전봇대를 기준으로 잡고 계산을 했지만, A 전봇대를 기준으로 잡고 계산을 하는 것이 최솟값일 경우가 있을 수도 있다.
        // 따라서 B 전봇대를 기준으로 구한 최댓값이 전체 전깃줄의 수를 반으로 나눈 값보다 커진다면 B 전봇대를 기준으로 구하는 것이 맞지만,
        // 그게 아니라면 A 전봇대를 기준으로 구하는 것이 맞다. 따라서 그런 경우에 한해서는 전체 전깃줄 개수에서 빼는 것이 정답이 아니라, 최댓값 그 자체가 정답이 된다.
        if( max > total / 2) {
            System.out.println(total - max);
        } else {
            System.out.println(max);
        }
    }
}
