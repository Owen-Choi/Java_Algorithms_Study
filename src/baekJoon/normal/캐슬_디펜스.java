package baekJoon.normal;

import java.io.*;
import java.util.StringTokenizer;

public class 캐슬_디펜스 {
    static int result = 0, n, m, d, enemies = 0;
    static boolean[] flag;
    public static void main(String[] args) throws IOException {
        // 세로선 가로선 (세로선마다 가로선을 놓을 수 있는 위치의 개수)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        // n+1 행이 성벽이고, 궁수는 이 n+1행의 열에 배치될 수 있다.
        // 궁수는 3명까지만 배치되고, m의 최솟값이 3이기 때문에 궁수가 한 행에 모두 배치되지 않는 경우는 없다.
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<m; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
                if(arr[i][k] == 1) {
                    enemies++;
                }
            }
        }
        // 먼저 재귀로 n+1행의 열에 궁수를 배치하는 모든 "조합"을 확인한다.
        // 재귀로 특정 조합을 찾았다면 시뮬레이션을 실시한다.
        flag = new boolean[arr[0].length];
        combination(0, arr, 0, new int[m]);
        System.out.println(result);
    }

    public static void combination(int start, int[][] arr, int depth, int[] ar) {
        if(depth == 3) {
            simulation(arr, ar);
            return;
        }
        for(int i=start; i<m; i++) {
            if(!flag[i]) {
                flag[i] = true;
                int[] recur_ar = ar.clone();
                recur_ar[depth] = i;
                combination(i, arr, depth+1, recur_ar);
                flag[i] = false;
            }
        }
    }

    public static void simulation(int[][] arr, int[] ar) {
        // 적이 더 이상 없을 때까지 게임 진행
        int[][] clone = new int[n][m];
        int count = 0, eli = 0;
        for(int i=0; i<n; i++) {
            for(int k=0; k<m; k++) {
                clone[i][k] = arr[i][k];
            }
        }
//        1 0 0
//        0 0 1
//        0 0 0
//        - - - (4,1), (2,3)
        // 위 경우는 직선 거리는 3, 대각선 거리는 4가 나온다. 즉, 행은 더 멀지만 거리는 더 가까운 경우가 나온다.
        int[][] target = new int[3][2];
        int distance, targetX, targetY;
        while(count < enemies) {
            // 궁수 개인별로 반복문 실행
            for(int j=0; j<3; j++) {
                // 사정권 내에서 적을 찾기 위한 반복문
                distance = Integer.MAX_VALUE;
                targetY = targetX = -1;
                for(int i=0; i<n; i++) {
                    for(int k=0; k<m; k++) {
                        // 시정권 내에서 적을 찾았다면
                        if(clone[i][k] == 1) {
                            // 일단 거리를 확인한다.
                            int tempDist = getDistance(i, k, n, ar[j]);
                            // 대각선 등을 고려했을때도 사정권 내라면
                            if(tempDist <= d) {
                                // 이전에 찾았던 거리와 비교해서 더 작은 거리, 더 왼쪽 적을 찾음
                                if(tempDist < distance) {
                                    distance = tempDist;
                                    targetX = i;
                                    targetY = k;
                                } else if(tempDist == distance) {
                                    // 거리가 같을 경우 왼쪽 적을 찾음
                                    if(targetY > k) {
                                        targetX = i;
                                        targetY = k;
                                    }
                                }
                            }
                        }
                    }
                }
                target[j][0] = targetX;
                target[j][1] = targetY;
            }
            // 궁수가 적을 공격한다.
            for(int i=0; i<3; i++) {
                if(target[i][0] == -1 || target[i][1] == -1)
                    continue;
                // 다른 궁수가 이미 제거해서 적이 없을 수도 있으니 체크해야 한다.
                if(clone[target[i][0]][target[i][1]] == 1) {
                    clone[target[i][0]][target[i][1]] = 0;
                    eli++;
                    count++;
                }
            }
            // 궁수가 적을 제거한 후, 적들은 한칸 전진한다.
            for(int i=n-1; i>=0; i--) {
                for(int k=0; k<m; k++) {
                    if(clone[i][k] == 1) {
                        // 적이 성벽에 닿은 경우 게임에서 제거한다.
                        if(i == n-1) {
                            clone[i][k] = 0;
                            count++;
                        } else {
                            // 한칸 전진
                            clone[i][k] = 0;
                            clone[i+1][k] = 1;
                        }
                    }
                }
            }
        }
        // 제거한 적의 수가 최댓갑보다 크다면 갱신해준다.
        result  = Math.max(result, eli);
    }

    public static int getDistance(int enemyX, int enemyY, int arX, int arY) {
        return Math.abs(arX - enemyX) + Math.abs(arY - enemyY);
    }
}
