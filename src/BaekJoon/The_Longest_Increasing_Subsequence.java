package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11053번
public class The_Longest_Increasing_Subsequence {
    static int Input;
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        arr = new int[Input];
        dp = new Integer[Input];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<Input; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }
    // 일단 보류. 다시 풀어보기
}
