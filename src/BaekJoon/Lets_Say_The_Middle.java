package BaekJoon;

import java.io.*;
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
        PriorityQueue<Integer> MaxHeap = new PriorityQueue<>();
        while(N --> 0){
            temp = Integer.parseInt(br.readLine());
            if(MinHeap.size() == MaxHeap.size()) {
                if(temp > MinHeap.peek()) {

                }
            }
            else {

            }
            sb.append(MaxHeap.peek()).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
