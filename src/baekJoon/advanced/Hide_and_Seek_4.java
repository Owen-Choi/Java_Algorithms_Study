package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hide_and_Seek_4 {

    static int N, K;
    static int[] history = new int[100001];
//    static int[] value = new int[100001];
    static boolean[] flag = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        flag[N] = true;

        while(!queue.isEmpty()) {
            if(flag[K]) {
                break;
            }
            for(int i=0, q = queue.size(); i<q; i++) {
                int poll = queue.poll();
                if(poll * 2 >= 0 && poll * 2 <= 100000) {
                    if(!flag[poll * 2]) {
                        history[poll * 2] = poll;
                        queue.add(poll * 2);
                        flag[poll * 2] = true;
                    }
                }

                if(poll + 1 >= 0 && poll + 1 <= 100000) {
                    if(!flag[poll + 1]) {
                        history[poll + 1] = poll;
                        queue.add(poll + 1);
                        flag[poll + 1] = true;
                    }
                }

                if(poll - 1 >= 0 && poll - 1 <= 100000) {
                    if(!flag[poll - 1]) {
                        history[poll - 1] = poll;
                        queue.add(poll - 1);
                        flag[poll - 1] = true;
                    }
                }
            }
            count++;
        }

        System.out.println(count);
        StringBuilder sb = new StringBuilder();
        List<Integer> resultList = new ArrayList<>();
        for(int i=K; i!=N; i=history[i]) {
            resultList.add(i);
        }
        resultList.add(N);
        for(int i=resultList.size() - 1; i >= 0; i--) {
            sb.append(resultList.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}



//package baekJoon.advanced;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Hide_and_Seek_4 {
//
//    static int N, K;
//    static int[] history = new int[100001];
//    static int[] value = new int[100001];
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        N = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(N);
//          // value[N]이 0이면 여기에 값이 다시 들어가서 결과가 틀어질 수도 있다. 따라서 1로 초기화해주고, 결과에서 1을 빼는 것이 안전.
//        value[N] = 1;
//        while(!queue.isEmpty()) {
//            int poll = queue.poll();
//            if(poll == K) {
//                // BFS로 이런 종류의 탐색을 진행하면 이 조건문에 걸리는 경우가 가장 먼저 도착한 경우라고 생각하면 된다.
//                // 따라서 그냥 바로 종료해버려도 된다. history 배열도 같은 맥락이다. 처음 K와 같아지는 이동 조합만 고려하면 되기 때문에
//                // history 배열을 막 덮어써도 된다.
//                break;
//            } else {
//                    if(poll * 2 >= 0 && poll * 2 <= 100000) {
//                        if(value[poll * 2] == 0) {
//                            queue.add(poll * 2);
//                            value[poll * 2] = value[poll] + 1;
//                            history[poll * 2] = poll;
//                        }
//                    }
//                    if(poll + 1 >= 0 && poll + 1 <= 100000) {
//                        if(value[poll + 1] == 0) {
//                            queue.add(poll + 1);
//                            value[poll + 1] = value[poll] + 1;
//                            history[poll + 1] = poll;
//                        }
//                    }
//                    if(poll - 1 >= 0 && poll - 1 <= 100000) {
//                        if(value[poll - 1] == 0) {
//                            queue.add(poll - 1);
//                            value[poll - 1] = value[poll] + 1;
//                            history[poll - 1] = poll;
//                        }
//                    }
//            }
//        }
//
//        System.out.println(value[K] - 1);
//        StringBuilder sb = new StringBuilder();
//        List<Integer> resultList = new ArrayList<>();
//        for(int i=K; i!=N; i=history[i]) {
//            resultList.add(i);
//        }
//        resultList.add(N);
//        for(int i=resultList.size() - 1; i >= 0; i--) {
//            sb.append(resultList.get(i)).append(" ");
//        }
//        System.out.println(sb.toString());
//
//    }
//}
