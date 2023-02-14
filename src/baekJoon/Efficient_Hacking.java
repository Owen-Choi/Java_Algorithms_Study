package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1325번, 효율적인 해킹, 그래프 탐색
//public class Efficient_Hacking {
//
//    // BFS로 풀이 후 시간초과로 인해 DFS로 전향
//    static int N, M;
//    static List<Integer>[] list;
//    static boolean[] flag;
//    static List<Integer> result = new ArrayList<>();
//    static int MAX = Integer.MIN_VALUE;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        list = new ArrayList[N];
//        flag = new boolean[N];
//        for (int i = 0; i < N; i++) {
//            list[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int firstIndex = Integer.parseInt(st.nextToken());
//            int secondIndex = Integer.parseInt(st.nextToken());
//            list[firstIndex - 1].add(secondIndex - 1);
//        }
//
//        for (int i = 0; i < N; i++) {
//            dfs(i, 0);
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i<result.size() - 1; i++) {
//            sb.append(result.get(i)).append(" ");
//        }
//        sb.append(result.get(result.size() - 1));
//        System.out.println(sb.toString());
//
//    }
//
//    static void dfs(int index, int count) {
//        if(list[index].size() == 0) {
//            if(!flag[index])
//                return;
//            if(MAX < count) {
//                MAX = count;
//                result.clear();
//                result.add(index + 1);
//            } else if(MAX == count) {
//                result.add(index + 1);
//            }
//            return;
//        }
//
//        count++;
//        for(int i=0; i<list[index].size(); i++) {
//            if(!flag[list[index].get(i)]) {
//                flag[list[index].get(i)] = true;
//                dfs(i, count);
//                flag[list[index].get(i)] = false;
//            }
//        }
//    }
//}

// 1325번, 효율적인 해킹, 그래프 탐색
public class Efficient_Hacking {

    static int N, M;
    static List<Integer>[] list;
    static List<Integer> result;
    static boolean[] flag;
    static HashMap<Integer, Integer> hash = new HashMap<>();
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        flag = new boolean[N];
        result = new ArrayList<>();
        for(int i=0; i<N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int firstInedx = Integer.parseInt(st.nextToken());
            int secondIndex = Integer.parseInt(st.nextToken());
            // 문제 입력과는 반대로 입력을 받겠다. 자신을 신뢰하는 컴퓨터의 리스트를 가지는 형식이다.
            list[secondIndex - 1].add(firstInedx - 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            queue.add(i);
            flag[i] = true;
            int linkCount = 0;
            while(!queue.isEmpty()) {
                Integer poll = queue.poll();
//                for(int k=0; k<list[poll].size(); k++) {
//                    if(!flag[list[poll].get(k)]) {
//                        queue.add(list[poll].get(k));
//                        flag[list[poll].get(k)] = true;
//                        linkCount++;
//                    }
//                }
                for (Integer integer : list[poll]) {
                    if(!flag[integer]) {
                        queue.add(integer);
                        flag[integer] = false;
                        linkCount++;
                    }
                }
            }
            if(linkCount >= MAX) {
                hash.put(i + 1, linkCount);
                MAX = linkCount;
            }

            queue.clear();
            clearFlag();
        }


        StringBuilder sb = new StringBuilder();
        for (Integer integer : hash.keySet()) {
            if(hash.get(integer) == MAX) {
                sb.append(integer).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    static void clearFlag() {
        for(int i=0; i< flag.length; i++) {
            flag[i] = false;
        }
    }
}
