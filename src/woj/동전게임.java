package woj;


import java.util.*;
import java.io.*;
public class 동전게임 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int round = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int input = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();
    int a, b;
    for(int i=0; i<input; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      // 남은 라운드
      int remain = round - Math.max(a, b);
      // 점수차
      int gap = Math.abs(a - b);
      // 둘의 점수가 같다면
      if(a == b) {
        sb.append("1").append("\n");
      }
      // 영희의 점수가 더 크다면
      else if(a > b) {
        // 점수 차에서 남은 기회를 뺐을때 2 이하라면 가능성이 있다는 규칙이 있다.
        if(gap - remain <= 2)
          sb.append("1").append("\n");
        else
          sb.append("0").append("\n");
      } else {
        // 동수의 점수가 더 크다면
        // 영희가 게임을 먼저 시작했기 때문에, 이 경우에는 1 이하라면 가능성이 있다.
        if(gap - remain <= 1)
          sb.append("1").append("\n");
        else
          sb.append("0").append("\n");
      }
    }
    System.out.println(sb.toString());
  }

}
