package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hide_and_Seek_4 {

    static int N, K;
    static int min = Integer.MAX_VALUE;
    static String result;
    static boolean[] flag = new boolean[100001];
    static class Node {
        int num;
        int count;
        String accum;

        public Node (int num, int count, String accum) {
            this.num = num;
            this.count = count;
            this.accum = accum;
        }

        public void setAccum(String accum) {
            this.accum = accum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(N, 0, "");
        queue.add(node);
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            poll.setAccum(poll.accum + " " + poll.num + " ");
            if(poll.num == K) {
                if(min > poll.count) {
                    min = poll.count;
                    result = poll.accum;
                }
            } else {
                    if(poll.num * 2 >= 0 && poll.num * 2 <= 100000) {
                        if(!flag[poll.num * 2]) {
                            Node tempNodeDouble = new Node(poll.num * 2, poll.count + 1, poll.accum);
                            queue.add(tempNodeDouble);
                            flag[poll.num * 2] = true;
                        }
                    }
                    if(poll.num + 1 >= 0 && poll.num + 1 <= 100000) {
                        if(!flag[poll.num + 1]) {
                            Node tempNodePlus = new Node(poll.num + 1, poll.count + 1, poll.accum);
                            queue.add(tempNodePlus);
                            flag[poll.num + 1] = true;
                        }
                    }
                    if(poll.num - 1 >= 0 && poll.num - 1 <= 100000) {
                        if(!flag[poll.num - 1]) {
                            Node tempNodeMinus = new Node(poll.num - 1, poll.count + 1, poll.accum);
                            queue.add(tempNodeMinus);
                            flag[poll.num - 1] = true;
                        }
                    }
            }
        }

        System.out.println(min);
        System.out.println(result.substring(1, result.length() - 1));
    }
}
