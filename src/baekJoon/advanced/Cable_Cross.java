package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cable_Cross {
    static int N;
    static int[] value, dp;
    static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        value = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            /*
                이분탐색으로 값이 아닌 인덱스를 찾는다.
                LIS를 O(nlogn)으로 풀이하는 방법에서는, 현재 dp의 끝값으로 업데이트를 하지 못하는 값에 대해서는
                기존에 배열에 있던 다른 요소와 자리를 바꾼다.
                그 바꿀 자리를 찾을때 이분탐색을 이용해서 O(logn)의 복잡도로 빠르게 찾는 것이다.
             */
            int idx = BinarySearch(value[i], 0, index, index + 1);
            if(idx == -1) {
                dp[index++] = value[i];
            } else {
                dp[idx] = value[i];
            }
        }
        System.out.println(N - index);
    }
    static int BinarySearch(int value, int left, int right, int size) {
        int temp = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(value <= dp[mid]) {
                temp = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(left == size) {
            return -1;
        } else {
            return temp;
        }
    }
}
