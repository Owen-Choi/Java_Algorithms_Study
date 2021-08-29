package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1780번
public class The_Number_Of_Papers {
    static int N;
    static int [][] arr;
    static int Minus = 0, Zero = 0, One = 0;
    // 주어진 범위를 확인하는 함수
    static boolean check(int x, int y, int size) {
        for(int i = x; i < x + size; i++) {
            for(int k = y; k < y + size; k++) {
                if(arr[i][k] != arr[x][y])
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int k=0; k<N; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        // 여기까지 입력을 받음
        // 종이가 한 종류로만 통일되어있을 경우
        if(check(0,0, N)) {
            if(arr[0][0] == -1)
                Minus++;
            else if(arr[0][0] == 0)
                Zero++;
            else
                One++;
            System.out.println(Minus);
            System.out.println(Zero);
            System.out.println(One);
            System.exit(0);
        }
        recur(0,0,N);
        System.out.println(Minus);
        System.out.println(Zero);
        System.out.println(One);
    }
    static void recur(int raw, int col, int size) {
        if(size == 1) {
            if(arr[raw][col] == -1)
                Minus++;
            else if(arr[raw][col] == 0)
                Zero++;
            else
                One++;
            return;
        }
        int newSize = size/3;
        for(int i=raw; i < raw + size; i+=newSize) {
            for(int k=col; k < col + size; k+=newSize) {
                if(check(i,k,newSize)) {
                    if(arr[i][k] == -1)
                        Minus++;
                    else if(arr[i][k] == 0)
                        Zero++;
                    else
                        One++;
                }
                else {
                    recur(i,k,newSize);
                }
            }
        }
    }
}
