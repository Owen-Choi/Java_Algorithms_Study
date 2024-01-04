package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 수강신청 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int k, l;
    k = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());
    Map<String, Integer> map = new LinkedHashMap<>();
    String input;
    for(int i=0; i<l; i++) {
      input = br.readLine();
      if(map.containsKey(input)) {
        map.remove(input);
      }
      map.put(input, 1);
    }
    StringBuilder sb = new StringBuilder();
    int counter = 0;
    for (String s : map.keySet()) {
      if(counter != k) {
        sb.append(s).append("\n");
        counter++;
      } else break;
    }
    System.out.println(sb.toString());

  }

}
