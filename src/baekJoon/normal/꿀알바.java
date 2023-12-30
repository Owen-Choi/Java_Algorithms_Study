package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 꿀알바 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m;
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    m = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    long sum = 0;
    // 처음에 m개 연속의 합을 구하고, left와 right를 하나씩 조절하며 결과를 판단하자.
    for(int i=0; i<m; i++) {
      sum += arr[i];
    }
    long max = sum;
    int left = 0, right = m;
    while(right < n) {
      sum = sum - arr[left++] + arr[right++];
      max = Math.max(max, sum);
    }

    System.out.println(max);
  }
}
