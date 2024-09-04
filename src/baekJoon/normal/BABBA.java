package baekJoon.normal;

import java.util.*;
import java.io.*;

public class BABBA {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        // B -> BA, A -> B
        // 규칙이 있을 것 같은데
        // dp[i][2] : i번 바꿨을 때 A와 B의 수
        // 꼭 복잡하게 풀지 않아도 dp 배열을 이용하는 것이면 다 dp라고 할 수 있지 뭐
        int[][] dp = new int[k+1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        int temp = 0;
        for(int i=2; i<=k; i++) {
            // A는 B로 바뀌니까 A의 수는 줄어들고, 그 수 만큼 B의 수가 증가한다.
            dp[i][0] = 0;
            temp = dp[i-1][0];
            // B는 BA로 바뀌기 때문에 B의 수 만큼 A가 늘어난다고 보면 된다.
            dp[i][0] += dp[i-1][1];
            dp[i][1] = dp[i-1][1];
            dp[i][1] += temp;
        }

        System.out.println(dp[k][0] + " " + dp[k][1]);
    }
}
