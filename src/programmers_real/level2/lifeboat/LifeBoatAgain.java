package programmers_real.level2.lifeboat;

import java.util.Arrays;

public class LifeBoatAgain {

    public static void main(String[] args) {
//        int[] people = {70, 50, 80, 50};
        int[] people = {60, 60, 60, 50, 40};
        int solution = new LifeBoatAgainSolution().solution(people, 110);
        System.out.println(solution);
    }
}

class LifeBoatAgainSolution {

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int sum = 0;
        while(left <= right) {
            if(left == right)
                sum = people[right];
            else
                sum = people[right] + people[left];

            if(sum > limit) {
                right--;
            } else {
                // sum <= limit
                left++;
                right--;
            }
            answer++;
        }
        return answer;
    }
}
