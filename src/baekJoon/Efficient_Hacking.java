package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1325번, 효율적인 해킹, 그래프 탐색
public class Efficient_Hacking {

    static int N, M;
    // TODO 아래와 같이 리스트의 배열로 두면 메모리가 초과난다.
    // TODO 리스트의 배열보다 리스트의 리스트가 메모리를 더 적게 먹는지 공부해보기.
//    static List<Integer>[] list;
    static ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
    static List<Integer> result;
    static boolean[] flag;
    static HashMap<Integer, Integer> hash = new HashMap<>();
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//        list = new ArrayList[N];
        flag = new boolean[N];
        for(int i=0; i<N; i++) {
//            list[i] = new ArrayList<>();
            list2.add(new ArrayList<>());
        }

        int[] result = new int[N];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int firstInedx = Integer.parseInt(st.nextToken());
            int secondIndex = Integer.parseInt(st.nextToken());
            // 문제 입력과는 반대로 입력을 받겠다. 자신을 신뢰하는 컴퓨터의 리스트를 가지는 형식이다.
            list2.get(secondIndex - 1).add(firstInedx - 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            queue.add(i);
            flag[i] = true;
            int linkCount = 0;
            while(!queue.isEmpty()) {
                Integer poll = queue.poll();
                for (int index : list2.get(poll)) {
                    if(!flag[index]) {
                        flag[index] = true;
                        queue.add(index);
                        linkCount++;
                    }
                }
            }
            result[i] = linkCount;
            MAX = Math.max(MAX, linkCount);
            queue.clear();
            clearFlag();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<result.length; i++) {
            if(result[i] == MAX) {
                sb.append(i+1 + " ");
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
