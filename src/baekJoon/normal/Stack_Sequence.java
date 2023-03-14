package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 1874번
public class Stack_Sequence {
    static int [] arr;
    static int N;
    static int Max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int temp = 0;
        for(int i=0; i<N; i++) {
            if(stack.isEmpty()) {
                for(int k = Max; k<arr[i]; k++) {
                    stack.push(k + 1);
                    sb.append('+').append('\n');
                }
            }
                if (stack.peek() == arr[i]) {
                    temp = stack.pop();
                    Max = Math.max(Max, temp);
                    sb.append('-').append('\n');
                }
                else if(stack.peek() < arr[i]) {
                    for(int k = Max; k<arr[i]; k++) {
                        stack.push(k+1);
                        sb.append('+').append('\n');
                    }
                    temp = stack.pop();
                    sb.append('-').append('\n');
                    Max = Math.max(Max, temp);
                }
                else{
                    System.out.println("NO");
                    System.exit(0);
                }
        }
        System.out.println(sb);
    }
}
