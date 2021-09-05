package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fresh_Salaryman {
    static int testCase;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        int pn;
        StringTokenizer st;
        while(testCase --> 0) {
            pn = Integer.parseInt(br.readLine());
            arr = new int[pn][2];
            for(int i=0; i<pn; i++) {
                st = new StringTokenizer(br.readLine()," ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            // 입력부 끝

        }
    }
}
