package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9663번
public class N_Queen_Retry {
    static int N;
    static int[][] queen;
    // 칼럼은 겹칠 수가 없음. 재귀에서 바로 다음으로 넘어가기 때문
    static boolean[] Raw_check;
    static boolean[] INC_Cross_Check;
    static boolean[] DCS_Cross_Check;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queen = new int[N][N];
        Raw_check = new boolean[N];
        INC_Cross_Check = new boolean[N*2 - 1];
        DCS_Cross_Check = new boolean[N*2 - 1];
        recur(0,0);
        System.out.println(result);
    }
    static void recur(int col, int Count){

        if(Count == N){
            result++;
            return;
        }

        for(int i=0; i<N; i++){
            if(!Raw_check[i]){
                if(!Cross_Check(i, col)){
                    Raw_check[i] = true;
                    INC_Cross_Check[(2*N-2) - (i+col)] = true;
                    DCS_Cross_Check[col - i +N-1] = true;
                    recur(col+1, Count+1);
                    Raw_check[i] = false;
                    INC_Cross_Check[(2*N-2) - (i+col)] = false;
                    DCS_Cross_Check[col - i+N-1] = false;
                }
            }
        }
    }
    static boolean Cross_Check(int X, int Y){
        if(INC_Cross_Check[(2*N-2) - (X+Y)] || DCS_Cross_Check[Y-X+N-1])
            return true;
        else
            return false;
    }
}
