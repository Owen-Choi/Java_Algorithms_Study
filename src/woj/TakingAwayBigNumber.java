package woj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class TakingAwayBigNumber {
    public static void main(String[] args) throws IOException {
        String a, b, big, small;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        boolean initialFlag = false;
        a = st.nextToken();
        st = new StringTokenizer(br.readLine());
        b = st.nextToken();

        if(a.equals(b)) {
            System.out.println(0);
            return;
        }

        if(a.length() != b.length()) {
            big = a.length() > b.length() ? a : b;
            small = a.length() > b.length() ? b : a;
        } else {
            // 두 수가 완전히 똑같을 경우를 대비
            big = a;
            small = b;
            for(int i=0; i<b.length(); i++) {
                if(a.charAt(i) - '0' > b.charAt(i) - '0') {
                    big = a;
                    small = b;
                } else if(a.charAt(i) - '0' < b.charAt(i) - '0') {
                    big = b;
                    small = a;
                }
            }
        }

        int counter = big.length() - small.length();
        int[] bigArr = new int[big.length()];
        int[] smallArr = new int[big.length()];
        for(int i=0; i< big.length(); i++) {
            bigArr[i] = big.charAt(i) - '0';
        }
        for(int i=0; i<counter; i++) {
            smallArr[i] = 0;
        }
        for(int i=0; i<small.length(); i++) {
            smallArr[counter + i] = small.charAt(i) - '0';
        }

        for(int i=big.length() - 1; i>=0; i--) {
            if(bigArr[i] < smallArr[i]) {
                counter = i - 1;
                while(counter > 0 && bigArr[counter] == 0) {
                    // 1001 같은 경우는, 가장 앞에서 1을 빌려와야 하고, 빌려오는 과정에서 0은 9로 바뀌기 때문에 9로 비꿔준다.
                    bigArr[counter] = 9;
                    counter--;
                }
                // 0이 아닌 앞 자리에서 10을 빌려온다.
                bigArr[counter]--;
                bigArr[i] += 10;
            }
            stack.push(bigArr[i] - smallArr[i]);
        }

        if(big.equals(b))
            System.out.print('-');
        while(!stack.isEmpty()) {
            int each = stack.pop();
            if(!initialFlag) {
                if(each != 0) {
                    System.out.print(each);
                    initialFlag = true;
                }
            } else {
                System.out.print(each);
            }
        }
    }
}
