package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 풍선_맞추기 {
  public static void main(String[] args) throws IOException {
    int n;
    Map<Integer, Integer> map = new HashMap<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int result = 0;
    for(int i=0; i<n; i++) {
      if(map.containsKey(arr[i])) {
        if(map.get(arr[i]) <= 1) {
          map.remove(arr[i]);
        } else {
          map.put(arr[i], map.get(arr[i]) - 1);
        }
      }
      else {
        result++;
      }
      while(i<n-1 && arr[i] == arr[i+1] + 1) {
        i++;
      }
      map.put(arr[i] - 1, map.getOrDefault(arr[i] - 1, 0) + 1);
    }
    System.out.println(result);
  }
}
