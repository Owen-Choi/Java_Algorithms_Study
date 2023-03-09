package programmers.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JoyStick {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        int result = 0;
        char[] values = name.toCharArray();
        int next;
        int move = name.length() - 1;

        for(int i = 0; i < name.length(); i++){
            result += Math.min((int)values[i] - 65, 26 - ((int)values[i] - 65));
            next = findNext(i, values);

            // 참고 부분
            move = Math.min(move, i * 2 + name.length() - next);
            move = Math.min(move, (name.length() - next) * 2 + i);

            System.out.println(move);
        }
        return result + move;
    }

    public static int findNext(int i, char[] values) {
        int next = i + 1;
        // 연속되는 A 갯수 확인
        while(next < values.length && values[next] == 'A'){
            next++;
        }
        return next;
    }
    

}
