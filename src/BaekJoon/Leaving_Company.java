package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14501번
public class Leaving_Company {
    static int[] date;
    static int[] value;
    static int[] dp;
    static int Num;
    static int Max = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Num = Integer.parseInt(br.readLine());
        date = new int[Num + 10];
        value = new int[Num + 10];
        dp = new int[Num + 10];
        StringTokenizer st;
        for(int i=0; i<Num; i++){
            st = new StringTokenizer(br.readLine()," ");
            date[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<=Num; i++){
            dp[i] = Math.max(dp[i], Max);
            dp[i + date[i]] = Math.max(dp[i + date[i]], dp[i] + value[i]);
            Max = Math.max(dp[i], Max);
        }
        System.out.println(Max);
    }
}
