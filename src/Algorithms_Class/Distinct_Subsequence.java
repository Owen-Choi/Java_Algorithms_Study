package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Distinct_Subsequence {
    static int testCase;
    static String X, Z;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        testCase = Integer.parseInt(br.readLine());
        while(testCase --> 0) {
            X = br.readLine();
            Z = br.readLine();
            dp = new int[X.length() + 1];
            dp[0] = 0;
            Find();
            sb.append(dp[X.length()-1]).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
    static void Find() {
        for(int i=1; i<X.length(); i++) {
            if(Z.charAt(0) == X.charAt(i)) {
                Check(i, 0, 0);
            }
            dp[i] = Math.max(dp[i-1], dp[i-1] + dp[i]);
        }
    }
    // This method should check and add all possible cases.
    static void Check(int StartIndex, int index, int count) {
        if(count == Z.length()) {
            dp[StartIndex]++;
            return;
        }
        for(int i=StartIndex; i<X.length(); i++) {
            if(X.charAt(i) == Z.charAt(index)) {
                // 이렇게 짜면 X: babgbag, Z: bag 같은 경우는 완벽히 동작하지만
                // X: rabbbit, Z: rabbit 같은 경우는 성립하지 않는다.
                Check(StartIndex, index+1, count+1);
            }
        }
    }
}
