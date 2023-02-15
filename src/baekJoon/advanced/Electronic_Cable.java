package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Electronic_Cable {

    static int total;
    static int[] dp;
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[total][2];
        for(int i=0; i<total; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            map[i][0] = first;
            map[i][1] = second;
        }

        dp = new int[500];

        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // dp 시작
        Arrays.fill(dp, 1);
        for(int i=0; i<total; i++) {
            for(int k=0; k<i; k++) {
                // A 전붓대의 입장에서, 자신보다 위에 위치하는 전선이 자신이 연결된 B 전봇대의 위치보다 더 아래쪽(더 큰 값)에 연결된다면
                // 선이 꼬이지 않는다. 이럴 경우 dp값을 업데이트 시켜준다.
                if(map[i][1] > map[k][1]) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }
            }
        }

        // 완성된 dp 배열에서 최대값을 찾아준다.
        int max = 0;
        for(int i=0; i<500; i++) {
            if(dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.println(total - max);
    }
}
