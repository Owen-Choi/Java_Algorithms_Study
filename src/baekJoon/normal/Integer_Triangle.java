package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1932번
public class Integer_Triangle{
    static int Input;
    static Integer[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        arr = new int[Input][Input];
        dp = new Integer[Input][Input];
        arr[0][0] = Integer.parseInt(br.readLine());
        for (int i = 1; i < Input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < i + 1; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i < Input; i++){
            dp[Input-1][i] = arr[Input-1][i];
        }
        System.out.println(recur(0,0));
    }
    static int recur(int depth, int index){
        if(depth == Input - 1){
            return dp[depth][index];
        }   //dp는 arr과는 반대로 채워지기 때문에 바로 오른쪽의 인덱스와 비교를 해도 상관없다.
        if(dp[depth][index] == null)
            dp[depth][index] = Math.max(recur(depth+1, index), recur(depth+1, index+1)) + arr[depth][index];
        return dp[depth][index];
    }
}