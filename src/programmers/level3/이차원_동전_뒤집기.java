package programmers.level3;

import java.util.*;
import java.io.*;

public class 이차원_동전_뒤집기 {


    // 10 * 10에서도 재귀를 너무 많이 뿌려버리면 감당이 안된다.
    public static void main(String[] args) throws IOException {
        int[][] beginning = {{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        int[][] target = {{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};

    }

    static class Solution {
        static int solution(int[][] beginning, int[][] target) {
            int answer = 0;
            // 정답을 이미 봤다. 다시 한번 풀어보자.

            return answer == 0 ? -1 : answer;
        }

    }
}
