package programmers_real.pccp;

import java.util.*;
public class 체육대회 {
    public static void main(String[] args) {
        int[][] ability = {{20,30}, {30,20}, {20,30}};
        System.out.println(new PhysicContestSolution().solution(ability));
    }
}

class PhysicContestSolution {
    boolean[] flag;
    int answer = 0;
    public int solution(int[][] ability) {
        flag = new boolean[ability.length];
        dfs(0, 0, ability);
        return answer;
    }
    void dfs(int depth, int value, int[][] ability) {

        if(depth == ability[0].length) {
            answer = Math.max(value, answer);
            return;
        }

        for(int i=0; i<ability.length; i++) {
            if(!flag[i]) {
                flag[i] = true;
                dfs(depth + 1, value + ability[i][depth], ability);
                flag[i] = false;
            }
        }
    }
}
