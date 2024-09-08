package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 꿀_따기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
        // N은 최대 10만. 완전탐색으로는 풀 수 없다.
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long[] prefixSum = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        prefixSum[0] = arr[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] += prefixSum[i-1] + arr[i];
        }
        // 왼쪽에 벌 고정, 오른쪽에 벌통 고정
        long tempSum;
        for(int i=1; i<n-1; i++) {
            tempSum = 0;
            // 움직이는 벌의 위치 : i
            // 움직이는 벌이 오른쪽의 벌통까지 가는 거리
            tempSum += prefixSum[n-1] - prefixSum[i];
            // 왼쪽에 고정된 벌이 오른쪽의 벌통까지 가는 거리 - (움직이는 벌이 있는 칸)
            tempSum += prefixSum[n-1] - prefixSum[0] - (prefixSum[i] - prefixSum[i-1]);
            result = Math.max(result, tempSum);
        }
        // 왼쪽에 벌통 고정, 오른쪽에 벌 고정
        for(int i=1; i<n-1; i++) {
            tempSum = 0;
            // 움직이는 벌의 위치 : i
            // 움직이는 벌이 왼쪽의 벌통까지 가는 거리
            tempSum += prefixSum[i-1];
            // 오른쪽에 고정된 벌이 왼쪽의 벌통까지 가는 거리 - (움직이는 벌이 있는 칸)
            tempSum += prefixSum[n-2] - (prefixSum[i] - prefixSum[i-1]);
            result = Math.max(result, tempSum);
        }
        // 왼쪽에 벌 고정, 오른쪽에 벌 고정
        for(int i=1; i<n-1; i++) {
            tempSum = 0;
            // 움직이는 벌통의 위치 : i
            // 왼쪽의 벌이 움직이는 벌통까지 가는 거리 + 벌통이 있는 칸의 값
            tempSum += prefixSum[i] - prefixSum[0];
            // 오른쪽의 벌이 움직이는 벌통까지 가는 거리
            tempSum += prefixSum[n-2] - prefixSum[i-1];
            result = Math.max(result, tempSum);
        }

        System.out.println(result);
    }
}
