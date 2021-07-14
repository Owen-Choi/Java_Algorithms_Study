package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11047번
public class Coin_Zero {
    static int[] arr;
    static int TotalCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        int i;
        for(i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int index = N-1;
        for(; K > 0; ){
            if(K >= arr[index]) {
                TotalCount++;
                K -= arr[index];
            }
            else if( K < arr[index])
                index--;
        }
        System.out.println(TotalCount);
    }
}
