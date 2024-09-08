package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 물병 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String binary = Integer.toBinaryString(n);
        int result = 0;
        // n을 이진수로 나타내면, 물이 남아 있는 물병의 수가 된다.
        // 왜냐하면, 2로 나눠가는 과정이고 나누어 떨어지는 것은 0이 되기 때문이다.
        // 즉, 7을 이진수로 나타내면 111이 되고, 이는 물병을 최대로 합쳤을 때 3병이 남게 된다는 뜻이다.
        // 이를 만약 1개로 만들고 싶다면 1000 으로 만들어야 하고, 2개로 만들고 싶다면 1"11" 에서 "11"을 "100" 으로 만들어야 한다.
        int one = Integer.bitCount(n);
        int index = 0;
        String tempBinary = "";
        if(one <= k) {
            System.out.println(0);
            return;
        } else {
            // one <= k라면 물병을 구매하지 않고 바로 종료 가능하다.
            // 그렇지 않다면 물병을 구매해야 한다.
            for(int i=0; i<binary.length(); i++) {
                if(binary.charAt(i) == '1') {
                    k--;
                    index = i;
                }
                if(k == 0) {
                    // 만약 k가 2이고, n이 11101라면 1"1101" 에서 1101을 10000으로 만들어주어야 한다.
                    // 그러기 위해서 일단 1101을 잘라준다.
                    tempBinary = binary.substring(index);
                    break;
                }
            }
        }

        int current = Integer.parseInt(tempBinary, 2);
        String targetBinary = "1";
        for(int i=0; i<tempBinary.length(); i++) {
            targetBinary += "0";
        }

        int target = Integer.parseInt(targetBinary, 2);
        System.out.println(target - current);
    }
}
