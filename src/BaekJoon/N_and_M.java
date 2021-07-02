package BaekJoon;

import java.io.IOException;
import java.util.Scanner;

//0 <= M <= N <= 8
// 1부터 N까지 자연수 중 중복없이 M개를 고른 수열 출력
public class N_and_M{
    static int N,M;
    boolean[] visit = new boolean[M];
    int[] arr = new int[M];
    public void recur(int depth){
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
                recur(depth+1);
                visit[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); M = sc.nextInt();
        if(N > 9 || M > 9)
            return;
        else{
            N_and_M nm = new N_and_M();
            nm.recur(0);
        }

    }
}
