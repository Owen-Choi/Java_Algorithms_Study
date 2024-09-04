package programmers.level2;

import java.util.*;
import java.io.*;

public class 두_큐_합_길게_만들기 {
    public static void main(String[] args) throws IOException {
        int[] queue1 = {3,2,7,2};
        int[] queue2 = {4,6,5,1};
        System.out.println(solution(queue1, queue2));
    }

    static int solution(int[] queue1, int[] queue2) {
        int size = queue1.length;
        int target, q1s = 0, q2s = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=0; i<size; i++) {
            q1s += queue1[i];
            q2s += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        target = q1s+ q2s;
        if(target % 2 != 0) {
            return -1;
        }
        target /= 2;
        int count = 0;
        while(true) {
            if(count > queue1.length + 5) {
                return -1;
            }

            if (q1s > target) {
                q1s -= q1.peek();
                q2.offer(q1.poll());
            } else {
                q1s += q2.peek();
                q1.offer(q2.poll());
            }
            count++;
            if(q1s == target) break;
        }
        return count;
    }

}
