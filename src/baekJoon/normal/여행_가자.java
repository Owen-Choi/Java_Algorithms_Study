package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 여행_가자 {
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int plan = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        StringTokenizer st;

        for(int i=1; i<=n; i++) {
            parent[i] = i;
        }

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k=1; k<=n; k++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    // 연결이 된 족족 유니온 파인드로 합쳐준다.
                    union(i, k);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        // 처음 출발하는 도시와 이후에 방문하는 도시가 모두 같은 부모를 가져야만 ( == 연결되어 있어야만) 방문할 수 있다.
        int source = Integer.parseInt(st.nextToken());
        source = findParent(source);
        for(int i=1; i<plan; i++) {
            int destination = Integer.parseInt(st.nextToken());
            if(source != findParent(destination)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }

    // x의 부모를 찾음.
    static int findParent(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if(x > y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }
}
