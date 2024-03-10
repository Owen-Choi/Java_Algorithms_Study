package baekJoon.normal;

import java.io.*;
import java.util.*;
import java.util.Deque;
public class 뱀 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        int l;
        StringTokenizer st;
        // 시작지점. 뱀은 2로 표기한다.
        arr[1][1] = 2;
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
        }
        l = Integer.parseInt(br.readLine());
        Queue<Command> queue = new LinkedList<>();
        for(int i=0; i<l; i++) {
            st = new StringTokenizer(br.readLine());
            queue.offer(new Command(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }
        // 로직 시작
        // 뱀은 처음에 오른쪽을 향한다.
        int second = 0;
        char currentDirection = 'R';
        Deque<Node> deque = new ArrayDeque<>();
        // 머리와 꼬리를 먼저 덱에 추가해준다.
        deque.addFirst(new Node(1,1));
        int currentx, currenty;
        while(true) {
            Node head = deque.peekFirst();
            currentx = head.x;
            currenty = head.y;

            // 방향을 먼저 체크한다.
            if(!queue.isEmpty() && queue.peek().value == second) {
                // 시간 순이기 때문에, 이렇게 배짱장사를 해도 된다.
                Command poll = queue.poll();
                if(poll.direction == 'D') {
                    // 현재 방향 기준 오른쪽으로 회전
                    currentDirection = currentDirection == 'R' ? 'D'
                        : currentDirection == 'D' ? 'L'
                        : currentDirection == 'L' ? 'U' : 'R';
                } else {
                    // 현재 방향 기준으로 왼쪽으로 회전
                    currentDirection = currentDirection == 'R' ? 'U'
                        : currentDirection == 'D' ? 'R'
                        : currentDirection == 'L' ? 'D' : 'L';
                }
            }

            if(currentDirection == 'R') {
                // 현재 지렁이의 이동 방향이 오른쪽을 향할 경우
                currenty++;
            } else if(currentDirection == 'L') {
                // 현재 지렁이의 이동 방향이 왼쪽을 향할 경우
                currenty--;
            } else if(currentDirection == 'U') {
                // 현재 지렁이의 이동 방향이 위쪽을 향할 경우
                currentx--;
            } else {
                // 현재 지렁이의 이동 방향이 아랫쪽을 향할 경우
                currentx++;
            }
            // headx와 heady는 인덱스를 벗어날 가능성이 있다. 여기서 한번 검증해주어야 한다.
            // 문제 조건상 1초를 미리 더해주어야 함.
            second++;
            if(currentx <= 0 || currentx > n || currenty <= 0 || currenty > n) {
                // 벽에 부딪힌 것이기 때문에 게임 종료.
                System.out.println(second);
                return;
            }
            // 뱀의 머리가 자신의 몸과 부딪혔다면 게임 오버
            if(arr[currentx][currenty] == 2) {
                System.out.println(second);
                return;
            } else if(arr[currentx][currenty] == 0) {
                // 꼬리 부분을 다시 0으로 바꾼다.
                arr[currentx][currenty] = 2;
                deque.addFirst(new Node(currentx, currenty));
                // 꼬리를 잘라내고 0으로 바꾼다.
                Node tail = deque.pollLast();
                arr[tail.x][tail.y] = 0;
            } else {
                // 헤드가 있는 부분에 사과가 있다면 꼬리는 건들지 않는다.
                arr[currentx][currenty] = 2;
                deque.addFirst(new Node(currentx, currenty));
            }

            boolean[][] print = new boolean[n+1][n+1];
            for(Node node : deque) {
                print[node.x][node.y] = true;
            }
        }
    }
    static class Command {
        int value;
        char direction;

        Command(int value, char direction) {
            this.value = value;
            this.direction = direction;
        }
    }

    static class Node {
        int x;
        int y;
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
