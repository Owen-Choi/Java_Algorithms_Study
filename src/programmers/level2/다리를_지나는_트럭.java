package programmers.level2;

import java.util.*;

public class 다리를_지나는_트럭 {
    public static void main(String[] args) {
//        int b = 2, w = 10;
//        int[] t = {7,4,5,6};
        int b = 100, w = 100;
        int[] t = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(solution(b,w,t));
    }

    public static int solution(int b, int w, int[] t) {
        // 최대한 짧게 잘 설계를 해보자.
        // 트럭이 다리 위에서 얼마나 이동했는지를 알려줌.
        Queue<Truck> bridge = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<t.length; i++) {
            queue.offer(t[i]);
        }
        int qs = 0, bs, time = 0, temp = 0;
        do {
            if(!queue.isEmpty() && qs + queue.peek() <= w) {
                // 브릿지에 넣어준다.
                temp = queue.poll();
                qs += temp;
                bridge.offer(new Truck(temp, b));
            }
            bs = bridge.size();
            for(int i=0; i<bs; i++) {
                // 지금 다리 위에 있는 트럭들을 업데이트해줌.
                Truck truck = bridge.poll();
                if(truck.time > 1) {
                    bridge.offer(new Truck(truck.weight, truck.time - 1));
                } else {
                    qs -= truck.weight;
                }
            }

            time++;
        } while(!queue.isEmpty() || !bridge.isEmpty());
        return time + 1;
    }

    static class Truck {
        int weight;
        int time;
        Truck(int weight, int time) {
             this.weight = weight;
             this.time = time;
        }
    }

}
