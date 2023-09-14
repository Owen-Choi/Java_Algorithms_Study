package woj;

import java.util.Scanner;

public class ShellGame {
    public static void main(String[] args) {
        int round;
        int[][] arr;
        Scanner sc = new Scanner(System.in);
        round = sc.nextInt();
        int num;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<round; i++) {
            arr = new int[2][4];
            for(int k=0; k<2; k++) {
                num = sc.nextInt();
                for(int j=0; j<num; j++) {
                    arr[k][sc.nextInt() - 1]++;
                }
            }
            int determine = determine(arr);
            if(determine == 0) {
               sb.append("A");
           } else if(determine == 1){
               sb.append("B");
           } else {
                sb.append("D");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static int determine(int[][] arr) {
        if(arr[0][3] != arr[1][3]) {
            // 별의 개수가 다르다면 별이 더 많은 사람이 승리
            return arr[0][3] > arr[1][3] ? 0 : 1;
        } else if(arr[0][2] != arr[1][2]) {
            // 동그라미의 개수가 다르다면 동그라미가 더 많은 사람이 승리
            return arr[0][2] > arr[1][2] ? 0 : 1;
        } else if(arr[0][1] != arr[1][1]) {
            // 네모의 개수가 다르다면 네모가 더 많은 사람이 승리
            return arr[0][1] > arr[1][1] ? 0 : 1;
        } else if(arr[0][0] != arr[1][0]) {
            // 세모의 개수가 다르다면 세모의 개수가 더 많은 사람이 승리
            return arr[0][0] > arr[1][0] ? 0 : 1;
        } else {
            // 여기까지 도달하면 모두 같다는 말. 무승부
            return 2;
        }
    }
}
