package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_Queue {

    static int N;
    public static void main(String[] args) throws IOException {
        java.util.Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int back = -1;
        while(N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if(command.equals("push")) {
                int push = Integer.parseInt(st.nextToken());
                back = push;
                queue.offer(push);
                continue;
            } else if(command.equals("front")) {
                if(queue.size() == 0) {
                    sb.append(-1);
                } else {
                    sb.append(queue.peek());
                }
            } else if(command.equals("pop")) {
                if(queue.size() == 0) {
                    sb.append(-1);
                } else {
                    sb.append(queue.poll());
                    if(queue.isEmpty()) {
                        back = -1;
                    }
                }
            } else if(command.equals("size")) {
                sb.append(queue.size());
            } else if(command.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            } else if(command.equals("back")) {
                sb.append(back);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
