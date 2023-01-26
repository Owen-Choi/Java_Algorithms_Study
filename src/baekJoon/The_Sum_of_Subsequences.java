package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1182번
public class The_Sum_of_Subsequences {
    static int N, S;
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recur(0, 0, false);
        System.out.println(count);
    }
    static void recur(int index, int sum, boolean checked) {
        if(index == N) {
            if(sum == S && checked)
                count++;
            return;
        }
        recur(index+1, sum + arr[index], true);
        recur(index+1, sum, checked);
    }
}
