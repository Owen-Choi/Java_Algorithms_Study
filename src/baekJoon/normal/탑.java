package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    Stack<int[]> stack = new Stack<>();
    List<Integer> indexes = new ArrayList<>();
    int[][] arr = new int[n][2];
    for(int i=0; i<n; i++) {
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = i+1;
      boolean flag = false;
      if(!stack.isEmpty()) {
        if(stack.peek()[0] < arr[i][0]) {
          while(!stack.isEmpty() && stack.peek()[0] < arr[i][0]) {
            stack.pop();
          }
          // 이 연산이 끝난 뒤 스택이 비어있지 않다면, 본인보다 큰 탑이 있다는 뜻이다.
          if(!stack.isEmpty()) {
            indexes.add(stack.peek()[1]);
            flag = true;
          }
        } else {
          // 스택에 있던 값 보다 입력으로 들어온 값이 더 작으면
          // 스택에 있던 탑이 신호를 수신할 수 있으므로, 인덱스를 리스트에 추가한 뒤 스택에 추가
          indexes.add(stack.peek()[1]);
          flag = true;
        }
      }
      stack.push(arr[i]);
      if(!flag) indexes.add(0);
    }
    StringBuilder sb = new StringBuilder();
    for (Integer index : indexes) {
      sb.append(index).append(" ");
    }
    System.out.println(sb.toString());
  }

}
