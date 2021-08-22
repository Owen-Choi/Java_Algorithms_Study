package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 1966번
public class Printer_Queue {
    static int testCase, N, targetIndex;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq;
        int temp, Target = 0;
        while(testCase --> 0) {
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            targetIndex = Integer.parseInt(st.nextToken());
            pq = new PriorityQueue<>(Comparator.reverseOrder());
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<N; i++) {
                temp = Integer.parseInt(st.nextToken());
                pq.offer(temp);
                if(i == targetIndex)
                    Target = temp;
            }
            int Count = 0, ForSame = 0;
            while(!pq.isEmpty()) {
                temp = pq.poll();
                if(temp == Target && ForSame == 0) {
                    ForSame = Count;
                    continue;
                }
                else if(temp == Target) {
                    ForSame++;
                }
                Count++;
            }
            sb.append(ForSame).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}
