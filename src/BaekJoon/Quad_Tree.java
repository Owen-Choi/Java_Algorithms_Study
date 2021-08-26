package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1992번
public class Quad_Tree {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int [][] arr;

    //범위 내의 값을 확인하는 함수
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
        int i = 0;
        String temp;
        while(i != N) {
            temp = br.readLine();
            for(int k=0; k<temp.length(); k++)
                arr[i][k] = temp.charAt(k) - '0';       //char형인 숫자를 정수로 바꾸는 방법
            i++;
        }

        // 전체 범위를 먼저 검사해주고, return 값이 false라면 분할에 들어간다.
        if(check(0,0,N)){
            if(arr[0][0] == 0)
                System.out.println(0);
            else
                System.out.println(1);
            System.exit(0);
        }
        sb.append("(");
        recur(0,0,N);
        sb.append(")");
        System.out.println(sb);
        br.close();
    }
    static void recur(int raw, int col, int size) {
        if(size == 1) {
            if(arr[raw][col] == 0)
                sb.append(0).append(")");
            else
                sb.append(1).append(")");
            return;
        }
        int halfSize = size/2;
        for(int i = raw; i < raw + size; i += halfSize) {
            for(int k = col; k < col + size; k += halfSize) {
                if(check(i, k, halfSize)) {
                    if(arr[i][k] == 0)
                        sb.append(0);
                    else
                        sb.append(1);
                }
                else {
                    sb.append("(");
                    recur(i, k, halfSize);
                    sb.append(")");
                }
            }
        }
    }
}
