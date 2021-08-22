package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 11866번
public class Josephus_Quiz_0 {
    static int N,K;
    static int[] arr;
    static int[] new_arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        new_arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = i+1;
        int Count = 0, temp = 0;
        for(int i=0; temp != N; i = (++i) % N) {
            if(arr[i] != 0)
                Count++;
            if(Count == K) {
                Count = 0;
                new_arr[temp++] = arr[i];
                arr[i] = 0 ;
            }
        }
        System.out.print("<");
        for(int i=0; i<N-1; i++)
            System.out.print(new_arr[i] + ", ");
        System.out.print(new_arr[N-1]+">");
        System.out.println();
    }
}
