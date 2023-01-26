package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 11404 플로이드
public class Floyd {
    static int n, m;
    static int[][] arr;
    static final int INF = 10000005;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int k=0; k<n; k++) {
                if(i == k)
                    arr[i][k] = 0;
                else
                    arr[i][k] = INF;
            }
        }
        StringTokenizer st;
        int tempS, tempD;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            tempS = Integer.parseInt(st.nextToken());
            tempD = Integer.parseInt(st.nextToken());
            arr[tempS - 1][tempD - 1] = Math.min(Integer.parseInt(st.nextToken()), arr[tempS-1][tempD-1]);
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == INF)
                    arr[i][j] = 0;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
