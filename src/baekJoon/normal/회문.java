package baekJoon.normal;


import java.util.*;
import java.io.*;

public class 회문 {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      String input = br.readLine();
      StringBuilder temp = new StringBuilder(input);

      String result = "2";

      if (temp.toString().contentEquals(temp.reverse())) {
        result = "0";
      } else {
        int left = 0, right = input.length() - 1;
        while (left < right) {
          if(input.charAt(left) != input.charAt(right)) {
            StringBuilder leftBuilder = new StringBuilder(input).deleteCharAt(left);
            StringBuilder rightBuilder = new StringBuilder(input).deleteCharAt(right);
            if (leftBuilder.toString().contentEquals(leftBuilder.reverse()) || rightBuilder.toString()
                .contentEquals(rightBuilder.reverse())) {
              result = "1";
            }
            // break는 위 조건문의 바깥에 있어야 한다. 이미 한개가 다른 시점에서, 하나씩 지워봤을때 회문이 되지 않는다면 가망이 없기 때문.
            break;
          }
          left++;
          right--;
        }
      }
      sb.append(result).append("\n");
    }
    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb.toString());
  }

}
