package baekJoon.normal;

import java.util.*;
import java.io.*;

public class A와B {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder current = new StringBuilder(br.readLine());
    StringBuilder target = new StringBuilder(br.readLine());
    while(target.length() > current.length()) {
      if(target.charAt(target.length() - 1) == 'A') {
        target.deleteCharAt(target.length() - 1);
      } else {
        target.deleteCharAt(target.length() - 1);
        target.reverse();
      }
    }
    System.out.println(target.toString().contentEquals(current) ? 1 : 0);

  }
}
