package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

// 15650번
public class N_and_M_2 {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        recur(0, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void recur(int index, int Count) {
        if(Count == M){
            for(int temp : arr){
                sb.append(temp).append(' ');
            }
            sb.append("\n");
            return;
        }
        for(int i = index; i<N; i++){
            arr[Count] = i+1;
            recur(i+1, Count+1);
        }
    }
}
