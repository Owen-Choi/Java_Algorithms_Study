package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;
//
public class Shortest_Route {
    static int[][] dp;
    static int[] dist;
    static final int INF = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stack = new Stack<>();
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int Start = Integer.parseInt(br.readLine());
        dp = new int[V][V];
        dist = new int[V];
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<V; i++){
            if(i == Start){
                dist[i] = 0;
            }
            else
                dist[i] = INF;
        }
        int Current = Start-1;
        while(Current != V-1) {
            for (int i = 0; i < V-1; i++) {
                // 간선이 있다면
                if (dp[Current][i] != 0) {
                    dist[i+1] = Math.min(dist[i] + dp[Current][i], dp[Start-1][i]);
                }
            }
        }
    }

}
