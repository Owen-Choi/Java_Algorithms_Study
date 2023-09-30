package programmers_real.level1;

import java.util.*;
public class 체육복 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = new int[]{2,4};
        int[] reserve = new int[]{1,3,5};
        System.out.println(new GymwearSolution().solution(n, lost, reserve));
    }
}

class GymwearSolution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 여벌 체육복이 있는 학생이 도난을 당했을 수도 있으며, 이 경우 해당 학생은 체육복을 빌려줄 수 없다.
        // 최대값이 크지 않으니 배열을 선언하고, 도난당한 학생을 순서대로 복원해주는 방법으로 가보자.
        int answer = 0;
        boolean[] arr = new boolean[n+1];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<reserve.length; i++) {
            arr[reserve[i]] = true;
        }
        for(int i=0; i<lost.length; i++) {
            if(!arr[lost[i]])
                list.add(lost[i]);
            else
                arr[lost[i]] = false;
        }
        Collections.sort(list);
        answer = n;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) - 1 >= 0 && arr[list.get(i) - 1]) {
                arr[list.get(i) - 1] = false;
            } else if(list.get(i) + 1 <= n && arr[list.get(i) + 1]) {
                arr[list.get(i) + 1] = false;
            } else answer--;
        }
        return answer;
    }
}
