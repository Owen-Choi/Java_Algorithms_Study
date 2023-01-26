package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Cables_Of_Utility_Poles {
    static int N;
    static final int A = 0;
    static final int B = 1;
    static int[][] arr;
    static Integer[] dp;
    static int Max = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        dp = new Integer[N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][A] = Integer.parseInt(st.nextToken());
            arr[i][B] = Integer.parseInt(st.nextToken());
        }
        // 2차원 배열을 오름차순으로 정렬하는 방법
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i=0; i<N; i++) {
           Max = Math.max(Max, recur(i));
        }
        System.out.println(N - Max);
    }
    static int recur(int index){
        if(dp[index] == null){
            dp[index] = 1;
            for(int i=index+1; i<N; i++){
                if(arr[index][B] < arr[i][B]){
                    dp[index] = Math.max(dp[index], recur(i) + 1);
                }
            }
        }
        return dp[index];
    }
}
