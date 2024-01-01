package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 회전초밥 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n,d,k,c;
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    for(int i=0; i<k; i++)
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    map.put(c, c);
    max = map.size();
    remove(map, c);

    int left = 0, right = k;
    // 단방향으로 하면 안되고 원형의 형태로 구성해야 한다.
    while(right != k - 1) {
      remove(map, arr[left]);
      map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
      map.put(c,map.getOrDefault(c, 0) + 1);
      max = Math.max(max, map.size());
      remove(map, c);
      left = (++left) % n;
      right = (++right) % n;
    }

    System.out.println(max);
  }

  private static void remove(Map<Integer, Integer> map, int value) {
    if(map.get(value) > 1) {
      map.put(value, map.get(value) - 1);
    } else {
      map.remove(value);
    }
  }
}
