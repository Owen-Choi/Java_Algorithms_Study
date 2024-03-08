package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 공통_부분_문자열 {

    static int result = 0;
    static String input1, input2;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        input1 = br.readLine();
//        input2 = br.readLine();
//        // 길이가 더 작은 문자열의 부분 문자열을 완전 탐색으로 찾은 다음 String 유틸을 활용해서 풀어보자.
//        if(input1.length() > input2.length()) {
//            sh = input2;
//            ln = input1;
//        } else {
//            sh = input1;
//            ln = input2;
//        }
//        for(int i=0; i<sh.length(); i++) {
//            for(int k=0; k<sh.length() - i; k++) {
//                String str = sh.substring(k, k+i);
//                if(ln.contains(str)) {
//                    result = Math.max(result, str.length());
//                }
//            }
//        }
//        System.out.println(result);
        // dp를 활용해서 다시 풀어보겠다.
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        input1 = br.readLine();
//        input2 = br.readLine();
//        int[][] dp = new int[input2.length()][input1.length()];
//        // 첫번째 행, 첫번째 열에 미리 데이터를 채워둔다.
//        for(int i=1; i<input2.length(); i++) {
//            // 행
//            // 문자가 일치하거나 이전 dp 배열이 1이라면 1로 동일하게 초기화
//            dp[i][0] = input2.charAt(i) == input1.charAt(0) ? 1 : dp[i-1][0] == 1 ? 1 : 0;
//        }
//        for(int i=0; i<input1.length(); i++) {
//            // 열
//            dp[0][i] = input1.charAt(i) == input2.charAt(0) ? 1 : 0;
//        }
//        for(int i=1; i<input2.length(); i++) {
//            for(int k=1; k<input1.length(); k++) {
//                // 대각선 위를 보는 이유는, 단순히 같은 알파벳이 나왔다고 바로 윗단계보다 1을 증가시켜 버리면
//                // 우리가 기대하는 결과가 나오지 않기 때문이다.
//                dp[i][k] = input2.charAt(i) == input1.charAt(k) ? dp[i-1][k-1] + 1 : dp[i-1][k];
//            }
//        }
//
//        for(int i=0; i<input2.length(); i++) {
//
//            for(int k=0; k<input1.length(); k++) {
//                System.out.print(dp[i][k] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println(dp[input2.length() - 1][input1.length() - 1]);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input1 = br.readLine();
        input2 = br.readLine();
        int[][] dp = new int[input1.length() + 1][input2.length() + 1];
        for (int i = 1; i <= input1.length(); i++) {
            for (int k = 1; k <= input2.length(); k++) {
                if (input1.charAt(i - 1) == input2.charAt(k - 1)) {
                    dp[i][k] = dp[i - 1][k - 1] + 1;
                    result = Math.max(result, dp[i][k]);
                }
            }
        }

        for (int i = 0; i < input1.length(); i++) {
            for (int k = 0; k < input2.length(); k++) {
                System.out.print(dp[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println(result);
    }
}