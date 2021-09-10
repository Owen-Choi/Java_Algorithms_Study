package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Smart_Elephant{
    static int iter = 0;
     static int [][] arr = new int[1001][4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int[] ints : arr) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        String EOF = "";
        while ((EOF = br.readLine()) != null) {
            if (EOF.equals("."))
                break;
            st = new StringTokenizer(EOF, " ");
            arr[iter][0] = Integer.parseInt(st.nextToken());
            arr[iter][1] = Integer.parseInt(st.nextToken());
            arr[iter][3] = iter++;
            // 입력부 종료
        }
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        //정렬 완료
        int [] dp = new int[iter];
        int [] indexes = new int[iter];
        int index = 0;
        Arrays.fill(dp, 1);
        for(int i=0; i<iter; i++) {
            for(int k=0; k<i; k++) {
                if(arr[i][0] > arr[k][0] && arr[i][1] < arr[k][1] && dp[i] < dp[k] + 1) {
                    dp[i] = dp[k] + 1;
                    if(index == 0) {
                        indexes[index++] = k;
                        indexes[index++] = i;
                    }
                    else if(indexes[index-1] == k) {
                        indexes[index++] = i;
                    }
                }
            }
        }
        int Max = -1;
        for(int i=0; i<iter; i++) {
            Max = Math.max(Max, dp[i]);
        }
        System.out.println(Max);
        for(int i=0; i<Max; i++) {
            System.out.println(arr[indexes[i]][3] + 1);
        }
    }

}
