package programmers.level2;

import java.util.*;
import java.io.*;

public class 혼자_놀기의_달인 {
    public static void main(String[] args) throws IOException{
        int[] cards = {8,6,3,7,2,5,1,4};
        System.out.println(new Solution().solution(cards));
    }

    static class Solution {
        static boolean[] flag;
        static PriorityQueue<Integer> pq;
        public int solution(int[] cards) {
            // 2 이상 100이하의 수를 정하고, 그 수보다 작거나 같은 카드를 준비한다.
            // 준비한 카드 수 만큼 작은 상자를 준비한다.
            // 상자를 섞은 다음 일렬로 나열하고, 앞에서부터 번호를 부여한다.
            // 임의로 상자 하나를 뽑아서 그 안에 나온 카드 번호의 상자를 또 깐다.
            // 열어야 하는 상자가 이미 열려있을 때까지 반복한다.
            // 열린 상자들은 1번 그룹으로 분류하고, 이들을 뺀다.
            // 모든 상자가 1번 그룹에 속하게 되면 게임이 종료된다.
            // 한번 만에 모든 상자를 열게 되면 0점이 된다.
            // 상자가 남았다면 남은 상자들을 대상으로 같은 게임을 반복하고, 2번 그룹으로 분류된다.
            // 2번 그룹에 모든 상자가 속하게 되면 점수는 1번 그룹 상자의 수 * 2번 그룹 상자의 수이다.

            flag = new boolean[cards.length];
            pq = new PriorityQueue<>(Collections.reverseOrder());
            int answer = 0;
            // 처음에 상자를 고르는 것은 랜덤으므로 여기에 대해서 dfs를 수행해준다.
            for(int i=0; i<cards.length; i++) {
//                dfs(1, cards[i] - 1, cards, new ArrayList<>(), 1);
                if(!flag[i])
                    dfs(i, cards, 0);
            }

            return pq.size() == 1 ? 0 : pq.poll() * pq.poll();
        }

        // 문제가 너무 이상하다. 마음에 들지 않는다.
        // 아래와 같이 코드를 짜도 되는 이유는 그냥 단순히 서로 겹치지 않는 2개의 그룹만 구하면 되기 때문이다.
        void dfs(int index, int[] cards, int current) {
            if(flag[index]) {
                pq.add(current);
                return;
            }

            flag[index] = true;
            dfs(cards[index] - 1, cards, current + 1);
        }
//        void dfs(int openCount, int openIndex, int[] cards, ArrayList<Integer> list, int current) {
//            if(openCount == cards.length) {
//                int tempAnswer = 1;
//                if(list.size() == 1) {
//                    tempAnswer = 0;
//                }
//
//                answer = Math.max(answer, tempAnswer);
//                return;
//            }
//
//            // 이미 열었던 상자라면
//            if(flag[openIndex]) {
//               for(int i=0; i<cards.length; i++) {
//                   if(!flag[i]) {
//                       flag[i] = true;
//                       list.add(current);
//                       // cards[i] - 1 : 새로 연 상자의 인덱스
//                       dfs(openCount + 1, cards[i] - 1, cards, list, 1);
//                       list.remove(list.size() - 1);
//                       flag[i] = false;
//                   }
//               }
//            } else {
//                flag[openIndex] = true;
//                dfs(openCount + 1, cards[openIndex] - 1, cards, list, current + 1);
//                flag[openIndex] = false;
//            }
//
//        }

//        void dfs(int openCount, int openIndex, int[] cards, int[] arr, int current) {
//            // 모든 상자를 열었다면 게임 종료
//            if(openCount == cards.length) {
//                int tempAnswer = 1;
//                for(int i=0; i<arr.length; i++) {
//                    tempAnswer *= arr[i];
//                }
//
////                for(int i=0; i<arr.length; i++) {
////                    System.out.print(arr[i] + " ");
////                }
////                System.out.println();
//                answer = Math.max(answer, tempAnswer);
//            }
//
//            if(flag[openIndex]) {
//                // 이미 열었던 상자라면
//                // 지금까지의 그룹을 저장하고 새로운 그룹을 만들기 위해 랜덤으로 상자를 연다.
//                for(int i=0; i<cards.length; i++) {
//                    if(!flag[i]) {
//                        flag[i] = true;
//                        int[] new_arr = Arrays.copyOf(arr, arr[0] == 0 ? arr.length : arr.length + 1);
//                        new_arr[new_arr.length - 1] = current;
//                        dfs(openCount+1, cards[i] - 1, cards, new_arr, 0);
//                        flag[i] = false;
//                    }
//                }
//            } else {
//                // 열었던 상자가 아니라면
//                flag[openIndex] = true;
//                dfs(openCount + 1, cards[openIndex] - 1, cards, arr, current+1);
//                flag[openIndex] = false;
//            }
//        }
    }
}
