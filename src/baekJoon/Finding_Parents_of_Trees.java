package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 11725 ::
public class Finding_Parents_of_Trees {
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
        // Input ends ::
        Solve();
    }
    static void Solve() {
        for(int k=1; k<=NodeNum; k++) {
            if(!flag[k])
                recur(k);
        }
        for(int i=2; i<=NodeNum; i++)
            System.out.println(parent[i]);
    }
    static void recur(int index) {
        if(flag[index])
            return;
        flag[index] = true;
        // 연결된 간선들 타고 들어가서 부모 업데이트해줌.
        for (int value : list[index]) {
            if(!flag[value]) {
                parent[value] = index;
                recur(value);
            }
        }
    }
}
