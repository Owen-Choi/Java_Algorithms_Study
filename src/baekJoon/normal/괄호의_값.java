package baekJoon.normal;

import java.io.*;
import java.util.Stack;

public class 괄호의_값 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // stack 활용하기
        Stack<Character> stack = new Stack<>();
        // 스택을 까 봄과 동시에 계산을 시작한다.

        long result = 0;
//        분배법칙
        long mul = 1;
        char ch;
        char tempCh = '\0';
        if(input.charAt(0) == ')' || input.charAt(0) == ']') {
            System.out.println(0);
            return;
        }
        for(int i=0; i<input.length(); i++) {
            ch = input.charAt(i);
            if(ch == '(' || ch == '[') {
                mul = ch == '(' ? mul * 2 : mul * 3;
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                if(ch == ')' && stack.peek() == '(') {
                    // 직전 값이 닫힌 괄호라면 그 괄호는 연산해주면 안된다.
                    // 아니면 ([()]) 와 같이 가장 안에 있는 알맹이 ()를 계산할 때 말고도 마무리 괄호 단계에서 계속 값이 곱해진다.
                    mul /= 2;
                    if(tempCh != ')' && tempCh != ']') {
                        result += mul * 2;
                    }
                } else if(ch == ']' && stack.peek() == '[') {
                    mul /= 3;
                    if(tempCh != ')' && tempCh != ']') {
                        result += mul * 3;
                    }
                } else {
                    System.out.println(0);
                    return;
                }
                stack.pop();
            }
            tempCh = ch;
        }

        // 마지막에 스택이 비어있지 않다면 0 반환
        System.out.println(stack.isEmpty() ? result : 0);

//        int tempMul = 0;
//        for(int i=0; i<input.length(); i++) {
//            tempChar = input.charAt(i);
//            if(tempChar == '(' || tempChar == '[')
//                stack.push(tempChar);
//            else {
//                // 닫힌게 들어왔다면
//                // ()[()[]]
//                if(tempChar == ')' && stack.peek() == '(') {
//                    // 먼저 pop한 다음에, 다음 peek() 의 결과가 열린 괄호일 경우 값이 곱해질 것임. 임시 값에 저장해두고 나중에 곱해줌.
//                    // peek()의 결과가 닫힌 괄호일 경우 값을 바로 더해주면 됨.
//                    stack.pop();
//                    if(stack.isEmpty()) {
//                        // 스택이 비었다면 2를 더해준 뒤 계속 진행
//                        result += 2;
//                        continue;
//                    }
//
//                    if(stack.peek() == '(' || stack.peek() == '[') {
//                        tempMul
//                    } else
//                        result += 2;
//                } else if(tempChar == ']' && stack.peek() == '[') {
//                    stack.pop();
//                    if(stack.isEmpty()) {
//                        // 스택이 비었다면 3을 더해준 뒤 계속 진행
//                        result += 3;
//                        continue;
//                    }
//
//
//                    result += 3;
//                } else {
//                    System.out.println("0");
//                    return;
//                }
//            }
//        }


    }
}
