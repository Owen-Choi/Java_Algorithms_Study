package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1010번
public class Building_Bridge {
    static int N,M;
    static int testCase;
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(testCase > 0) {
            testCase--;
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sb.append(recur(M,N) + "\n");
        }
        System.out.println(sb);
    }
    // 조합 공식. 파스칼의 삼각형. 꼭 기억해두고 내일 이항계수 문제 풀어보기
    static int recur(int X, int Y) {
        if(dp[X][Y] > 0)
            return dp[X][Y];

        if(Y == 0 || X == Y)
            return dp[X][Y] = 1;

        return dp[X][Y] = recur(X-1, Y-1) + recur(X-1, Y);
    }
}
