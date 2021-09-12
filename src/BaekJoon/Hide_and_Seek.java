package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1697번
public class Hide_and_Seek {
    static int Subin, brother, result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());
        Solve(Subin, 0);
        System.out.println(result);
    }
    static void Solve(int value, int time) {
        if(time > result)
            return;

        if(value == brother) {
            result = Math.min(result, time);
            return;
        }
        if(value > brother) {
            if(time >= result)
                return;
            Solve(value - 1, time+1);
        }
        if(value <= 0 )
            return;

        Solve(value+1, time+1);
        Solve(value*2, time+1);
        Solve(value-1, time+1);
    }
}
