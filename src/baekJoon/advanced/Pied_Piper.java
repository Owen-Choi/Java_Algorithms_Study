package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 16724번, 피리 부는 사나이
public class Pied_Piper {
    static int N, M;
    static char[][] map;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2차원 배열을 1차원 배열로 표현하기 위해서 크기를 다음과 같이 설정했다.
        parent = new int[N * M];
        map = new char[N][M];

        for(int i=0; i<parent.length; i++) {
            parent[i] = i;
        }

        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<N; i++) {
            for(int k=0; k<M; k++) {
                int currentIdx = i*M + k;
                int nextIdx = getByDirection(i, k);
                if(find(currentIdx) != find(nextIdx)) {
                    union(currentIdx, nextIdx);
                }
            }
        }
        getResult();
    }

    public static int getByDirection(int x, int y) {
        int tempX = x;
        int tempY = y;
        if(map[x][y] == 'U') {
            tempX--;
        } else if(map[x][y] == 'D') {
            tempX++;
        } else if(map[x][y] == 'R') {
            tempY++;
        } else if(map[x][y] == 'L'){
            tempY--;
        }
        return tempX * M + tempY;
    }

    // 유니온 파인드 알고리즘의 일부 - 부모 노드를 찾는 함수
    public static int find(int idx) {
        if(parent[idx] == idx) {
            return idx;
        } else {
            // 이렇게 parent[idx]를 업데이트 해주는 이유는 다음과 같다.
            // 루트 노드가 아닌 노드에 대해서 부모를 루트로 업데이트 해주지 않으면
            // 일부 경우에 대해서 O(N) 이라는 시간 복잡도를 얻기 때문에 효율적이지 않다.
            // 따라서 루트 노드가 아닌 노드에 대해서는 부모를 루트로 바로 업데이트 해주도록 한다.
            return parent[idx] = find(parent[idx]);
        }
    }

    public static void union(int x, int y) {
        int idx1 = find(x);
        int idx2 = find(y);

        if(idx1 > idx2) {
            parent[idx1] = idx2;
        } else {
            parent[idx2] = idx1;
        }
    }

    public static void getResult() {
        // 중복 제거용 해쉬셋
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i< parent.length; i++) {
            // 앞에서 집합별로 parent를 다 나눠둔다.
            // 그렇기 때문에 중복을 제거한 해쉬셋의 총 부모 수가 집합의 수가 된다.
            hashSet.add(find(i));
        }
        System.out.println(hashSet.size());
    }
}
