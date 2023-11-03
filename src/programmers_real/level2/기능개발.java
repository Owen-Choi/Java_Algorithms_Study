package programmers_real.level2;

import java.util.*;
public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1,1,1,1,1,1};
        int[] solution = new ImplSolution().solution(progresses, speeds);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}

class ImplSolution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int start = 0;
        while(true) {
            for(int i=start; i<progresses.length; i++) {
                if(progresses[i] < 100) {
                    progresses[i] += speeds[i];
                }
            }
            if(progresses[start] >= 100) {
                int iter = start;
                while(iter < progresses.length && progresses[iter] >= 100) {
                    iter++;
                }
                list.add(iter - start);
                if(iter == progresses.length)
                    break;
                start = iter;
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
