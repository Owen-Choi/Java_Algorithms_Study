package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 1697번
// 이제 그냥 bfs 하면 일단 queue부터 떠올리고 보자.
public class Hide_and_Seek {
    static int Subin, brother, result;
    static int[] dp;
    static final int MAX = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());
        System.out.println(Solve());
    }
    static int Solve() {
        int tempPos;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(Subin);
        dp = new int[MAX];
        dp[Subin] = 1;
        while(!queue.isEmpty()) {
            tempPos = queue.poll();
            if(tempPos == brother) {
                return dp[tempPos] - 1;
            }
            //무조건 먼저 들어가있는 값이 작게 되는 시스템이기 때문에 Math.min 함수를 사용할 필요가 없다.
            if(tempPos <= MAX - 2 && dp[tempPos + 1] == 0) {
                dp[tempPos + 1] = dp[tempPos] + 1;
                queue.add(tempPos + 1);
            }
            if(tempPos >= 1 && dp[tempPos - 1] == 0) {
                dp[tempPos - 1] = dp[tempPos] + 1;
                queue.add(tempPos - 1);
            }
            if(tempPos*2 <= MAX - 1 && dp[tempPos * 2] == 0) {
                dp[tempPos*2] = dp[tempPos] + 1;
                queue.add(tempPos * 2);
            }
        }
        return -1;
    }

}
