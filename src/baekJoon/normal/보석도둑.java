package baekJoon.normal;

import java.io.*;
import java.util.*;
public class 보석도둑 {
    public static void main(String[] args) throws IOException{
        int n, k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Jewel[] arr = new Jewel[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] bags = new int[k];
        for(int i=0; i<k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        Arrays.sort(bags);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long result = 0;
        for(int i=0, j = 0; i<k; i++) {
            while(j < n && bags[i] >= arr[j].weight) {
                pq.offer(arr[j++].value);
            }
            // 하 나는 아직 하수다,,,
            // 가장 위에 있는, 즉 현재 가방에서 얻을 수 있는 가장 비싼 보석을 빼서 더해줌
            if(!pq.isEmpty()) {
                result += pq.poll();
            }
        }
        System.out.println(result);
    }

//    2 1
//    5 10
//    100 100
//    11
    // 가치 순, 가치가 같다면 가벼운 순?
    // 가방은 무거운 순?
    static class Jewel implements Comparable<Jewel>{
        int weight;
        int value;

        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            if(o.weight == this.weight) {
                // 무게가 같을 경우 가격을 내림차순으로
                return o.value - this.value;
            }
            // 무게를 기준으로 오름차순
            return this.weight - o.weight;
        }
    }
}
