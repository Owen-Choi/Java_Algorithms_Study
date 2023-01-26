package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
// 4949번
public class Balanced_World {
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp = br.readLine();
        while(!temp.equals(".")){
            Stack<Character> stack = new Stack<>();
            arr = temp.toCharArray();
            for(int i=0; i<arr.length; i++) {
                if(arr[i] == '(' || arr[i] == '['){
                    stack.push(arr[i]);
                }
                else if(arr[i] == ')' || arr[i] == ']') {
                        if(arr[i] == ')') {
                            if(stack.isEmpty() || stack.peek() != '(') {
                                stack.push('%');
                                break;
                            }
                            else
                                stack.pop();
                        }
                        else if(arr[i] == ']') {
                            if(stack.isEmpty() || stack.peek() != '[') {
                                stack.push('%');
                                break;
                            }
                            else
                                stack.pop();
                        }
                }
            }

            if(stack.isEmpty())
                sb.append("yes").append('\n');
            else
                sb.append("no").append('\n');
            temp = br.readLine();
        }
        System.out.println(sb);
    }
}
