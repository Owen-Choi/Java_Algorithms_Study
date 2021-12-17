package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1058번
public class Friend {
    static int[] friend;
    static char[][] board;
    static int Person;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Person = Integer.parseInt(br.readLine());
        char[] tempChar;
        board = new char[Person][Person];
        friend = new int[Person];
        for (int i = 0; i < Person; i++) {
            tempChar = br.readLine().toCharArray();
            for (int k = 0; k < Person; k++) {
                board[i][k] = tempChar[k];
            }
        }
        // 입력 종료'
        Solve();
    }

    static void Solve() {
        for (int i = 0; i < Person; i++) {
            for (int k = 0; k < Person; k++) {
                if (Checker(i, k))
                    friend[i]++;
            }
        }
        int Max = -1;
        for(int i=0; i<Person; i++) {
            if(friend[i] > Max)
                Max = friend[i];
        }
        if(Max == 0)
            System.out.println(Max);
        else
            System.out.println(Max-1);
    }

    static boolean Checker(int i, int k) {
        // 상대방과 내가 다이렉트로 친구라면 2-친구로 인정된다.
        if (board[i][k] == 'Y') {
            if (board[k][i] == 'Y') {
                return true;
            }
            // 상대방과 내가 친구가 아니어도
            // 서로 겹치는 친구가 있다면 2-친구로 인정한다.
        } else {
            for (int index = 0; index < Person; index++) {
                if (board[i][index] == 'Y') {
                    if (board[k][index] == 'Y')
                        return true;
                }
            }
        }
        return false;
    }
}