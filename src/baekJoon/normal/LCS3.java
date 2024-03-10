package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS3 {
    static int lastResult = 0;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input1, input2, input3;
//        input1 = br.readLine();
//        input2 = br.readLine();
//        input3 = br.readLine();
//        int firstResult = 0;
//        String firstStr;
//        int[][] dp = new int[input1.length()+1][input2.length()+1];
//        for(int i=1; i<=input1.length(); i++) {
//            for(int k=1; k<=input2.length(); k++) {
//                if(input1.charAt(i-1) == input2.charAt(k-1)) {
//                    dp[i][k] = dp[i-1][k-1] + 1;
//                    if(firstResult <= dp[i][k]) {
//                        firstResult = dp[i][k];
//                        firstStr = input2.substring(0, k);
//                        // input1, input2 사이에서 찾은 LCS를 그대로 input3이랑 비교한다.
//                        findSecondLCS(firstStr, input3);
//                    }
//                }
//            }
//        }
//        System.out.println(lastResult);
//    }
//
//    public static void findSecondLCS(String str, String input3) {
//        // input1과 input2에서 찾은 공통 부분 문자열을 input3와 비교한다.
//        int[][] dp = new int[input3.length()+1][str.length()+1];
//        for(int i=1; i<=input3.length(); i++) {
//            for(int k=1; k<=str.length(); k++) {
//                if(input3.charAt(i-1) == str.charAt(k-1)) {
//                    dp[i][k] = dp[i-1][k-1] + 1;
//                    if(dp[i][k] > lastResult) {
//                        lastResult = dp[i][k];
//                    }
//                }
//            }
//        }
        // 완전 잘못 짚었다. 내가 구한건 연속하는 LCS이고, 기존 LCS는 다르게 구현된다.
        // 그리고 LCS는 해가 유일하지 않기 때문에, DP를 2번 하는건 안된다고 한다.
        // 따라서 3차원 DP를 활용해서 풀이해야 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1, input2, input3;
        input1 = br.readLine();
        input2 = br.readLine();
        input3 = br.readLine();
        int[][][] dp = new int[input1.length() + 1][input2.length() + 1][input3.length() + 1];
        for(int i=1; i<=input1.length(); i++) {
            for(int k=1; k<=input2.length(); k++) {
                for(int j=1; j<=input3.length(); j++) {
                    if(input1.charAt(i-1) == input2.charAt(k-1) && input2.charAt(k-1) == input3.charAt(j-1)) {
                        dp[i][k][j] = dp[i-1][k-1][j-1] + 1;
                    } else {
                        dp[i][k][j] = Math.max(dp[i-1][k][j], Math.max(dp[i][k-1][j], dp[i][k][j-1]));
                    }
                }
            }
        }
        System.out.println(dp[input1.length()][input2.length()][input3.length()]);
    }
}
