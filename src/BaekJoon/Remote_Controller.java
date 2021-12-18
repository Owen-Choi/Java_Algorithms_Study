package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Remote_Controller {
    static String TargetNum;
    static int brokenNum;
    static int[] brokens;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TargetNum = br.readLine();
        brokenNum = Integer.parseInt(br.readLine());
        brokens = new int[brokenNum];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<brokenNum; i++) {
            brokens[i] = Integer.parseInt(st.nextToken());
        }
        Solve();
    }
    static void Solve() {
        char[] temp;
        temp = TargetNum.toCharArray();
        for(int i=0; i<temp.length; i++) {
            if(checker(temp[i] - '0')) {
                result++;
            }
        }
    }
    static boolean checker(int number) {
        for(int i=0; i<brokenNum; i++) {
            if(number == brokens[i])
                return false;
        }
        return true;
    }
}
