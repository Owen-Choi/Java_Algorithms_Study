package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// 10816번
public class Number_Card_2 {
    static int N,M, targetNum = 0;
    static int[] arr;
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
        for(int i=0; i<M; i++) {
            targetNum = 0;
            check(Integer.parseInt(st.nextToken()));
            sb.append(targetNum).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void check(int target) {
        int left = 0, right = arr.length - 1, mid;
        mid = (left+right)/2;
        while(left <= right && mid <= right) {
            if(target > arr[mid]) {
                left = mid + 1;
            }
            else if(target < arr[mid]) {
                right = mid - 1;
            }
            else if(target == arr[mid]){
                targetNum++;
                int temp = mid;
                    while(temp > 0) {
                        if(arr[--temp] != arr[mid])
                            break;
                        targetNum++;
                    }
                    temp = mid;
                    while(temp < arr.length-1) {
                        if(arr[++temp] != arr[mid])
                            break;
                        targetNum++;
                    }
                return;
            }
            mid = (left+right)/2;
        }
    }
}
