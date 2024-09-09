package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 줄_세우기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 최솟값을 위해 가장 큰 값을 뺄지 작은 값을 뺄지 결정해야 함.
        // LIS 이용해서 구현?
        // => (3 7 5 2 6 1 4) 에서 LIS를 구하면 (3 5 6)으로 3이다.
        // 즉, LIS의 길이인 3개 요소 말고 나머지 요소는 모두 위치가 바뀌어야 한다는 말이다.


        int[] dp = new int[n];
        int max = 0;
        Arrays.fill(dp, 1);
        // i가 앞서 가는 친구고, k는 i를 따라가는 친구다. 항상 기억하자.
        // 그럼 누가 누구를 보고 업데이트를 해야할까? arr[k] 가 arr[i]를 보고, dp[i]가 업데이트 되어야겠지?
        for(int i=0; i<n; i++) {
            for(int k=0; k<i; k++) {
                if(arr[i] > arr[k]) {
                    dp[i] = Math.max(dp[k] + 1, dp[i]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        System.out.println(n - max);
    }
}
