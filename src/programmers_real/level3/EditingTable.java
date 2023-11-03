package programmers_real.level3;

import java.util.*;
public class EditingTable {
    public static void main(String[] args) {
        int n = 8, k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        System.out.println(new EditingTableSolution().solution(n,k,cmd));
    }
}


class EditingTableSolution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Node> stack = new Stack<>();
        int[] pre = new int[n];
        int[] next = new int[n];
        StringBuilder sb = new StringBuilder("0".repeat(n));

        for(int i=0; i<n; i++) {
            pre[i] = i-1;
            next[i] = i+1;
        }
        next[n - 1] = -1;

        for(int i=0; i<cmd.length; i++) {
            char fl = cmd[i].charAt(0);
            if(fl == 'U') {
                int value = cmd[i].charAt(2) - '0';
                while(value --> 0) {
                    k = pre[k];
                }
            } else if(fl == 'D') {
                int value = cmd[i].charAt(2) - '0';
                while(value --> 0) {
                    k = next[k];
                }
            } else if(fl == 'C') {
                stack.push(new Node(pre[k], k, next[k]));
                sb.setCharAt(k, 'X');
                // 원래 pre[next[k]] 는 k이다. 하지만 k는 삭제될 것이기 때문에, pre[k]로 바꿔준다.
                if(next[k] != -1) pre[next[k]] = pre[k];
                // 원래 next[pre[k]] 는 k이다. 하지만 k는 삭제될 것이기 때문에, next[k]로 바꿔준다.
                if(pre[k] != -1) next[pre[k]] = next[k];
                if(next[k] != -1) k = next[k];
                else k = pre[k];
            } else {
                Node poll = stack.pop();
                if(poll.next != -1) pre[poll.next] = poll.current;
                if(poll.pre != -1) next[poll.pre] = poll.current;
                sb.setCharAt(poll.current, 'O');
            }
        }
        return sb.toString();
    }

    class Node {
        int pre;
        int current;
        int next;

        public Node(int pre, int current, int next) {
            this.pre = pre;
            this.current = current;
            this.next = next;
        }
    }
}

