package BaekJoon;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
// 11279번
public class Maximum_Heap {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int temp;
        while(N --> 0) {
            temp = Integer.parseInt(br.readLine());
            if(temp == 0) {
                if(pq.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(pq.poll()).append('\n');
            }
            else {
                pq.add(temp);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
