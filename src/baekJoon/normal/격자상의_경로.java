package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 격자상의_경로 {
    public static void main(String[] args) throws IOException{
        int x, y, k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[x][y];
        //허허 arr에 값을 안채워줬네...
        int count = 1;
        for(int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                arr[i][j] = count++;
            }
        }
        // 다시 풀어보자.
        int midx = 0, midy = 0;
        for(int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                if(arr[i][j] == k) {
                    midx = i+1;
                    midy = j+1;
                }
            }
        }
        int[][] dp = new int[x+1][y+1];
        for(int i=1; i<=x; i++) {
            dp[i][0] = 1;
        }
        for(int j=1; j<=y; j++) {
            dp[0][j] = 1;
        }
        // 경유지 (없을 경우 처음부터) 목적지까지 경우의 수를 구함
        // => 이렇게 할 필요 없다. 그냥 dp 배열부터 채워놓고 생각해도 됨.
        for(int i=1; i<=x; i++) {
            for(int j=1; j<=y; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

//        for(int i=0; i<=x; i++) {
//            for(int j=0; j<=y; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        if(k != 0) {
            System.out.println(dp[midx-1][midy-1] * dp[x - midx][y - midy]);

        } else {
            System.out.println(dp[x-1][y-1]);
        }

        // k를 들러야 하기 때문에, 먼저 k로 가는 dp 값을 구한 다음 NxM 번째로 가는 dp를 구한다.
        // dp[x][y] : x행 y열까지 이동할 수 있는 경우의 수
//        int[][] dp = new int[x][y];
//        int answer = 0;
//        int midx = 0, midy = 0;
//        int startX = 0, startY = 0;
//        if(k != 0) {
//            for(int i=0; i<x; i++) {
//                for(int j=0; j<y; j++) {
//                    if(arr[i][j] == k) {
//                        midx = i;
//                        midy = j;
//                        break;
//                    }
//                }
//            }
//            for(int i=0; i<midx; i++) {
//                for(int j=0; j<midy; j++) {
//                    if(i+1 < x) {
//                        dp[i+1][j] = dp[i][j] + 1;
//                    }
//                    if(j+1 < y) {
//                        dp[i][j+1] = dp[i][j] + 1;
//                    }
//                }
//            }
//            dp[midx][midy] = Math.max(dp[midx - 1][midy] + 1, dp[midx][midy - 1] + 1);
//            startX = midx;
//            startY = midy;
//        }
//        for(int i=startX; i<x; i++) {
//            for(int j=startY; j<y; j++) {
//                if(i+1 < x) {
//                    dp[i+1][j] = dp[i][j] + 1;
//                }
//                if(j+1 < y) {
//                    dp[i][j+1] = dp[i][j] + 1;
//                }
//            }
//        }
//
//        System.out.println(dp[x-1][y-1]);
//
//        for(int i=0; i<x; i++) {
//            for(int j=0; j<y; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
