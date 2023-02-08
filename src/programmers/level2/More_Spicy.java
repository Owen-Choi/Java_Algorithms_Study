package programmers.level2;

import java.util.PriorityQueue;

public class More_Spicy {
    public static void main(String[] args) {
        int[] scoville = new int[6];
        scoville[0] = 1;
        scoville[1] = 2;
        scoville[2] = 3;
        scoville[3] = 9;
        scoville[4] = 10;
        scoville[5] = 12;

        System.out.println(solution(scoville, 7));
    }

    // 자바에서 힙은 priority queue를 활용하면 쉽게 구현할 수 있다.
    static int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i< scoville.length; i++){
            minHeap.add(scoville[i]);
        }

        if(minHeap.peek() >= k)
            return 0;

        boolean flag = false;
        while(minHeap.size() >= 2) {
            answer++;
            int first = minHeap.poll();
            int second = minHeap.poll();
            minHeap.add(first + second * 2);
            if(!minHeap.isEmpty() && minHeap.peek() >= k) {
                flag = true;
                break;
            }
        }
        return flag ? answer : -1;
    }
}
