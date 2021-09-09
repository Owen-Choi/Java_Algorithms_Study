package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Smart_Elephant {
    static int [][] arr = new int[1001][2];
    static int[][] dp = new int[1001][1001];
    static int [][] arr_copy = new int[1001][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int iter = 0;
        String EOF = "";
        while((EOF = br.readLine()) != null) {
            if(EOF.equals("."))
                break;
            st = new StringTokenizer(EOF, " ");
            arr[iter][0] = Integer.parseInt(st.nextToken());
            arr[iter++][1] = Integer.parseInt(st.nextToken());
            // 입력부 종료
        }

        /*Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });*/
        Find(iter);
        for(int i=0; i<iter; i++) {
            for(int k=0; k<iter; k++) {
                System.out.print(dp[i][k] + " ");
            }
            System.out.println();
        }


    }

    static void Find(int size) {
        for(int i=0; i<size; i++) {
            for(int k=0; k<size; k++) {
                if(arr[i][0] < arr[k][0] && arr[i][1] > arr[k][1]) {
                    for(int j=i; j<size; j++) {
                        dp[j][k] += 1;
                    }
                }
            }
        }
    }
}
