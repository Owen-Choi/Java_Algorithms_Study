package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11758
public class CCW {
    static int[][] P = new int[3][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            P[i][0] = Integer.parseInt(st.nextToken());
            P[i][1] = Integer.parseInt(st.nextToken());
        }
        ccw();
    }
    static void ccw() {
        int result = (P[1][0] - P[0][0])*(P[2][1] - P[0][1]) - (P[2][0] - P[0][0])*(P[1][1] - P[0][1]);
        if(result < 0)
            System.out.println(-1);
        else if(result > 0)
            System.out.println(1);
        else
            System.out.println(result);
    }
}
