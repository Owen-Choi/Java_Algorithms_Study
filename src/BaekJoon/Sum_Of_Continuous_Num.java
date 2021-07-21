package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1912번
public class Sum_Of_Continuous_Num {
    static int Input;
    static int[] arr;
    static Integer[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        arr = new int[Input];
        dp = new Integer[Input];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < Input; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        max = arr[0];
        recur(Input - 1);
        System.out.println(max);
    }

    static int recur(int index) {
        if (dp[index] == null) {
            dp[index] = Math.max(recur(index - 1) + arr[index], arr[index]);
            max = Math.max(dp[index], max);
        }
        return dp[index];
    }
}
