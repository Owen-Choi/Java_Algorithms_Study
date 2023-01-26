package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 10844번
public class Easy_StairNum {
    static int Input;
    static final long M = 1000000000l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        Long[][] dp = new Long[Input][10];
        dp[0][0] = 0l;
        for(int i=1; i<10; i++)
            dp[0][i] = 1l;
        for(int i=1; i<Input; i++){
            for(int k=0; k<10; k++){
                if(k == 0)
                    dp[i][k] = dp[i-1][1] % M;      //1로 끝나는 case만
                else if(k == 9)
                    dp[i][k] = dp[i-1][8] % M;      //8로 끝나는 case만
                else
                    dp[i][k] = (dp[i-1][k+1] + dp[i-1][k-1])%M;
            }
        }
        long result = 0;
        for(int i=0; i<10; i++){
            result += dp[Input-1][i];
        }
        result %= M;
        System.out.println(result);
    }
}
