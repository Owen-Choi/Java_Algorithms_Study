package BaekJoon;

import java.io.*;
import java.util.PriorityQueue;

// 1927번
public class Minimum_Heap {
    static int Input;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Input = Integer.parseInt(br.readLine());
        for(int i=0; i<Input; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                if(queue.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(queue.poll()+"\n");
            }
            else
                queue.offer(temp);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
