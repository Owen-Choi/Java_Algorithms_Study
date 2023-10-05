package programmers_real.level3;

import java.util.*;
public class DiskController {
    public static void main(String[] args) {
        int[][] jobs = {{0,3}, {1,9}, {2,6}};
        System.out.println(new DiskControllerSolution().solution(jobs));
    }
}

class DiskControllerSolution {
    public int solution(int[][] jobs) {
        // 들어온 시간 순으로 정렬
        // 이후에 끝나는 시간이 빠른 순으로 힙을 구성하고, 반복문을 구성한다.
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int counter = 0, index = 0, end = 0;
        int result = 0;
        while(counter < jobs.length) {
            while(index < jobs.length && end >= jobs[index][0]) {
                queue.offer(new Node(jobs[index][0], jobs[index][1]));
                index++;
            }
            if(queue.isEmpty()) {
                end = jobs[index][0];
            } else {
                Node poll = queue.poll();
                // 대기 시간의 합을 가중한다.
                result += (end - poll.time) + poll.run;
                end += poll.run;
                counter++;
            }
        }
        return (int)Math.floor(result / jobs.length);
    }
}
class Node implements Comparable<Node>{
    int time;
    int run;

    public Node(int t, int r) {
        this.time = t;
        this.run = r;
    }

    @Override
    public int compareTo(Node o) {
        return this.run - o.run;
    }
}
