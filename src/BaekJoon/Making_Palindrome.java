package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 1213번
public class Making_Palindrome {
    static String inputStr;
    static int c[];
    static int r[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputStr = br.readLine();
        // 1. 앞글자, 끝글자 / 두번째 글자, 끝에서 두번째 글자 등과 같이 서로 대응되는 위치의 문자를 같은 문자로 맞춰준다.
        // greedy라서 각 선택마다 최적의 선택을 만들면 풀 수 있는 문제

        // 홀수개로 존재하는 알파벳의 수를 체크하기 위한 변수. 경우 막론하고 이 정수값이 2 이상이라면 palindrome은 성립할 수 없다.
        int oddNum = 0;
        c = new int[26];
        r = new int[inputStr.length()];
        // 사전순으로 더 빠른 알파벳에 빠르게 접근하기 위해 별도의 배열을 선언하겠음
        for (char character : inputStr.toCharArray()) {
            c[(int)character - 65]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int counter = 0;
        boolean oddFlag;
        for(int k=0; k<c.length; k++) {
            oddFlag = true;
            while(c[k] > 1) {
                r[counter] = r[inputStr.length() - 1 - counter] = (k + 65);
                c[k] -= 2;
                counter++;
                oddFlag = false;
            }
            if(c[k] == 1) {
                oddNum++;
                queue.add(k + 65);
                c[k]--;
            }

            // 홀수개로 존재하는 변수가 2개 이상이라면 I'm Sorry Hansoo를 출력하고 프로그램을 종료한다.
            if(oddNum > 1) {
                System.out.println("I'm Sorry Hansoo");
                System.exit(0);
            }
        }

        for(int i=0; i<inputStr.length(); i++) {
            if(r[i] == 0) {
                r[i] = queue.remove();
            }
        }

        for(int i=0; i<inputStr.length(); i++) {
            System.out.print((char)(r[i]));
        }
    }
}
