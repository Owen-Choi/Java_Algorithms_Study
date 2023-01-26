package baekJoon;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

// 1655번
public class Lets_Say_The_Middle {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int temp;
        PriorityQueue<Integer> MinHeap = new PriorityQueue<>();
        PriorityQueue<Integer> MaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        while(N --> 0){
            temp = Integer.parseInt(br.readLine());
            if(MinHeap.size() == MaxHeap.size())
                MaxHeap.offer(temp);
            else MinHeap.offer(temp);
            if(!MinHeap.isEmpty() && !MaxHeap.isEmpty()) {
                if(MaxHeap.peek() > MinHeap.peek()) {
                    int T = MinHeap.poll();
                    MinHeap.offer(MaxHeap.poll());
                    MaxHeap.offer(T);
                }
            }
            sb.append(MaxHeap.peek()).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
