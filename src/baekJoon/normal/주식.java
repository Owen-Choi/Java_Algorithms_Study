package baekJoon.normal;

import java.io.*;
import java.util.*;
public class 주식 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t --> 0) {
            int d = Integer.parseInt(br.readLine());
            int[] arr = new int[d];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<d; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            solve(arr);
        }
        System.out.println(sb.toString());
    }
//    정방향으로 풀이했는데, 오답이 떴다. 역방향으로 해야되나보다.
//    static void solve(int[] arr) {
//        // prev 보다 current의 값이 큰 동안 계속해서 매입?
//        // 그러다 prev가 더 큰 경우가 나오면 전부 매각?
//        // 해당 과정 반복? 나쁘지않다.
//        int prev = arr[0];
//        long result = 0;
//        Queue<Integer> queue = new LinkedList<>();
//        for(int i=1; i<arr.length; i++) {
//            int current = arr[i];
//            while(prev <= current) {
//                queue.offer(prev);
//                prev = current;
//                if(++i < arr.length) {
//                    current = arr[i];
//                }
//                else {
//                    break;
//                }
//            }
//            // 반복문을 나왔다는건 prev가 current보다 크다는 말. 이럴때는 매각한다.
//            while(!queue.isEmpty()) {
//                result += prev - queue.poll();
//            }
//            // IOB 조심
//            prev = current;
//        }
//        sb.append(result).append("\n");
//    }

    static void solve(int[] arr) {
        int prev = arr[arr.length - 1];
        int current;
        long result = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=arr.length - 2; i>=0; i--) {
            current = arr[i];
            while(prev >= current && i > 0) {
                queue.offer(current);
                current = arr[--i];
                if(i == 0) {
                    queue.offer(current);
                }
            }
            // 반복문 종료 시 주식을 매각해야 함.
            while(!queue.isEmpty()) {
                result += prev - queue.poll();
            }
            prev = current;
        }

        sb.append(result).append("\n");
    }
}
