package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Finding_Parent_of_Tree_BFS {
    static int NodeNum;
    static ArrayList<Integer>[] list;
    static int[] parent;
    static boolean[] flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NodeNum = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList[NodeNum + 1];
        parent = new int[NodeNum + 1];
        flag = new boolean[NodeNum + 1];
        int TempStart, TempDest;
        for(int i=0; i<=NodeNum; i++)
            list[i]= new ArrayList<>();
        for(int i=0; i<NodeNum - 1; i++) {
            st = new StringTokenizer(br.readLine()," ");
            TempStart = Integer.parseInt(st.nextToken());
            TempDest = Integer.parseInt(st.nextToken());
            list[TempStart].add(TempDest);
            list[TempDest].add(TempStart);
        }
        //Input End
        for(int k=1; k<=NodeNum; k++) {
            if(!flag[k])
                Solve(k);
        }
        for(int k=2; k<=NodeNum; k++)
            System.out.println(parent[k]);
    }
    private static void Solve(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        int tempValue;
        while(!queue.isEmpty()){
            tempValue = queue.poll();
            if(flag[tempValue])
                continue;
            // Arraylist와 enhanced for 루프 사용법 다시한번 생각해보자.
            System.out.println(tempValue + "##");
            for (int temp : list[tempValue]) {
                System.out.println(temp);
                if(!flag[temp]) {
                    flag[temp] = true;
                    parent[temp] = tempValue;
                    queue.offer(temp);
                }
            }
            System.out.println();
        }
    }
}
