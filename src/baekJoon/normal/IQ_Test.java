package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IQ_Test {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    if(n == 1 || (n == 2) && arr[0] != arr[1]) {
      // 이 경우가 아니면 A가 나올 일은 없다.
      System.out.println("A");
    } else if(n == 2) {
      System.out.println(arr[0]);
    } else {
      int a, b;
      if(arr[0] == arr[1]) {
        // (arr[1] - arr[0]) 을 나누는 과정이 있는데, 이때 이 둘이 같으먄 devideByZero 예외가 발생하게 된다.
        a = 1;
        b = 0;
      } else {
        a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
        b = arr[2] - arr[1] * a;
      }
      if(check(a, b, n, arr)) {
        System.out.println(arr[n-1]*a + b);
      } else {
        System.out.println("B");
      }
    }

  }

  static boolean check(int a, int b, int n, int[] arr) {
    for(int i=1; i<n; i++) {
      if(arr[i] != arr[i-1] * a + b) {
        return false;
      }
    }
    return true;
  }
}
