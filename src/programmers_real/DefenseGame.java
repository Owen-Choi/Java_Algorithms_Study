package programmers_real;

import java.util.Collections;
import java.util.PriorityQueue;

public class DefenseGame {

    public static void main(String[] args) {
//        int n = 7, k = 3;
        int n = 2, k = 4;
        int[] enemy = {3,3,3,3};
//        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        int solution = new DefenseGameSolution().solution(n, k, enemy);
        System.out.println(solution);
    }
}

class DefenseGameSolution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i< enemy.length; i++) {
            n -= enemy[i];
            queue.add(enemy[i]);
            if(n < 0) {
                if(k > 0 && !queue.isEmpty()) {
                    n += queue.poll();
                    k--;
                } else {
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}
