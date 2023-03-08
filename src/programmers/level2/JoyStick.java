package programmers.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JoyStick {

    static int[] alphabets;
    static char[] values;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        alphabets = new int[26];
        for(int i=0; i<name.length(); i++) {
            alphabets[i] = i;
        }
        values = name.toCharArray();
        for(int i=0; i<name.length() - 1; i++) {
            // 다음 행선지를 찾고
            int target = findTarget(i);
            // 해당 행선지까지 더 작은 조작으로 이동하고
            cursorMove(i, target);
            // 도착한 행선지에서 더 작은 조작으로 알파벳 변경
            alphabetMove((int)values[target] - 65);

            if(target == values.length - 1)
                break;
        }
        return count;
    }

    public static int findTarget(int idx) {
        int i = idx;
        while(i < values.length && alphabets[i] == 0) {
            i++;
        }
        if(i >= values.length)
            return i - 1;
        return i;
    }

    public static void cursorMove(int idx, int target) {
        // count가 더 작은 쪽으로 더한다.
        // 역방향 크기 계산은 전체길이 - 목표지점 + 현재 위치
        // 정방향 크기 계산은 목표지점 - 현재 위치
        // 둘 중에 더 크기가 작은 것을 count에 더해준다.
        count += Math.min(values.length - target + idx, target - idx);
        System.out.println("move" + " " + Math.min(values.length - target + idx, target - idx));

    }

    public static void alphabetMove(int target) {
        // count가 더 작은 쪽으로 더한다.
        count += Math.min(26 - target + 1, target);
        System.out.println("target" + " " + Math.min(26 - target + 1, target));
    }


}
