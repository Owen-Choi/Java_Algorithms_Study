package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1987 ::
public class Alphabet {
    static int SenNum, SenLength;
    static char[][] arr;
    static int Max = -1;
    static boolean[] flag;      //크기는 26으로 두고 인덱스로 접근하기.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        SenNum = Integer.parseInt(st.nextToken());
        SenLength = Integer.parseInt(st.nextToken());
        arr = new char[SenNum + 1][SenLength + 1];
        String tempS;
        int iter = 1;
        for(int i=1; i<=SenNum; i++) {
            tempS = br.readLine();
            iter = 1;
            for (char c : tempS.toCharArray()) {
                arr[i][iter++] = c;
            }
        }
        flag = new boolean[26];
        recur(1,1,0);
        System.out.println(Max);
    }
    static void recur(int row, int col, int count) {
        if(row <= 0 || col <= 0 || row > SenNum || col > SenLength)
            return;
        if(flag[arr[row][col] - 'A']) {
            return;
        }
        else {
            flag[arr[row][col] - 'A'] = true;
            count++;
            recur(row + 1,col, count);
            recur(row-1,col, count);
            recur(row,col+1, count);
            recur(row, col-1, count);
            flag[arr[row][col] - 'A'] = false;
        }
        Max = Math.max(Max,count);
    }
}
