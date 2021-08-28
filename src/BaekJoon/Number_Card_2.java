package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// 10816번
public class Number_Card_2 {
    static int N,M, targetNum = 0;
    static int[] arr;
    static int left, right, mid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        // 입력부 끝
        int input;
        for(int i=0; i<M; i++) {
            input = Integer.parseInt(st.nextToken());
            targetNum = Not_Equal(input) - Equal(input);
            sb.append(targetNum).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int Equal(int targetNum) {
        left = 0;
        right = arr.length;

        while(left < right) {
            mid = (left + right) / 2;
            if(targetNum <= arr[mid])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
    static int Not_Equal(int targetNum) {
        left = 0;
        right = arr.length;
        while(left < right) {
            mid = (left + right) / 2;
            if(targetNum < arr[mid])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
