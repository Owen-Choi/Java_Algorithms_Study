package programmers.level3;

public class Ranking {
    public static void main(String[] args) {
        int[][] input = {{4,3}, {4,2}, {3,2}, {1,2}, {2,5}};
        System.out.println(solution(5, input));
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] map = new int[n][n];

        for(int i=0; i< results.length; i++) {
            map[results[i][0] - 1][results[i][1] - 1] = 1;
            map[results[i][1] - 1][results[i][0] - 1] = -1;
        }

        // 플로이드 와샬 시작
        // k는 중간에 거치는 노드이다.
        for(int k=0; k<n; k++) {
            // i는 출발지 노드이다.
            for(int i=0; i<n; i++) {
                // j는 도착지 노드이다.
                for(int j=0; j<n; j++) {
                    if(map[i][k] == 1 && map[k][j] == 1) {
                        // A -> B, B -> C 이면 A -> C 인 경우를 나타낸다.
                        map[i][j] = 1;
                        map[j][i] = -1;
                    }
                    if(map[i][k] == -1 && map[k][j] == -1) {
                        // B -> A, C -> B 이면 C -> A 인 경우를 나타낸다.
                        map[i][j] = -1;
                        map[j][i] = 1;
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            int counter = 0;
            for(int k=0; k<n; k++) {
                if(map[i][k] != 0 ) {
                    counter++;
                }
            }
            if(counter == n-1)
                answer++;
        }

        return answer;
    }
}
