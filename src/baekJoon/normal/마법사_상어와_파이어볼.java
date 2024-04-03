package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 마법사_상어와_파이어볼 {
    // 8방 탐색
    // 순서대로 상 하 좌 우 좌상 좌하 우상 우하
    // static int[][] move = {{-1,1,0,0,-1,1,-1,1}, {0,0,-1,1,-1,-1,1,1}};
    // 로 하고싶었으나, 문제에서 방향을 제시했기 때문에 해당 방향에 맞게
    // 순서대로 상 우상 우 우하 하 좌하 좌 좌상 으로 가겠다.
    static int[][] move = {{-1, -1, 0, 1, 1, 1, 0, -1}, {0, 1, 1, 1, 0, -1, -1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Queue<Fireball>>> list = new ArrayList<>();
        // 메모리가 될까,,,
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                list.get(i).add(new LinkedList<>());
            }
        }
        // 큐에 담고, 큐의 크기 만큼 반복하는 반복문을 둔 뒤, 해당 반복문이 끝나면 초를 하나씩 마이너스 하는 구조는 어떤가
        Queue<Fireball> queue = new LinkedList<>();
        int x, y, weight, velocity, direction;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            weight = Integer.parseInt(st.nextToken());
            velocity = Integer.parseInt(st.nextToken());
            direction = Integer.parseInt(st.nextToken());
            queue.offer(new Fireball(x, y, weight, velocity, direction));
        }

        // 처음에는 3차원 리스트에 추가되어 있지 않다는 것을 고려해야 함.
        int size, nextX, nextY;
        while (k --> 0) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                Fireball poll = queue.poll();
                nextX = poll.x;
                nextY = poll.y;
                // 파이어볼의 위치와 방향, 속력을 고려해서 다음 위치를 알아내야 함.
                for (int j = 0; j < poll.v; j++) {
                    nextX += move[0][poll.d];
                    nextY += move[1][poll.d];
                    nextX = nextX < 0 ? n - 1 : nextX >= n ? 0 : nextX;
                    nextY = nextY < 0 ? n - 1 : nextY >= n ? 0 : nextY;
                }
                // 이동을 마친 파이어볼은 위치에 넣어준다.
                poll.x = nextX;
                poll.y = nextY;
                list.get(nextX).get(nextY).offer(poll);
            }
            // 큐에 들어있던 파이어볼을 모두 옮겼다면 이제 검사를 해야한다.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 비어있지 않다면, 큐의 크기가 1인지 2이상인지 확인해야 한다.
                    if (!list.get(i).get(j).isEmpty()) {
                        Queue<Fireball> fireballs = list.get(i).get(j);
                        if(fireballs.size() == 1) {
                            queue.offer(fireballs.poll());
                        } else {
                            // 큐의 크기가 2 이상인 경우
                            int weightSum = 0, velocitySum = 0, evenCount = 0, ballCount = fireballs.size();
                            while (!fireballs.isEmpty()) {
                                Fireball poll = fireballs.poll();
                                weightSum += poll.w;
                                velocitySum += poll.v;
                                if (poll.d % 2 == 0) {
                                    evenCount++;
                                }
                            }
                            // 이제 속력의 합과 질량의 합, 방향을 고려해서 4개의 파이어볼을 큐에 새롭게 넣어준다.
                            int newWeight = weightSum / 5, newVelocity = velocitySum / ballCount;
                            if (evenCount == ballCount || evenCount == 0) {
                                // 모두 짝수이거나 홀수인 경우 방향은 십자가 (0,2,4,6)가 된다.
                                if (newWeight != 0) {
                                    // 질량이 0이면 없어지기 때문에 큐에 넣어주지 않는다.
                                    queue.offer(new Fireball(i, j, newWeight, newVelocity, 0));
                                    queue.offer(new Fireball(i, j, newWeight, newVelocity, 2));
                                    queue.offer(new Fireball(i, j, newWeight, newVelocity, 4));
                                    queue.offer(new Fireball(i, j, newWeight, newVelocity, 6));
                                }
                            } else {
                                if (newWeight != 0) {
                                    // 질량이 0이면 없어지기 때문에 큐에 넣어주지 않는다.
                                    queue.offer(new Fireball(i, j, newWeight, newVelocity, 1));
                                    queue.offer(new Fireball(i, j, newWeight, newVelocity, 3));
                                    queue.offer(new Fireball(i, j, newWeight, newVelocity, 5));
                                    queue.offer(new Fireball(i, j, newWeight, newVelocity, 7));
                                }
                            }
                        }
                    }
                }
            }
        }

        // 질량의 합을 구하면 된다.
        int result = 0;
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                if(list.get(i).get(j).size() != 0) {
//                    Queue<Fireball> fireballs = list.get(i).get(j);
//                    for (Fireball fireball : fireballs) {
//                        result += fireball.w;
//                    }
//                }
//            }
//        }
        for (Fireball fireball : queue) {
            result += fireball.w;
        }
        System.out.println(result);
    }

    static class Fireball {
        int x;
        int y;
        int w;
        int d;
        int v;

        public Fireball(int x, int y, int weight, int velocity, int direction) {
            this.x = x;
            this.y = y;
            this.w = weight;
            this.d = direction;
            this.v = velocity;
        }
    }
}
