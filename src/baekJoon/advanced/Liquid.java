package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2467, 용액, 골드5
public class Liquid {
    static int N;
    static int[] liquids;
    static int result1, result2;
    static int minSum = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        liquids = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        int leftPtr = 0;
        int rightPtr = N - 1;
        while(leftPtr < rightPtr) {
            int sumAbs = Math.abs(liquids[leftPtr] + liquids[rightPtr]);
            int sum = liquids[leftPtr] + liquids[rightPtr];
            if(sumAbs <= minSum) {
                minSum = sumAbs;
                result1 = liquids[leftPtr];
                result2 = liquids[rightPtr];
            }
            if(sum > 0) {
                // 이론상 sum이 더 작아질 수 있는 rightPointer를 옮긴다.
                rightPtr--;
            } else if(sum < 0) {
                // 이론상 sum이 더 커질 수 있는 leftPointer를 옮긴다.
                leftPtr++;
            } else {
                // 합이 0이라면 바로 종료 후 정답을 출력한다.
                result1 = liquids[leftPtr];
                result2 = liquids[rightPtr];
                break;
            }
        }
        System.out.println(result1 + " " + result2);
    }
}
