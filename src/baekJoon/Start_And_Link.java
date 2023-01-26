package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14889번
public class Start_And_Link {
    static int N;
    static int[][] arr;
    static boolean[] flag;
    static int[] True;
    static int[] False;
    static int MinValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        flag = new boolean[N];
        True = new int[N/2];
        False = new int[N/2];
        int i = 0;

        for(i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        Combination(0,0);
        System.out.println(MinValue);
    }
    static void Combination(int count, int index){
        int j, k;
        j = k = 0;
        if(count == N/2){
            MinValue = Math.min(MinValue, Min_Calc());
            return;
        }

        for(int i = index; i<N; i++){
            if(!flag[i]){
                flag[i] = true;
                Combination(count + 1, i + 1);
                flag[i] = false;
            }
        }
    }

    static int Min_Calc() {

        int TrueTeam = 0;
        int FalseTeam = 0;
        /*for (int i = 0; i < N; i++) {
            if (flag[i]) {
                True[j] = i;
                j++;
            } else if (!flag[i]) {
                False[k] = i;
                k++;
            }
        }

            for(int i=0; i<N/2; i++){
                for(int p=0; p<N/2; p++){
                    TrueTeam += arr[True[i]][True[p]];
                    FalseTeam += arr[False[i]][False[p]];
                }
            }*/

        for (int i = 0; i < N; i++) {
            for (int p = 0; p < N; p++) {
                if (flag[i] && flag[p]) {
                    TrueTeam += arr[i][p];
                }
                if (!flag[i] && !flag[p]) {
                    FalseTeam += arr[i][p];
                }
            }
        }
        int Minus = Math.abs(TrueTeam - FalseTeam);
        return Minus;
    }
}
