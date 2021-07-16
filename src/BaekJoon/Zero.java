package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
// 10773번
public class Zero {
    static int total = 0;
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Input = Integer.parseInt(br.readLine());

        int temp = Input;
        while(Input > 0){
            Input--;
            int tempNum = Integer.parseInt(br.readLine());
            if(tempNum == 0){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(tempNum);
        }
        for(int A : stack){
            total += A;
        }
        System.out.println(total);
    }
}
