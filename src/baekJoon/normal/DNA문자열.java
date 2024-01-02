package baekJoon.normal;

import java.util.*;
import java.io.*;

public class DNA문자열 {

  static int a, c, g, t, result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int length = Integer.parseInt(st.nextToken());
    int subLength = Integer.parseInt(st.nextToken());
    String str = br.readLine();
    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    g = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < subLength; i++) {
      map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
    }
    int left = 0, right = subLength;
    checker(map);
    while (right < length) {
      remove(map, str.charAt(left++));
      map.put(str.charAt(right), map.getOrDefault(str.charAt(right++), 0) + 1);
      checker(map);
    }
    System.out.println(result);
  }

  public static void checker(Map<Character, Integer> map) {
    if(map.getOrDefault('A', 0) < a) return;
    if(map.getOrDefault('C', 0) < c) return;
    if(map.getOrDefault('G', 0) < g) return;
    if(map.getOrDefault('T', 0) < t) return;
    result++;
  }

  public static void remove(Map<Character, Integer> map, char value) {
    if (map.getOrDefault(value, 0) > 1) {
      map.put(value, map.get(value) - 1);
    } else {
      map.remove(value);
    }
  }
}
