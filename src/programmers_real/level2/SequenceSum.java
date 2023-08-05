package programmers_real.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/178870
public class SequenceSum {

    public static void main(String[] args) {
        int[] sequence = {1,1,1,2,3,4,5};
        int sum = 5;

        int[] solution = new Solution().solution(sequence, sum);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] solution(int[] s, int target) {
        List<Info> list = new ArrayList<>();
        int left = 0, right = 0, sum = s[0];
        while(true) {
            if(sum == target) {
                Info info = new Info(left, right);
                list.add(info);
            }
            if(left == s.length && right == s.length) {
                break;
            }

            if(sum <= target && right < s.length) {
                right++;
                if(right < s.length) sum += s[right];
            } else {
                if(left < s.length) sum -= s[left];
                left++;
            }
        }
        list.sort(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.right - o1.left == o2.right - o2.left) {
                    return o1.left - o2.left;
                } else {
                    return (o1.right - o1.left) - (o2.right - o2.left);
                }
            }
        });

        int result[] = new int[2];
        result[0] = list.get(0).left;
        result[1] = list.get(0).right;
        return result;
    }

    class Info {
        int left;
        int right;

        public Info(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}


