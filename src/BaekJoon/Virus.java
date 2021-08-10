package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 2606번
public class Virus {
    static int Com;
    static int listNum;
    static boolean[] check;
    static ArrayList<Integer>[] list;
    static int TotalNum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Com = Integer.parseInt(br.readLine());
        listNum = Integer.parseInt(br.readLine());
        check = new boolean[Com];
        list = new ArrayList[Com];
        for(int i=0; i<Com; i++){
            list[i] = new ArrayList<>();
        }
        int Start, Finish;
        StringTokenizer st;
        for(int i=0; i<listNum; i++){
            st = new StringTokenizer(br.readLine(), " ");
            Start = Integer.parseInt(st.nextToken());
            Finish = Integer.parseInt(st.nextToken());
            list[Start - 1].add(Finish - 1);
            list[Finish - 1].add(Start-1);
        }
        DFS();
        System.out.println(TotalNum);
    }
    static void DFS() {
        int k;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<list[0].size(); i++){
            queue.offer(list[0].get(i));
        }
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            if(!check[temp] && temp != 0){
                check[temp] = true;
                TotalNum++;
                for(k = 0; k<list[temp].size(); k++){
                    queue.offer(list[temp].get(k));
                }
            }
        }
    }
}
