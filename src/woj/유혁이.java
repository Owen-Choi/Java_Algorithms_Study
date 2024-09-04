package woj;

import java.util.*;
import java.io.*;

public class 유혁이 {

  public static void main(String[] args) throws IOException{
    // 10 -> 5 -> 2 -> 1
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    recur(n);
  }

  static void recur(int n) {
    System.out.println(n);
    if(n == 1) {
      return;
    }
    recur(n/2);
  }

}
