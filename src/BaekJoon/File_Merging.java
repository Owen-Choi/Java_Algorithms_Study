package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class File_Merging {
    static int testCase;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(testCase --> 0) {
            int files = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            int arr[] = new int[files + 1];
            int dp[][] = new int[files + 1][files + 1];
            int sum[] = new int[files + 1];
            for(int i=1; i<=files; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1] + arr[i];
            }
            for(int n = 1; n <= files; n++){
                for(int Start = 1; Start + n <= files; Start++) {
                    int Finish = Start + n;
                    dp[Start][Finish] = Integer.MAX_VALUE;
                    for(int Divide = Start; Divide < Finish; Divide++)
                        dp[Start][Finish] = Math.min(dp[Start][Finish], dp[Start][Divide] + dp[Divide+1][Finish] + sum[Finish] - sum[Start - 1]);
                }
            }
            sb.append(dp[1][files]).append('\n');
        }
        System.out.println(sb);
    }
}
