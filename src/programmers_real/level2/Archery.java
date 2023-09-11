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

// 진짜 왜 나한테만 뭐라 그래

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
                if(li[i] == g[i] && g[i] == 0)
                    continue;
                if(li[i] > g[i])
                    lion += (10 - i);
                else
                    apeach += (10 - i);
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
