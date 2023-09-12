package woj;

import java.util.Scanner;

public class FlippingGo {
    static int[][] map = new int[19][19];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<19; i++) {
            for(int k=0; k<19; k++) {
                map[i][k] = sc.nextInt();
            }
        }
        int n = sc.nextInt();
        int x, y;
        while(n --> 0) {
            x = sc.nextInt();
            y = sc.nextInt();
            flip(x - 1, y - 1);
        }
        for(int i=0; i<19; i++) {
            for(int k=0; k<19; k++) {
                System.out.print(map[i][k] + " ");
            }
            System.out.println();
        }
    }

    static void flip(int x, int y) {
        int original = map[x][y];
        for(int i=0; i<19; i++) {
            map[x][i] = map[x][i] == 0 ? 1 : 0;
            map[i][y] = map[i][y] == 0 ? 1 : 0;
        }
        map[x][y] = original;
    }
}

