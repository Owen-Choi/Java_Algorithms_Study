package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2110번
public class Setting_WIFI {
    static int N, C;
    static int[] arr;
    static int MAX = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        // 입력부
        Arrays.sort(arr);
        setting();
        System.out.println(MAX);
    }
    static void setting() {
        int left = 1;
        int right = arr[N-1] - arr[0];
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            if(check(mid)) {
                MAX = Math.max(MAX, mid);
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
    }
    static boolean check(int mid) {
        int result = 1, temp;
        temp = arr[0] + mid;
        for(int i=0; i<N; i++) {
            if(arr[i] >= temp) {
                result++;
                temp = arr[i] + mid;
            }
        }
        return result >= C;
    }
}
