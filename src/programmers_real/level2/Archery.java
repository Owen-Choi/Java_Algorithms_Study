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
    int max = -1;
    public int[] solution(int n, int[] info) {
//        g = info;
        dfs(new int[info.length], n, info);
        if(max == -1) {
            return new int[]{-1};
        }
        return last;
    }

    void dfs(int[] arr, int remain, int[] info) {
        if(remain == 0) {
            // 점수 계산
            int apeach = 0, lion = 0;
            for(int i=0; i<info.length; i++) {
                if(arr[i] == info[i] && info[i] == 0)
                    continue;
                if(arr[i] > info[i])
                    lion += (10 - i);
                else if(arr[i] <= info[i])
                    apeach += (10 - i);
            }
            if(lion > apeach) {
                if(lion - apeach >= max) {
                    last = arr.clone();
                    max = lion - apeach;
                }
            }
            return;
        }
        for(int i=0; i< info.length && info[i] >= arr[i]; i++) {
            arr[i]++;
            dfs(arr, remain - 1, info);
            arr[i]--;
        }
    }
}
