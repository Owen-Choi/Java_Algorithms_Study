package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// 1920번
public class Finding_Number {
    static int N, M;
    static int[] Target;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Target = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++)
            Target[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        // 입력부 끝

        Arrays.sort(Target);
        for(int i=0; i<M; i++) {
            check = false;
            if(FindNum(Integer.parseInt(st.nextToken())) >= 0)
                sb.append(1).append('\n');
            else
                sb.append(0).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int FindNum(int TargetNum) {
        int left = 0, right = Target.length - 1, mid;
        while(left <= right) {
            mid = (left+right)/2;
            if(TargetNum > Target[mid]) {
                 left = mid + 1;
            }
            else if(TargetNum < Target[mid]) {
                right = mid - 1;
            }
            else
                return mid;
        }
    return -100;
    }
}
