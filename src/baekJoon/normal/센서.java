package baekJoon.normal;

import java.io.*;
import java.util.*;
public class 센서 {

//    Input
//        6
//        2
//        1 6 9 3 6 7
//    Output
//        5

//집중국 두개가 각각 [1, 3] [6, 9] 영역을 커버하면 최소 길이가 됩니다.

//    Input
//        10
//        5
//        20 3 14 6 7 8 18 10 12 15
//    Output
//        7

// [3, 3], [6, 8], [10, 15], [18, 18], [20, 20] 로 분할하면 최소 길이가 됩니다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        if(k >= n) {
            System.out.println(0);
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] diff = new int[n-1];
        for(int i=0; i<n-1; i++) {
            diff[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(diff);
        int result = 0;
        for(int i=n-k-1; i>=0; i--) {
            result += diff[i];
        }
        System.out.println(result);
    }
}
