package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 2630번
public class Making_ColorPaper {
    static int N;
    static int[][] arr;
    static int White = 0, Blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int k=0; k<N; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        if(check(0,0,N)) {
            if(arr[0][0] == 1) {
                System.out.println(0);
                System.out.println(1);
            }
            else {
                System.out.println(1);
                System.out.println(0);
            }
            System.exit(0);
        }
        recur(0,0,N);
        System.out.println(White);
        System.out.println(Blue);
    }
    // 행과 열의 시작점, N의 크기가 주어짐
    static void recur(int raw, int col, int size){
        // 종료 컨디션
        if(size == 1) {
            if(arr[raw][col] == 1)
                Blue++;
            else
                White++;
            return;
        }

        int temp = size/2;
        for(int i = raw; i < raw + size; i += temp) {
            for(int k = col; k < col + size; k += temp) {
                if(check(i, k, temp)) {
                    if(arr[i][k] == 1)
                        Blue++;
                    else
                        White++;
                }
                else {
                    recur(i,k,temp);
                }
            }
        }
    }
    // 네모 안의 색이 모두 같은지 검사하는 함수
    static boolean check(int x, int y, int size) {
        int temp = arr[x][y];
        for(int i = x; i < x + size; i++) {
            for(int k = y; k < y + size; k++) {
                if(arr[i][k] != temp)
                    return false;
            }
        }
        return true;
    }
}
