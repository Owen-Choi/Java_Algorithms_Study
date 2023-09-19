package woj;

import java.util.Scanner;
import java.util.Stack;

public class SteelStick {
    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.next();
        int stickCounter = 0;
        long result = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<input.length(); i++) {
            char e = input.charAt(i);
            if(e == '(') {
                // 일단 열린 괄호가 나오면 스택에 넣어주고 카운트를 추가해준다.
                // 나중에 레이저로 판명될 경우 카운터를 다시 빼줄 예정이다.
                stack.push(e);
                stickCounter++;
            } else if(e == ')') {
                if(stack.peek() == '(') {
                    // 이 경우 방금 입력은 레이저에 대한 입력이다.
                    // 카운트를 빼주고 남은 카운트를 반으로 나눈 값을 결과에 더해준다.
                    stack.pop();
                    stickCounter--;
                    result += stickCounter;
                    stack.push(')');
                } else {
                    // 레어저가 아니라 막대가 끝났음을 알리는 닫힌 괄호일 경우
                    // 카운트를 하나 빼줌과 동시에 결과에 1을 더해준다. (끝난 조각)
                    stickCounter--;
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
