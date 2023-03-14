package baekJoon.normal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 18258번
public class Queue_2 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String temp;
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int PushVal, T;
        PushVal = -1;
        Queue<Integer> queue = new LinkedList<>();
        // offer나 poll은 연산에 실패하면 false를 반환.
        //add나 remove는 연산에 실패하면 예외를 발생시킴.
        while(N --> 0) {
            st = new StringTokenizer(br.readLine()," ");
            temp = st.nextToken();
            switch (temp) {
                case "push" :
                    PushVal = Integer.parseInt(st.nextToken());
                    queue.offer(PushVal);
                    break;
                case "pop" :
                    if(queue.isEmpty()){
                        sb.append(-1).append('\n');
                        break;
                    }
                    else {
                        sb.append(queue.poll()).append('\n');
                        break;
                    }
                case "size" :
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty" :
                    T = queue.isEmpty() ? 1 : 0;
                    sb.append(T).append('\n');
                    break;
                case "front" :
                    if(queue.isEmpty()){
                        sb.append(-1).append('\n');
                        break;
                    }
                    else {
                        sb.append(queue.peek()).append('\n');
                        break;
                    }
                case "back" :
                    if(queue.isEmpty()) {
                        sb.append(-1).append('\n');
                        break;
                    }
                    else{
                        sb.append(PushVal).append('\n');
                    }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
