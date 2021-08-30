package BaekJoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

// 11286번
public class Absolute_Value_Of_Heap {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        MyComparator mc = new MyComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<>(mc);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
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
                pq.offer(temp);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
static class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        int absol1 = Math.abs(o1);
        int absol2 = Math.abs(o2);
        if(absol1 == absol2)
            return o1 > o2 ? 1 : -1;
        else return absol1 - absol2;
    }
}
}
