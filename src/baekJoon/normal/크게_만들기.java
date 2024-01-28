package baekJoon.normal;

import java.util.*;
import java.io.*;
import java.util.Stack;

public class 크게_만들기 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, k;
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    String input = br.readLine();
    Stack<Character> stack = new Stack<>();
    for(int i=0; i<n; i++) {
      if(!stack.isEmpty()) {
        while(!stack.isEmpty() && input.charAt(i) > stack.peek() && k > 0) {
          stack.pop();
          k--;
        }
      }
      stack.push(input.charAt(i));
    }
    // 만약 k가 0이 아니라면 아직 없애야 하는 수가 더 남았다는 뜻이므로, 만들어진 수에서 뒤에서부터 남은 k 만큼 제거한다.
    while(k --> 0) {
      stack.pop();
    }
    StringBuilder sb = new StringBuilder();
    while(!stack.isEmpty()) sb.append(stack.pop());
    sb.reverse();
    System.out.println(sb.toString());
  }

}
