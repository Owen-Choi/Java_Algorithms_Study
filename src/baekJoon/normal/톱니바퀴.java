package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 톱니바퀴 {
    static int result = 0;
    static int[][] gears;
    static int[] rotates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 12시부터 시계 방향대로 배열에 저장하겠다.
        gears = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int k = 0; k < input.length(); k++) {
                gears[i][k] = input.charAt(k) - 48;
            }
        }
        // 12시 = 0, 2시(오른쪽) = 2, 8시(왼쪽) = 6
        int commands = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < commands; i++) {
            rotates = new int[4];
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            rotates[index] = direction;
            // 참고한 부분. 수 많던 조건문이 여기서 간추려진다. 천재인가?
            for (int j = index; j > 0; j--) {
                if (gears[j][6] != gears[j - 1][2]) {
                    rotates[j - 1] = -rotates[j];
                } else {
                    break;
                }
            }
            for (int k = index; k < 3; k++) {
                if (gears[k][2] != gears[k + 1][6]) {
                    rotates[k + 1] = -rotates[k];
                } else {
                    break;
                }
            }
            for(int k=0; k<4; k++) {
                if(rotates[k] != 0) {
                    rotate(k, rotates[k]);
                }
            }
        }
        calculateScore();
        System.out.println(result);
    }

    static void rotate(int index, int direction) {
        // 1 : 시계방향, -1 : 반시계방향
        int[] original = new int[7];
        original = gears[index].clone();
        if (direction == 1) {
            for (int i = 0; i < 7; i++) {
                gears[index][i+1] = original[i];
            }
            gears[index][0] = original[7];
        } else if(direction == -1) {
            for (int i = 7; i > 0; i--) {
                gears[index][i-1] = original[i];
            }
            gears[index][7] = original[0];
        }
    }

    static void calculateScore() {
        // N극 == 0, S극 == 1
        for(int i=0; i<4; i++) {
            if (i == 0) {
                result = gears[i][0] == 0 ? result : result + 1;
            } else if (i == 1) {
                result = gears[i][0] == 0 ? result : result + 2;
            } else if (i == 2) {
                result = gears[i][0] == 0 ? result : result + 4;
            } else {
                result = gears[i][0] == 0 ? result : result + 8;
            }
        }
    }
}
