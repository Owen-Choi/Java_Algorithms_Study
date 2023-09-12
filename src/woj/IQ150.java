package woj;

import java.util.Scanner;

public class IQ150 {
    static int[][] board;
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for(int i=0; i<n; i++) {
            board[i][0] = sc.nextInt();
        }

        for(int i=1; i<n; i++) {
            for(int k=i; k<n; k++) {
                board[k][i] = board[k][i-1] - board[k-1][i-1];
            }
        }

        for(int i=0; i<n; i++) {
            for(int k=0; k<=i; k++) {
                System.out.print(board[i][k] + " ");
            }
            System.out.println();
        }
    }
}
