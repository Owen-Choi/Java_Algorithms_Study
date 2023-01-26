package baekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
// 10866번
public class Deque {
    static int TestCase;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TestCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String temp;
        int tempVal = 0;
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> deque = new LinkedList<>();
        while(TestCase --> 0) {
            st = new StringTokenizer(br.readLine()," ");
            temp = st.nextToken();
            switch (temp) {
                case "push_front" :
                    tempVal = Integer.parseInt(st.nextToken());
                    deque.addFirst(tempVal);
                    break;
                case "push_back" :
                    tempVal = Integer.parseInt(st.nextToken());
                    deque.addLast(tempVal);
                    break;
                case "pop_front" :
                    if(deque.isEmpty()) {
                        sb.append(-1).append('\n');
                        break;
                    }
                    sb.append(deque.removeFirst()).append('\n');
                    break;
                case "pop_back" :
                    if(deque.isEmpty()) {
                        sb.append(-1).append('\n');
                        break;
                    }
                    sb.append(deque.removeLast()).append('\n');
                    break;
                case "size" :
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty" :
                    int t = deque.isEmpty() ? 1 : 0;
                    sb.append(t).append('\n');
                    break;
                case "front" :
                    if(deque.isEmpty()) {
                        sb.append(-1).append('\n');
                        break;
                    }
                    sb.append(deque.peekFirst()).append('\n');
                    break;
                case "back" :
                    if(deque.isEmpty()) {
                        sb.append(-1).append('\n');
                        break;
                    }
                    sb.append(deque.peekLast()).append('\n');
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
