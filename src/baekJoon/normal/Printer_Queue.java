package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 1966번
public class Printer_Queue {
    static int TestCase, PrintNum, TargetIndex;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TestCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        LinkedList<Node> Origin_queue;
        StringBuilder sb = new StringBuilder();
        int temp, Count;   boolean Check;
        while(TestCase --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            PrintNum = Integer.parseInt(st.nextToken());
            TargetIndex = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            Origin_queue = new LinkedList<>();
            Node tempNode;
            for (int i = 0; i < PrintNum; i++) {
                temp = Integer.parseInt(st.nextToken());
                Origin_queue.offer(new Node(i, temp));
            }
            Count = 0;
            while(!Origin_queue.isEmpty()) {
                Check = true;
                tempNode = Origin_queue.poll();
                for(int i=0; i<Origin_queue.size(); i++) {
                    if(tempNode.Priority < Origin_queue.get(i).Priority) {
                        Origin_queue.offer(tempNode);
                        for(int k=0; k<i; k++)
                            Origin_queue.offer(Origin_queue.poll());
                        Check = false;
                        break;
                    }
                }
                if(!Check)
                    continue;
                else {
                    Count++;
                    if(tempNode.Index == TargetIndex) {
                        sb.append(Count).append('\n');
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
        br.close();
    }

    static class Node{
        int Index;
        int Priority;

        public Node(int Ind, int Prio) {
            Index = Ind;
            Priority = Prio;
        }
    }
}
