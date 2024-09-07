package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 친구비 {

    static int[] parent;
    static int[] cost;

    // 유니온 파인드 이용하는 문제
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m, k;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        parent = new int[n];
        cost = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }


        /*
            찾기 어려웠던 예외가 있었다.
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int s, d;
                s = Integer.parseInt(st.nextToken()) - 1;
                d = Integer.parseInt(st.nextToken()) - 1;
                unionParent(s,d);
            }
            위처럼 입력을 받음과 동시에 유니온을 해주면,
            5 4 10000
            10 10 20 20 30
            1 3
            2 3
            5 4
            4 3
            이 테스트케이스에서 부모 배열이 0 0 0 0 3 이 나와버린다.
            따라서 해쉬셋에는 0,3이 들어가버리고, 오답이 된다.
         */

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s, d;
            s = Integer.parseInt(st.nextToken()) - 1;
            d = Integer.parseInt(st.nextToken()) - 1;
            unionParent(s, d);
        }

        for(int i=0; i<n; i++) {
            findParent(i);
        }

        Set<Integer> index = new HashSet<>();
        for (int i : parent) {
            index.add(i);
        }

        long required = 0;
        for (Integer i : index) {
            required += cost[findParent(i)];
        }

        System.out.println(k >= required ? required : "Oh no");

    }

    static int findParent(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    static void unionParent(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if(cost[x] > cost[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }

}
