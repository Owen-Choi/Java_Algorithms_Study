package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2798번
public class BlackJack {
    static int CardNum;
    static int Target;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        CardNum = Integer.parseInt(st.nextToken());
        Target = Integer.parseInt(st.nextToken());
        arr = new int[CardNum];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<CardNum; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int sum = 0;
        for(int i=0; i<CardNum; i++){
            for(int k=i+1; k<CardNum; k++){
                for(int j=k+1; j<CardNum; j++){
                    sum = arr[i] + arr[k] + arr[j];
                    if(sum <= Target)
                        answer = Math.min(answer, Target - sum);
                }
            }
        }
        System.out.println(Target - answer);
    }
}
