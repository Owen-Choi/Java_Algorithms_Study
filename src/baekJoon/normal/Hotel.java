package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1106번
public class Hotel {
    static int goal, city_num;
    static int [][] city_info;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        goal = Integer.parseInt(st.nextToken());
        city_num = Integer.parseInt(st.nextToken());
        city_info = new int[city_num + 1][2];
        dp = new int[goal + 1];
        for(int i = 1; i <= city_num; i++) {
            st = new StringTokenizer(br.readLine()," ");
            // index 0은 비용
            city_info[i][0] = Integer.parseInt(st.nextToken());
            // index 1은 인원
            city_info[i][1] = Integer.parseInt(st.nextToken());
        }
        // Input ends
        // Dynamic programming
        Solve(goal);
    }
    static void Solve(int index) {
        if(index <= 0) {

        }
    }
}
