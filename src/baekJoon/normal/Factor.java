package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1037번
public class Factor {
    static int FN;
    static int Min = Integer.MAX_VALUE;
    static int Max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FN = Integer.parseInt(br.readLine());
        int temp;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<FN; i++){
            temp = Integer.parseInt(st.nextToken());
            Min = Math.min(Min, temp);
            Max = Math.max(Max, temp);
        }
        System.out.println((long)Min * Max);
    }
}
