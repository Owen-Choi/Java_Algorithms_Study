package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 15651번
public class N_and_M_3 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        recur(0);
        System.out.println(sb);
    }
    static void recur(int Count){
        if(Count == M){
            for(int temp : arr){
                sb.append(temp).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=0; i<N; i++){
            arr[Count] = i+1;
            recur(Count+1);
        }
    }
}
