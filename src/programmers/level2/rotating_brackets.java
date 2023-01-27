package programmers.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class rotating_brackets {
    public static void main(String[] args) throws IOException{
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String rotatedStr = input;
        Stack<Character> stack = new Stack<>();

        // 길이가 1이면 정답은 반드시 0이다.
        if(input.length() == 1) {
            System.out.println(0);
        } else {
            do{
                stack.add(rotatedStr.charAt(0));

                // 시작부터 닫힌 괄호가 나오면 해당 문자열은 올바른 괄호 문자열이 될 수 없다.
                if(rotatedStr.charAt(0) == ')'
                        || rotatedStr.charAt(0) == '}'
                        || rotatedStr.charAt(0) == ']') {
                    stack.clear();
                    rotatedStr = rotatedStr.substring(1) + rotatedStr.charAt(0);
                    continue;
                }

                for(int i=1; i<input.length(); i++) {
                    if(rotatedStr.charAt(i) == ')') {
                        if(stack.isEmpty()) {
                            stack.add('c');
                            break;
                        } else if(stack.peek() != '(') {
                            break;
                        }
                        stack.pop();
                    } else if(rotatedStr.charAt(i) == '}') {
                        if(stack.isEmpty()) {
                            stack.add('c');
                            break;
                        } else if(stack.peek() != '{') {
                            break;
                        }
                        stack.pop();
                    } else if(rotatedStr.charAt(i) == ']') {
                        if(stack.isEmpty()) {
                            stack.add('c');
                            break;
                        } else if(stack.peek() != '[') {
                            break;
                        }
                        stack.pop();
                    } else {
                        stack.push(rotatedStr.charAt(i));
                    }
                }

                if(stack.size() == 0) {
                    answer++;
                }
                stack.clear();
                rotatedStr = rotatedStr.substring(1) + rotatedStr.charAt(0);
            } while(!rotatedStr.equals(input));
        }

        System.out.println(answer);
    }
}
