package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2644번, 촌수계산, 그래프탐색
public class Calc_Family_Relationship {

    static int n;
    static int t1, t2;
    static int m;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] flag;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        t1 = Integer.parseInt(st.nextToken()) - 1;
        t2 = Integer.parseInt(st.nextToken()) - 1;
        m = Integer.parseInt(br.readLine());

        flag = new boolean[n];

        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list.get(first - 1).add(second - 1);
            list.get(second - 1).add(first - 1);
        }

        flag[t1] = true;
        dfs(t1, 0);
        System.out.println(result);
    }

    static void dfs(int index, int counter) {
        if(list.get(index).size() == 0)
            return;

        counter++;
        for (int i : list.get(index)) {
            if(!flag[i]) {
                if(i == t2) {
                    result = counter;
                    return;
                } else {
                    flag[i] = true;
                    dfs(i, counter);
                    flag[i] = false;
                }
            }
        }
    }

//    static void dfs(int index, int counter) {
//        if(list.get(index).size() == 0) {
//            return;
//        }
//        for (int i : list.get(index)) {
//            if(i == t2) {
//                counter += 2;
//                result = counter;
//                return;
//            }
//        }
//        // 위 반복문에서 종료되지 않았다는 것은 가로(형제 자매 라인) 탐색에서 목표를 찾지 못했다는 말.
//
//        for (int k : list.get(index)) {
//            // 그때부터는 연결된 다른 집안으로 넘어가서 그 집안의 형제 자매 라인을 살펴본다.
//            dfs(k, counter);
//        }
//    }

}
