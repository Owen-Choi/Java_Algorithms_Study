package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Remote_Controller {
    static String TargetNum;
    static int brokenNum, result;
    static int[] brokens;
    static char[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TargetNum = br.readLine();
        brokenNum = Integer.parseInt(br.readLine());
        brokens = new int[brokenNum];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<brokenNum; i++) {
            brokens[i] = Integer.parseInt(st.nextToken());
        }
        temp = TargetNum.toCharArray();
        Solve(100,0,0);
    }
    static void Solve(int current, int index, int num) {
        if(current == Integer.valueOf(TargetNum)) {
            result = Math.min(result, num);
            return;
        }
        for(int i=index; i<)
    }
    static boolean checker(int index, int number) {
        for(int i=index; i<brokenNum; i++) {
            if(number == brokens[i])
                return false;
        }
        return true;
    }
}
