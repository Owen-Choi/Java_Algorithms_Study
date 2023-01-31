package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1029 그림교환 : 골드 1
public class TradingArts {
    static int N;
    static int[][] trades;
    // 특정 예술가의 그림을 소유했었나를 알려주는 booelan 배열
    static boolean[] flag;
    // 그림의 입장에서, 자신을 소유했었던 예술가를 알려주는 boolean 배열
    static boolean[][] paintOwnerFlag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        trades = new int[N][N];
        flag = new boolean[N];
        paintOwnerFlag = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String temp = br.readLine();
            for(int k=0; k<N; k++) {
                trades[i][k] = temp.charAt(k) - '0';
            }
        }

        for(int x=0; x<N; x++) {

        }

    }

    public static void dpPerArtist(int artist, ) {

    }
}
