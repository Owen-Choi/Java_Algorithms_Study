package programmers.level3;

import java.util.*;
import java.io.*;

public class 이차원_동전_뒤집기 {

    static int answer = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    // 10 * 10에서도 재귀를 너무 많이 뿌려버리면 감당이 안된다.
    public static void main(String[] args) throws IOException {
//        int[][] beginning = {{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        int[][] beginning = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
//        int[][] target = {{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
        int[][] target = {{1, 0, 1}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(new Solution().solution(beginning, target));
    }

    static class Solution {
        static int solution(int[][] beginning, int[][] target) {
            // 정답을 이미 봤다. 다시 한번 풀어보자.
            // 행을 뒤집는 모든 경우의 수를 확인하고, 이 각각의 케이스에서 열을 뒤집거나 유지해서 target을 만들 수 있는지 확인하면 된다.
            // 행을 뒤집는 모든 경우의 수는 어떻게 확인하지?
            // 재귀에서는 뒤집는다, 뒤집지 않는다 두 가지 경우의 수만 확인하고 뒤집는 결과를 리스트에 저장해서 확인한다.
            recur(-1, beginning, target);
            return answer == Integer.MAX_VALUE ? -1 : answer;
        }

        static void recur(int x, int[][] beginning, int[][] target) {
            if (x == beginning.length - 1) {
                // 리스트를 순회하며 값을 뒤집어주고, 다 뒤집었다면 열을 확인한다.
                // 처음부터 값이 같을 수도 있으니, 리스트가 0일때를 제외해주지 않고 모두 고려해준다.
                calc(list, beginning, target);
                return;
            }

            // 뒤집지 않는 경우의 수
            recur(x + 1, beginning, target);

            // 뒤집는 경우의 수
            list.add(x + 1);
            recur(x + 1, beginning, target);
            list.remove(list.size() - 1);
        }


        static void calc(List<Integer> list, int[][] beginning, int[][] target) {
            int n = beginning.length, m = beginning[0].length;
            int[][] arr = new int[n][m];

            // 배열 복사
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < m; k++) {
                    arr[i][k] = beginning[i][k];
                }
            }

            // 행 반전
            for (int i = 0; i < list.size(); i++) {
                int x = list.get(i);
                for (int k = 0; k < m; k++) {
                    arr[x][k] = arr[x][k] == 0 ? 1 : 0;
                }
            }

            // 열 확인 및 반전
            int swapCount = 0;
            for (int i = 0; i < m; i++) {
                for (int k = 0; k < n; k++) {
                    if (arr[k][i] != target[k][i]) {
                        for (int kk = 0; kk < n; kk++) {
                            arr[kk][i] = arr[kk][i] == 0 ? 1 : 0;
                        }
                        for (int kk = 0; kk < n; kk++) {
                            if (arr[kk][i] != target[kk][i])
                                return;
                        }
                        swapCount++;
                        break;
                    }
                }
            }
            answer = Math.min(answer, list.size() + swapCount);

        }
    }

//    static void calc(List<Integer> list, int[][] beginning, int[][] target) {
//        int[][] na = new int[beginning.length][beginning[0].length];
////        for(int i=0; i<beginning.length; i++) {
////            na[i] = Arrays.copyOf(beginning[i], beginning[i].length);
////        }
//        for(int i=0; i<list.size(); i++) {
//            int newX = list.get(i);
//            for(int k=0; k<na[0].length; k++) {
//                na[newX][k] = na[newX][k] == 0 ? 1 : 0;
//            }
//        }
//        // 행 뒤집기가 끝났다면 열을 뒤집어 줌
//        int colSwapCount = 0;
//        for(int i=0; i<na[0].length; i++) {
//            // 먼저 각 열이 목표와 일치하는지 확인한다.
//            for(int k=0; k<na.length; k++) {
//                // 하나라도 다르다면 확인 시작. 뒤집었는데도 다르다면 그 조합은 성립이 불가능한 것이다.
//                if(na[k][i] != target[k][i]) {
//                    // 뒤집어보기
//                    for(int ii=0; TODO ii<na[0].length; ii++) {
//                        na[k][ii] = na[k][ii] == 0 ? 1 : 0;
//                        // 뒤집으며 그때그때 체크, 값이 다르다면 바로 return
//                        if(na[k][ii] != target[k][ii])
//                            return;
//                    }
//                    // 위 반복문을 잘 나왔다면 뒤집어서 일치하는 경우
//                    colSwapCount++;
//                    // 해당 열은 조사가 끝났으므로 반복문을 종료시켜준다.
//                    break;
//                }
//                // 같다면 아무것도 하지 않고 반복
//            }
//        }
//        // 반복문을 무사히 빠져나왔다 == 성립한다.
//        answer = Math.min(answer, list.size() + colSwapCount);
//    }
}
