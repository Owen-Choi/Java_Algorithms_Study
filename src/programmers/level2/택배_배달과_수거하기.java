package programmers.level2;

import java.util.*;
import java.io.*;

public class 택배_배달과_수거하기 {
    public static void main(String[] args) throws IOException {
//        int cap = 4;
        int cap = 2;
//        int n = 5;
        int n = 7;
//        int[] deliveries = {1,0,3,1,2};
        int[] deliveries = {1,0,2,0,1,0,2};
//        int[] pickups = {0,3,0,4,0};
        int[] pickups = {0,2,0,1,0,2,0};
//        System.out.println(new Solution().solution(cap, n, deliveries, pickups));
        System.out.println(new Solution().solution(cap, n, deliveries, pickups));
    }

    // 다시 풀어보자.
    // 미친... 정답을 안봤으면 평생이 걸렸어도 못풀었을 것이다.
    static class Solution {
        static long answer = 0;
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            // 진짜 개열받네
            int d = 0, p = 0;
            for(int i=n-1; i>=0; i--) {
                d -= deliveries[i];
                p -= pickups[i];
                while(d < 0 || p < 0) {
                    d += cap;
                    p += cap;
                    answer += (i + 1) * 2;
                }
            }
            return answer;
        }
    }
//    static class Solution {
//        static long answer = 0;
//        static int total;
//        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
//            // cap : 트럭에 실을 수 있는 상자의 수
//            // 트럭은 배달할 상자를 실어서 집에 배달한 후, 빈 상자들은 수거해서 물류창고에 내린다.
//            // 규칙 ::
//            // 거리가 먼 집을 먼저 간다. 가면서 배달 할 수 있는 양은 꽉꽉 채워서 간다.
//            // 돌아오는 길에는 반드시 뭐라도 수거해온다.
//
//            total = 0;
//            for(int i=0; i<deliveries.length; i++) {
//                total += deliveries[i];
//            }
//            for(int i=0; i<pickups.length; i++) {
//                total += pickups[i];
//            }
//            // 배달, 수거할 박스가 모두 없어질 때 까지 계속해서 탐색
//            while(total > 0) {
//                process(deliveries, pickups, cap);
//            }
//            return answer;
//        }
//
//        public void process(int[] deliveries, int[] pickups, int cap) {
//            int deliver = 0, pickup = 0, index = 0;
//            // index 만큼 이동한다.
//            for(int i=0; i<deliveries.length; i++) {
//                if(deliveries[i] != 0)
//                    index = i + 1;
//            }
//            answer += index * 2;
//
//            // 박스를 몇 개 싣고 가는지는 중요하지 않음.
//            // 중요한건 멀리 떨어져 있는 집들을 다시 방문하지 않아도 되는 상태로 만드는 것임.
//            // 박스는 멀리 있는 집에 먼저 배달을 해주고, 회수할 박스는 반드시 꽉꽉 채워서 가져온다.
//            for(int i=deliveries.length -1; i>=0; i--) {
//                if(deliver + deliveries[i] <= cap) {
//                    deliver += deliveries[i];
//                    total -= deliveries[i];
//                    deliveries[i] = 0;
//                } else {
//                    // 배달할 수 있는 최대의 양을 배달하고, 그 만큼 박스를 제한다.
//                    deliveries[i] -= (cap - deliver);
//                    total -= (cap - deliver);
//                    deliver = cap;
//                }
//
//                // 중요한건 회수할 박스이다.
//                if(pickup + pickups[i] <= cap) {
//                    pickup += pickups[i];
//                    total -= pickups[i];
//                    pickups[i] = 0;
//                } else {
//                    pickups[i] -= (cap - pickup);
//                    total -= (cap - pickup);
//                    pickup = cap;
//                }
//
//                // 더 이상 박스를 회수할 수 없으면 여기서 종료한다.
//                if(pickup == cap)
//                    break;
//            }
//        }
//    }
}
