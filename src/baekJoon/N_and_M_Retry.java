package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 15649번
public class N_and_M_Retry {
    static int N;
    static int M;
    static boolean[] check;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        check = new boolean[N];
        arr = new int[N];
        M = Integer.parseInt(st.nextToken());
        recur(1, 0);
    }
    static void recur(int Num, int Count){
        if(Count == M){
            for(int temp : arr) {
                if(temp != 0)
                System.out.print(temp + " ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<N; i++){
            if(!check[i]){
                check[i] = true;
                arr[Count] = i+1;
                recur(i+1, Count+1);
                check[i] = false;
            }
        }
    }
}
