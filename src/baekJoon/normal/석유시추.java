package baekJoon.normal;

import java.util.*;
import java.io.*;


/* TODO
    아쉬웠던 boolean 배열 판단으로 효율성 검증에서 틀렸던 문제.
    잘 생각해보면 boolean 배열을 하나도 사용하지 않아도 풀이할 수 있다.
    앞으로도 이런 유형이 나오면 주의하자.
 */
public class 석유시추 {
    static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        int[][] land = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };

//        int[][] land = {
//                {1, 0, 1, 0, 1, 1},
//                {1, 0, 1, 0, 0, 0},
//                {1, 0, 1, 0, 0, 1},
//                {1, 0, 0, 1, 0, 0},
//                {1, 0, 0, 1, 0, 1},
//                {1, 0, 0, 0, 0, 0},
//                {1, 1, 1, 1, 1, 1}
//        };


        int answer = new Solution().solution(land);
        System.out.println(answer);
    }
    static class Solution {
        public int solution(int[][] land) {
            // 일단 석유를 그룹화하고, 각 그룹별로 값을 맵이나 어딘가에 저장해둔다.
            // 그리고 시추관이 특정 그룹을 지난다면, 맵에서 그 그룹의 값을 가져와서 더해준다.
            // 열에 대한 반복문이 끝났을 때, 값이 가장 큰 것을 반환한다.

            int n = land.length;
            int m = land[0].length;

            int groupCount = 2;
            for(int i=0; i<n; i++) {
                for(int k=0; k<m; k++) {
                    if(land[i][k] == 1) {
                        // BFS를 수행한 뒤 그룹 값을 매긴다.
                        bfs(groupCount, n, m, new Node(i, k), land);
                        groupCount++;
                    }
                }
            }

            // 그룹별로 정리가 끝나서 맵이 만들어졌다면, 이제 열을 탐색해서 최대값을 찾는다.
            int answer = 0, tempAnswer;
            // 이렇게 하면 탐색 순서가 반대가 되어 세로로 탐색한다.
            for(int k=0; k<m; k++) {
                Set<Integer> set = new HashSet<>();
                tempAnswer = 0;
                for(int i=0; i<n; i++) {
                    if(land[i][k] != 0) {
                        set.add(land[i][k]);
                    }
                }
                // set에 담긴 그룹의 값을들 맵에서 가져와서 모두 더해준 뒤 최대값과 비교함.
                for(Integer temp : set) {
                    tempAnswer += map.get(temp);
                }
                answer = Math.max(answer, tempAnswer);
            }
            return answer;
        }
    }

    static void bfs(int groupCount, int n, int m, Node start, int[][] arr) {
        Queue<Node> queue = new LinkedList<>();
        // landFlag 는 초기화되지 않는 전체 배열, flag는 초기화되는 임시 배열
//        boolean[][] flag = new boolean[n][m];
        queue.offer(start);
        int oilSize = 0;
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for(int i=0; i<4; i++) {
                int nextX = poll.x + move[0][i];
                int nextY = poll.y + move[1][i];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                if(arr[nextX][nextY] == groupCount || arr[nextX][nextY] == 0) {
                    continue;
                }

                oilSize++;
                arr[nextX][nextY] = groupCount;
                queue.offer(new Node(nextX, nextY));
            }
        }
        // oilSize가 0이라는 말은 한 칸의 석유가 있다는 말이다. 이 경우 수동으로 1로 설정해준다.
        if(oilSize == 0) {
            oilSize = 1;
            arr[start.x][start.y] = groupCount;
        }
        map.put(groupCount, oilSize);
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y =y;
        }
    }
}
