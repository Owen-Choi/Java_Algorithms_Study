package baekJoon.normal;

import java.util.*;
import java.io.*;
import java.util.Stack;

public class 문자열_폭발 {

  public static void main(String[] args) throws IOException{
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    String input = br.readLine();
//    String exclusive = br.readLine();
//    StringBuilder sb = new StringBuilder(input);
//    StringBuilder window = new StringBuilder();
//    // 슬라이딩 윈도우
//    int left = 0, right = exclusive.length();
//    if (right > input.length()) {
//      System.out.println(input);
//      return;
//    }
//    for(int i=left; i<right; i++) {
//      window.append(sb.charAt(i));
//    }
//    while(right <= sb.length()) {
//      if(exclusive.contentEquals(window)) {
//        for(int i=left; i<right; i++) {
//          sb.deleteCharAt(left);
//        }
//        right = left == 0 ? right : --right;
//        left = left == 0 ? 0 : --left;
//        if(right > sb.length())
//          break;
//        window = new StringBuilder();
//        for(int i=left; i<right; i++) {
//          window.append(sb.charAt(i));
//        }
//      } else {
//        window.deleteCharAt(0);
//        left++;
//        window.append(sb.charAt(right++));
//      }
//    }
//
//    if (sb.length() > 0) {
//      System.out.println(sb.toString());
//    } else {
//      System.out.println("FRULA");
//    }

    // 슬라이딩 윈도우를 활용한 풀이는 동작하지 않는다. 시간초과를 맞아버림.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String exclusive = br.readLine();
    Stack<Character> stack = new Stack<>();
    for(int i=0; i<input.length(); i++) {
      stack.push(input.charAt(i));
      if(stack.size() >= exclusive.length()) {
        int count = 0;
        for(int k=0; k<exclusive.length(); k++) {
          if(stack.get(stack.size() - exclusive.length() + k) == exclusive.charAt(k)) {
            count++;
          }
          if(count == exclusive.length()) {
            for(int j=0; j<exclusive.length(); j++) {
              stack.pop();
            }
          }
        }
      }
    }
    if(stack.isEmpty()) {
      System.out.println("FRULA");
    } else {
      StringBuilder sb = new StringBuilder();
      for (Character character : stack) {
        sb.append(character);
      }
      System.out.println(sb.toString());
    }
  }

}
