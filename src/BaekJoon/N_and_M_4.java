package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 15652번
public class N_and_M_4 {
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        recur(1,0);
        System.out.println(sb);
    }
    static void recur(int index, int Count){
        if(Count == M){
            for(int temp : arr){
                sb.append(temp).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=index; i<=N; i++){
            arr[Count] = i;
            recur(i, Count+1);
        }
    }
}
