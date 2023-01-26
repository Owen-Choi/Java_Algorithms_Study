package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//0 <= M <= N <= 8
// 1부터 N까지 자연수 중 중복없이 M개를 고른 수열 출력
public class N_and_M{
    int[] arr;
    boolean[] visit;
    public void recur(int N, int M, int depth){
        if(depth == M){
            for(int value : arr){
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        // 재귀에서는 웬만하면 반복문을 사용할 때 iterator를 반복문 안에 새로 선언해주자
        for(int i=0; i<N; i++){

            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i+1;
                recur(N, M, depth+1);
                visit[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N_and_M nm = new N_and_M();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        nm.visit = new boolean[M];
        nm.arr = new int[M];
        nm.recur(N,M,0);

    }
}
