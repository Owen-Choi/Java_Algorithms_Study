package programmers_real.pccp;
import java.util.*;

public class 운영체제 {
    public static void main(String[] args) {
        int[][] program = {{2,0,10}, {1,5,5}, {3,5,3}, {3,12,2}};
        long[] solution = new OsSolution().solution(program);
        for (long l : solution) {
            System.out.print(l + " ");
        }
    }
}


class OsSolution {
    // (우선순위, 호출 시각, 실행 시각)
    public long[] solution(int[][] program) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Map<Integer, Long> map = new HashMap<>();
        // 호출시간 기준으로 정렬
        Arrays.sort(program, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        int counter = 0;
        int indexCounter = 0;
        int iterator = 0;
        long end = 0;
        int runningTime = 0;
        while(counter < program.length) {
            while(iterator < program.length && end >= program[iterator][1]) {
                queue.offer(new Node(program[iterator][0], program[iterator][1],
                        program[iterator][2], indexCounter++));
                iterator++;
            }
            if(queue.isEmpty()) {
                // 큐가 비었다는건 대기 중인 작업이 없다는 것.
                end = program[iterator][1];
            } else {
                Node poll = queue.poll();
                long waitingTime = end - poll.c;
                end += poll.r;
                map.put(poll.p, map.getOrDefault(poll.p, 0l) + waitingTime);
                counter++;
            }
        }

        long[] answer = new long[11];
        answer[0] = end;
        for(int i=1; i<=10; i++) {
            answer[i] = map.getOrDefault(i, 0l);
        }
        return answer;
    }
}

class Node implements Comparable<Node>{
    int p;
    int c;
    int r;
    int i;
    public Node(int p, int c, int r, int i) {
        this.p = p;
        this.c = c;
        this.r = r;
        this.i = i;
    }

    @Override
    public int compareTo(Node o) {
        if(this.p == o.p) return this.i - o.i;
        return this.p - o.p;
    }
}