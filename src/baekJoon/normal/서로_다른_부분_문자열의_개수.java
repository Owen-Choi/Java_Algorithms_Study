package baekJoon.normal;

import java.io.*;
import java.util.*;
public class 서로_다른_부분_문자열의_개수 {

  static Set<String> set;
  static String input;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input = br.readLine();
    set = new HashSet<>();
    for(int i=0; i<input.length(); i++) {
      for(int k=i+1; k<=input.length(); k++) {
        set.add(input.substring(i,k));
      }
    }
    System.out.println(set.size());
  }
}
