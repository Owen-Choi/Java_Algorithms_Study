package baekJoon.normal;

import java.io.*;
import java.util.*;
public class A_to_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long a, b;
        // b에서 시작해서 a로 가는 과정이 맞는 것 같다.
        // 1이 나오면 떼어버리고, 나머지는 2를 나눈다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int count = 0;
        while(true) {
            count++;
            if(b % 10 == 1 && b/10 >= a) {
                b /= 10;
            } else if(b % 2 == 0){
                b /= 2;
            } else {
                System.out.println(-1);
                break;
            }
            if(a == b) {
                System.out.println(count+1);
                break;
            }
            else if(a > b) {
                System.out.println(-1);
                break;
            }
        }
    }
}
