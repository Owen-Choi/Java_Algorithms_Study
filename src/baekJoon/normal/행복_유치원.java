package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 행복_유치원 {
  public static void main(String[] args) throws IOException {
    int n, k;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    List<Integer> list = new ArrayList<>();
    for(int i=n-1; i>0; i--) {
      list.add(arr[i] - arr[i-1]);
    }
    Collections.sort(list);
    int sum = 0;
    for(int i=0; i<n-k; i++) {
      sum += list.get(i);
    }
    System.out.println(sum);
  }
}
