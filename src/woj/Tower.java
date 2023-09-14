package woj;

import java.util.Scanner;
import java.util.Stack;

//5
//6 9 5 7 4
// 입력으로 들어온 탑이 stack 가장 위에 있는 탑보다 클 경우 => 스택의 가장 위에 있는 탑을 pop, stack이 빌때까지 계속 반복;
// 만약 이 과정에서 stack이 비게 된다면 0을 출력 후 본인을 push하고 break
// 입력으로 들어온 탑이 stack 가장 위에 있는 탑보다 작을 경우 => 스택에 본인을 push, 스택의 가장 위에 있는 탑의 인덱스를 출력
public class Tower {
    public static void main(String[] args) {
        int n;
        int[] towers;
        Stack<Node> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = sc.nextInt();
        towers = new int[n];
        for(int i=0; i<n; i++) {
            towers[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty()) {
                if(stack.peek().height >= towers[i]) {
                    sb.append(stack.peek().index + 1).append(" ");
                    break;
                } else {
                    stack.pop();
                }
            }
            if(stack.isEmpty()) {
                sb.append("0").append(" ");
            }
            stack.push(new Node(i, towers[i]));
        }

        System.out.println(sb.toString());
    }

    static class Node {
        int index;
        int height;

        public Node(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
