package woj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColorPaper {
    public static void main(String[] args) throws IOException {
        int n;
        int[][] arr = new int[101][101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int x, y;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            for(int k=x; k<x+10; k++) {
                for(int j=y; j<y+10; j++) {
                    arr[k][j] = 1;
                }
            }
        }

        int result = 0;
        for(int i=1; i<=100; i++) {
            for(int k=1; k<=100; k++) {
                if(arr[i][k] == 1)
                    result++;
            }
        }
        System.out.println(result);
    }
}
