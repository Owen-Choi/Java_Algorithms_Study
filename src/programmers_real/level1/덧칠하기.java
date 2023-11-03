package programmers_real.level1;

public class 덧칠하기 {
    public static void main(String[] args) {
        int n = 8, m = 4;
        int[] section = {2,3,6};
        System.out.println(new PaintingSolution().solution(n,m,section));
    }
}

class PaintingSolution {
    public int solution(int n, int m, int[] section) {
        // n : 벽의 길이
        // m : 롤러의 길이
        // 벽은 1차원 직선의 형태
        boolean[] flag = new boolean[n];
        int cnt = 0;
        for(int i=0; i<section.length; i++) {
            if(!flag[section[i] - 1]) {
                if(section[i] + m <= n) {
                    int start = section[i];
                    for(int k=-1; k<=m - 2; k++) {
                        flag[start + k] = true;
                    }
                }
                cnt++;
            }
        }
        if(!flag[section[section.length - 1] - 1]) {
            cnt++;
        }
        return cnt;
    }
}
