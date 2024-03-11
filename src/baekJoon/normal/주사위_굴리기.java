package baekJoon.normal;

import java.io.*;
import java.util.*;
public class 주사위_굴리기 {
    public static void main(String[] args) throws IOException {
        int n, m, currentx, currenty, commands;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        currentx = Integer.parseInt(st.nextToken());
        currenty = Integer.parseInt(st.nextToken());
        commands = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<m; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        int bottom, up, left, right, front, back, command;
        int tempBottom, tempUp, tempLeft, tempRight, tempFront, tempBack;
        up = bottom = front = back = left = right = 0;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<commands; i++) {
            command = Integer.parseInt(st.nextToken());
            // 동쪽 1, 서쪽 2, 북쪽 3, 남쪽 4
            tempBottom = bottom; tempUp = up; tempLeft = left; tempRight = right; tempFront = front; tempBack = back;
            if(command == 1) {
                if(currenty + 1 >= m) {
                    continue;
                }
                // 동쪽으로 주사위를 굴리면 윗면이 동쪽으로 향하게 된다.
                right = tempUp; up = tempLeft; bottom = tempRight; left = tempBottom;
                currenty++;
            } else if(command == 2) {
                if(currenty - 1 < 0) {
                    continue;
                }
                // 서쪽으로 주사위를 굴리면 윗면이 서쪽으로 향하게 된다.
                right = tempBottom; up = tempRight; bottom = tempLeft; left = tempUp;
                currenty--;
            } else if(command == 3) {
                if(currentx-1 < 0) {
                    continue;
                }
                // 북쪽을 향해서 주사위를 굴리면 윗면이 뒷면을 향하게 된다.
                front = tempBottom; up = tempFront; bottom = tempBack; back = tempUp;
                currentx--;
            } else {
                if(currentx+1 >= n) {
                    continue;
                }
                // 남쪽을 향해서 주사위를 굴리면 윗면이 정면을 향하게 된다.
                front = tempUp; up = tempBack; bottom = tempFront; back = tempBottom;
                currentx++;
            }
            if(arr[currentx][currenty] == 0) {
                arr[currentx][currenty] = bottom;
            } else {
                bottom = arr[currentx][currenty];
                arr[currentx][currenty] = 0;
            }
            sb.append(up).append("\n");
        }
        System.out.println(sb.toString());
    }
}
