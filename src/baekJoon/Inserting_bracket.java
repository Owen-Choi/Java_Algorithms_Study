package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11899번
public class Inserting_bracket {
    static String inputStr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputStr = br.readLine();
        boolean right = false;
        int rightCount = 0;
        int leftRequired = 0;
        int result = 0;
        // 단순 괄호의 수가 아니라 닫히지 않은 괄호가 몇개가 있는지를 세어야 한다.
        for(int i=0; i<inputStr.length(); i++) {
            // 괄호가 오른쪽을 보고 있을 경우
            if(inputStr.charAt(i) == '(') {
                rightCount++;
                right = true;
                leftRequired++;
            } else {
                // 괄호가 왼쪽을 보고 있을 경우
                if (right) {
                    leftRequired--;
                    rightCount--;
                    if(leftRequired == 0) {
                        right = false;
                    }
                } else {
                    if(rightCount == 0)
                        result++;
                    else
                        rightCount--;
                }
            }
        }
        result = result + leftRequired;
        System.out.println(result);
    }
}
