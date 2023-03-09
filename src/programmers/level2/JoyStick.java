package programmers.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JoyStick {

    static char[] values;
    static int count = 0;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        int target = 0;
        values = name.toCharArray();
        for(int i=0; i<name.length(); i = target) {
            alphabetMove((int)values[i] - 65);
            if(flag) break;
            // 다음 행선지를 찾고
            if(i == name.length() - 1)
                break;
            target = findTarget(i);
            // 해당 행선지까지 더 작은 조작으로 이동하고
            cursorMove(i, target);
        }

//        int target = 0;
//        int idx = 0;
//        while(true) {
//            alphabetMove((int)values[idx] - 65);
//            if(target == values.length - 1)
//                break;
//            target = findTarget(idx);
//            cursorMove(idx, target);
//            idx = target;
//        }

        return count;
    }

    public static int findTarget(int idx) {
        int i;
        if(idx == values.length - 1) {
            // 인덱스 에러 조심
            i = idx;
        } else {
            i = idx + 1;
        }
        int moveCount = 1;
        if(values[i] == 'A') {
            moveCount++;
            i++;
        }

        return idx + moveCount;
    }

    public static void cursorMove(int idx, int target) {
        // count가 더 작은 쪽으로 더한다.
        // 역방향 크기 계산은 전체길이 - 목표지점 + 현재 위치
        // 정방향 크기 계산은 목표지점 - 현재 위치
        // 둘 중에 더 크기가 작은 것을 count에 더해준다.
        count += Math.min(values.length - target + idx, target - idx);
        if(target == values.length - 1)
            flag = true;
    }

    public static void alphabetMove(int target) {
        // count가 더 작은 쪽으로 더한다.
        count += Math.min(26 - target, target);
    }


}
