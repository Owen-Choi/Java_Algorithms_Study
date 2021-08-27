package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 1920번
public class Finding_Number {
    static int N, M;
    static int[] Target, Input;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Target = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++)
            Target[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        Input = new int[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<M; i++)
            Input[i] = Integer.parseInt(st.nextToken());
        // 입력부 끝

        Arrays.sort(Target);
        for(int i=0; i<N; i++) {
            check = false;
            FindNum(Input[i], Target.length-1, 0, Target.length/2);
            if(check)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
    static void FindNum(int targetNum, int right, int left, int mid) {
        if(left == mid) {
            if(Target[left] == targetNum) {
                check = true;
            }
            else if(Target[right] == targetNum) {
                check = true;
            }
            return;
        }
        FindNum(targetNum, mid, left, (mid+left)/2);
        FindNum(targetNum, right, mid+1, (right+(mid+1))/2);
    }
}
