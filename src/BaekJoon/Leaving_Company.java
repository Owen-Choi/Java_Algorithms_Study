package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 14501번
public class Leaving_Company {
    static int Input;
    static int[][] arr;
    static int[] dp;
    static final int END_DATE = 0;
    static final int VALUE = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        arr = new int[Input + 1][2];
        dp = new int[Input + 1];
        for(int i = 1; i<=Input; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][END_DATE] = Integer.parseInt(st.nextToken());
            arr[i][VALUE] = Integer.parseInt(st.nextToken());
        }
        int tempVal;
        for(int i=1; i<=Input; i++){
            tempVal = 0;
            for(int k=i; k<=Input; k = arr[k][END_DATE] == 1 ? k + 1 : k + arr[k][END_DATE]){
                if(k + arr[k][END_DATE] > Input + 1)
                    continue;
                tempVal += arr[k][VALUE];
            }
            dp[i] = tempVal;
        }

        Arrays.sort(dp);
        System.out.println(dp[dp.length - 1]);
    }

}
