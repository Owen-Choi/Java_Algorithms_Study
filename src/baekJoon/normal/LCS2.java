package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        int[][] dp = new int[input2.length() + 1][input1.length() + 1];
        for (int i = 1; i < input2.length() + 1; i++) {
            for (int k = 1; k < input1.length() + 1; k++) {
                if (input2.charAt(i - 1) == input1.charAt(k - 1)) {
                    dp[i][k] = dp[i - 1][k - 1] + 1;
                } else {
                    dp[i][k] = Math.max(dp[i - 1][k], dp[i][k - 1]);
                }
            }
        }

        // 인덱스 추적.
        int i = input2.length(), k = input1.length();
        StringBuilder sb = new StringBuilder();
        while (i != 0 && k != 0) {
            // 아래의 조건문에 해당돼도 정답이 아닌 것이 있다고 한다.
            // 그렇기 때문에 여기서 바로 출력해주면 오답이다.
//            if (input2.charAt(i - 1) == input1.charAt(k - 1)) {
//                sb.append(input2.charAt(i - 1));
//            }
            if (dp[i - 1][k] == dp[i][k]) {
                i--;
            } else if (dp[i][k - 1] == dp[i][k]) {
                k--;
            } else {
                sb.append(input2.charAt(i - 1));
                i--;
                k--;
            }
        }
        System.out.println(dp[input2.length()][input1.length()]);
        System.out.println(sb.reverse().toString());
    }
}
