package baekJoon.normal;

import java.io.*;
import java.util.*;
import java.util.Deque;

public class 괄호_추가하기 {

  static int result = Integer.MIN_VALUE;
  static List<Integer> list = new ArrayList<>();
  static String input;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    input = br.readLine();
    // n/2 개의 위치에 괄호를 둘 수 있음
    for (int i = 0; i <= n / 2; i++) {
      combination(0, 0, i >=5 ? i/2 + 1 : i/2, new boolean[n / 2]);
      combination(1, 0, i >=5 ? i/2 + 1 : i/2, new boolean[n / 2]);
    }
    System.out.println(result);
  }

  static void combination(int start, int depth, int max, boolean[] flag) {
    if (depth == max) {
      calc();
      return;
    }
    for (int i = start; i < input.length() / 2; i+=2) {
      if (!flag[i]) {
        flag[i] = true;
        list.add(i);
        combination(i, depth + 1, max, flag);
        list.remove(list.size() - 1);
        flag[i] = false;
      }
    }
  }

  static void calc() {
    int tempResult = 0;
    int prev, latter;
    Deque<String> queue = new LinkedList<>();
//    for(int i=0; i<list.size(); i++) {
//      // i * 2 + 1 이 식에서의 실제 괄호 위치이다.
//      // 그럼으로 i*2가 이전 수, i*2 + 2가 이후 수가 된다.
//      index = list.get(i) * 2 + 1;
//      prev = input.charAt(index - 1) - '0';
//      latter = input.charAt(index + 1) - '0';
//      int result = 0;
//      if (input.charAt(index) == '+') {
//        result = prev + latter;
//      } else if (input.charAt(index) == '-') {
//        result = prev - latter;
//      } else {
//        result = prev * latter;
//      }
//      // 인덱스를 맞추기 위해서 일단 공백을 넣어두겠다. => 잘못된 발상. 자릿수에 따라 공백의 길이가 달라져야 한다.
//      // 복잡하다. 다녀와서 큐를 활용한 방법으로 바꿔보자.
//      // 반복문의 범위를 입력 문자열 전체로 바꾸고, 순회하면서 연산자가 나왔을 때 이 연산자가 백트래킹으로 얻은 조합의 연산자라면
//      // 큐에 계산한 값을 담고, 그렇지 않을 경우는 그냥 원본 캐릭터를 담는 식으로 진행해보자.
//      inputCopy.replace(index-1, index+2, " " + '&' + " ");
//    }
    int counter = 0;
    for (int i = 0; i < input.length(); i++) {
      if ((input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*')
          && counter < list.size() && list.get(counter) * 2 + 1 == i) {
        // 앞뒤로 다 계산한 뒤 큐에 넣어주기
        counter++;
        prev = input.charAt(i - 1) - '0';
        latter = input.charAt(i + 1) - '0';
        tempResult = input.charAt(i) == '+' ? prev + latter
            : input.charAt(i) == '-' ? prev - latter : prev * latter;
        // 이전에 들어간 값을 하나 제거해준다.
        queue.pollLast();
        queue.offer(String.valueOf(tempResult));
        i++;
      } else {
        queue.offer(String.valueOf(input.charAt(i)));
      }
    }

    if (!queue.isEmpty()) {
      tempResult = Integer.parseInt(queue.poll());
    }
    while (!queue.isEmpty()) {
      String operation = queue.poll();
      if (operation.equals("+")) {
        tempResult += Integer.parseInt(queue.poll());
      } else if (operation.equals("-")) {
        tempResult -= Integer.parseInt(queue.poll());
      } else if (operation.equals("*")) {
        tempResult *= Integer.parseInt(queue.poll());
      }
    }
    result = Math.max(result, tempResult);
//    inputCopy = new StringBuilder(inputCopy.toString().replaceAll(" ", ""));
//    // 괄호를 먼저 계산했으니 이제 남은 부분을 다 계산해준다.
//    tempResult = inputCopy.charAt(0) - '0';
//    System.out.println(inputCopy.toString());
//    for (int i = 1; i <= inputCopy.length() - 1; i += 2) {
//      latter = inputCopy.charAt(i + 1) - '0';
//      if (inputCopy.charAt(i) == '+') {
//        tempResult += latter;
//      } else if (inputCopy.charAt(i) == '-') {
//        tempResult -= latter;
//      } else {
//        tempResult *= latter;
//      }
//    }
//    result = Math.max(result, tempResult);
  }

}
