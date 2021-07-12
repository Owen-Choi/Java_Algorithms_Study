package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9012번
public class VPS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());
        String temp;
        while (TestCase > 0) {
            TestCase--;
            temp = br.readLine();
            if (checkVPS(temp))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    static boolean checkVPS(String temp) {
        int Count = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '(') {
                Count++;
            } else if (temp.charAt(i) == ')') {
                Count--;
            }
            if(Count < 0)
                return false;
        }
        return Count == 0;
    }
}
