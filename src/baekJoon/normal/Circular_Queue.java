package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
// 1021번
public class Circular_Queue {
    static int N, M, Result = 0;
    static int[] target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        target = new int[M];
        LinkedList<Integer> deque = new LinkedList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            deque.offer(i+1);
        for(int i=0; i<M; i++)
            target[i] = Integer.parseInt(st.nextToken());

        int Iterator = 0, temp, size;
        while(Iterator < M) {
            if(deque.peek() == target[Iterator]) {
                deque.poll();
                Iterator++;
                continue;
            }
            temp = deque.indexOf(target[Iterator]);
            if(deque.size() % 2 != 0)
                size = deque.size() / 2 + 1;
            else
                size = deque.size() / 2;

            if(temp < size) {        //이 경우 뒤로 둘아가는 것 보단 앞으로 가는 것이 더 빠름
                while(deque.peekFirst() != target[Iterator]) {
                    deque.addLast(deque.poll());
                    Result++;
                }
                deque.poll();
            }
            else {
                while(deque.peekLast() != target[Iterator]) {
                    deque.addFirst(deque.pollLast());
                    Result++;
                }
                deque.pollLast();
                Result++;
            }
            Iterator++;
        }
        System.out.println(Result);
    }
}
