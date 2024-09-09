package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 도서관 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n, m;
    // n : 전체 책의 수
    // m : 한 번에 들 수 있는 책의 수
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    // 양수와 음수를 나눠서 다룸.
    PriorityQueue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> neg = new PriorityQueue<>(Collections.reverseOrder());

    int input;
    for(int i=0; i<n; i++) {
      input = Integer.parseInt(st.nextToken());
      if(input > 0) pos.offer(input);
      else neg.offer(input * -1);
    }

    // 멀리 떨어진 책부터 가져와야 최적의 동선으로 이동할 수 있음.
    // 그 전에 가장 멀리 있는 책 하나를 빼고 시작. 이 책을 마지막에 가지러 갈 것이기 때문에.
    int max;
    // 둘 다 비어있는 경우는 입력으로 주어지지 않는다.
    if(pos.isEmpty()) {
      max = neg.peek();
    } else if(neg.isEmpty()) {
      max = pos.peek();
    } else {
      max = Math.max(pos.peek(), neg.peek());
    }

    int result = 0;
    // 둘 중 하나가 비어 있지 않을 때까지
    while(!pos.isEmpty() && !neg.isEmpty()) {
      if(pos.peek() > neg.peek()) {
        result += pos.peek() * 2;
        for(int i=0; i<m; i++) {
          // pos에서 빼준다.
          if(!pos.isEmpty()) {
            // 그냥 큐에서 빼주기만 하고, 결과에는 최초에 얻었던 peek() 에 2를 곱한 값만 넣어준다.
            pos.poll();
          } else break;
        }
        //
      } else {
        result += neg.peek() * 2;
        for(int i=0; i<m; i++) {
          if(!neg.isEmpty()) {
            neg.poll();
          } else break;
        }
      }
    }

    // 나머지 큐 하나를 비워준다.
    // TODO 코드가 너무너무 더럽다.
    if(!pos.isEmpty()) {
      while(!pos.isEmpty()) {
        result += pos.peek() * 2;
        for(int i=0; i<m; i++) {
         if(!pos.isEmpty()) {
           pos.poll();
         } else break;
        }
      }
    } else if(!neg.isEmpty()) {
      while(!neg.isEmpty()) {
        result += neg.peek() * 2;
        for(int i=0; i<m; i++) {
          if(!neg.isEmpty()) {
            neg.poll();
          } else break;
        }
      }
    }

    System.out.println(result - max);

//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    int n, m;
//    // n : 전체 책의 수
//    // m : 한 번에 들 수 있는 책의 수
//    n = Integer.parseInt(st.nextToken());
//    m = Integer.parseInt(st.nextToken());
//    st = new StringTokenizer(br.readLine());
//
//    PriorityQueue<Integer> pos = new PriorityQueue<>();
//    PriorityQueue<Integer> neg = new PriorityQueue<>(Collections.reverseOrder());
//    int temp;
//    for(int i=0; i<n; i++) {
//      temp = Integer.parseInt(st.nextToken());
//      if(temp > 0)
//        pos.offer(temp);
//      else
//        neg.offer(temp);
//    }
//
//    while(!pos.isEmpty() && !neg.isEmpty()) {
//      if (Math.abs(pos.peek()) < Math.abs(neg.peek())) {
//        // 절댓값이 더 작은 진영이 아니라, 더 큰 진영을 골라야 함.
//
//
//      } else {
//
//      }
//    }

  }
}
