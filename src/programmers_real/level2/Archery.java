package programmers_real.level2;

public class Archery {
    public static void main(String[] args) {
        int n = 5;
//        int n = 1;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
//        int[] info = {1,0,0,0,0,0,0,0,0,0,0};
        int[] solution = new ArcherySolution().solution(n, info);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}

class ArcherySolution {
    int[] g, last;
    int[] li = new int[11];
    int max = -1;
    public int[] solution(int n, int[] info) {
        g = info;
        dfs(n);
        if(max == -1) {
            return new int[]{-1};
        }
        return last;
    }

    void dfs(int remain) {
        if(remain == 0) {
            // 점수 계산
            int apeach = 0, lion = 0;
            for(int i=0; i<g.length; i++) {
                if(li[i] > g[i])
                    lion += (10 - i);
                else {
                    if(g[i] != 0)
                        apeach += (10 - i);
                }
            }
            if(lion > apeach) {
                if(lion - apeach >= max) {
                    last = li.clone();
                    max = lion - apeach;
                }
            }
            return;
        }

        for(int i=0; i < g.length && g[i] >= li[i]; i++) {
            li[i]++;
            dfs(remain - 1);
            li[i]--;
        }
    }
}


//package programmers_real.level2;
//
//public class Archery {
//    public static void main(String[] args) {
//        int n = 10;
////        int n = 1;
////        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
//        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
//        int[] solution = new ArcherySolution().solution(n, info);
//        for (int i : solution) {
//            System.out.print(i + " ");
//        }
//    }
//}

//class ArcherySolution {
//    int[] g, last;
//    int[] li = new int[11];
//    int max = -1;
//    public int[] solution(int n, int[] info) {
//        g = info;
//        dfs(n, 0);
//        if(max == -1) {
//            return new int[]{-1};
//        }
//        return last;
//    }
//
//    void dfs(int remain, int depth) {
//        if(remain == 0) {
//            // 점수 계산
//            int apeach = 0, lion = 0;
//            for(int i=0; i<g.length; i++) {
//                // 둘 다 무득점이면 패스
//                if(li[i] == g[i] && g[i] == 0)
//                    continue;
//                // 라이언이 아피치보다 점수가 높다면 라이언 득점
//                if(li[i] > g[i])
//                    lion += (10 - i);
//                else
//                // 그게 아니라면 아피치 득점
//                    apeach += (10 - i);
//            }
//            if(lion > apeach) {
//                if(lion - apeach >= max) {
//                    last = li.clone();
//                    max = lion - apeach;
//                }
//            }
//            return;
//        }
//
//        // 아래와 같이 풀이하면 예제 4번에 막혀서 정답을 맞출 수 없다.
//        // 라이언이 특정 표적을 아피치보다 적게 맞춰 점수를 얻지 못하더라도, 결과적으로 이기기만 하면 정답이 될 수 있기 때문이다.
//        if(remain > g[depth]) {
//            li[depth] += g[depth] + 1;
//            if(depth + 1 < g.length)
//                dfs(remain - (g[depth] + 1), depth + 1);
//            li[depth] -= g[depth] + 1;
//        }
//        if(depth + 1 < g.length && remain > 0)
//            dfs(remain, depth + 1);
//    }
//}
