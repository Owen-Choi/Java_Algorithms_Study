package programmers_real.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Seesaw {
    public static void main(String[] args) {
        int[] arr = {100,180,360,100,270};
        System.out.println(new SeesawSolution().solution(arr));
    }
}

class SeesawSolution {
    public long solution(int[] weights) {
        long answer = 0;
        // 반복문을 2번 돌아버리면 시간초과가 발생함. 무조건 반복문 1번으로 끝내야함.
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        // 연산 방식은 dp와 동일한데, 자료형때문에 배열로눈 퓰 수 없는 듯 함
        for(int i=0; i<weights.length; i++) {
            double value1 = weights[i] * 1.0;
            double value2 = (weights[i] * 2.0) / (3.0);
            double value3 = (weights[i] * 3.0) / (4.0);
            double value4 = (weights[i] * 1.0) / (2.0);
            if(map.containsKey(value1)) {
                answer += map.get(value1);
            }
            if(map.containsKey(value2)) {
                answer += map.get(value2);
            }
            if(map.containsKey(value3)) {
                answer += map.get(value3);
            }
            if(map.containsKey(value4)) {
                answer += map.get(value4);
            }
            map.put(value1, map.getOrDefault(value1, 0) + 1);
        }
        return answer;
    }
}
