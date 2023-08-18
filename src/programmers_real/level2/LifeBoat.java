package programmers_real.level2;

import java.util.Arrays;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/42885
public class LifeBoat {

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
//        int[] people = {40, 40, 40};
        System.out.println(new Solution_LifeBoat().solution(people, 100));
    }
}

class Solution_LifeBoat {

    public int solution(int[] p, int limit) {
        int answer = 0, left = 0, right = p.length - 1, sum;
        Integer[] a = Arrays.stream(p).boxed().toArray(Integer[]::new);
        Arrays.sort(a, Collections.reverseOrder());
        // 한번에 2명씩 밖에 못타면, 투포인터로 제일 가벼운 사람 한명, 제일 무거운 사람 한명으로 무게를 맞추는게 베스트다.
        while(left < right) {
            sum = a[left] + a[right];
            if(sum > limit) {
                left++;
            } else {
                left++;
                right--;
            }
            answer++;
        }
        if(left == right) {
            answer++;
        }
        return answer;
    }
}
