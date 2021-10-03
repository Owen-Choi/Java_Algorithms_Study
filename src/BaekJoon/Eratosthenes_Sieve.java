package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 2960 ::
public class Eratosthenes_Sieve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N, K;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Solve(N, K);
    }
    static void Solve(int N, int K) {
        boolean[] flag = new boolean[N+1];
        int Count = 0;
        for(int i=2; i<=N; i++) {
            for(int k=i; k<=N; k+=i) {
                if(!flag[k]) {
                    flag[k] = true;
                    Count++;
                    }
                if(Count == K) {
                    System.out.println(k);
                    return;
                }
            }
        }
    }
}
