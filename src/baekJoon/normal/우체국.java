package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 우체국 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    List<Node> list = new ArrayList<>();
    long totalPopulaion = 0;
    long dist, value;
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      dist = Long.parseLong(st.nextToken());
      value = Long.parseLong(st.nextToken());
      list.add(new Node(dist, value));
      totalPopulaion += value;
    }
    Collections.sort(list);
    long target = (totalPopulaion + 1)/2;
    long result = 0;
    for(int i=0; i<n; i++) {
      result += list.get(i).value;
      if(result >= target) {
        System.out.println(list.get(i).dist);
        return;
      }
    }

  }

  static class Node implements Comparable<Node>{
    long dist;
    long value;

    public Node(long dist, long value) {
      this.dist = dist;
      this.value = value;
    }

    @Override
    public int compareTo(Node o) {
      return (int)(this.dist - o.dist);
    }
  }
}

