package woj;

import java.util.Scanner;
import java.util.Stack;

public class AddingBigNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a, b, big, small;
        a = sc.next();
        b = sc.next();
        Stack<Integer> stack = new Stack<>();

        if(a.length() != b.length()) {
            big = a.length() > b.length() ? a : b;
            small = a.length() > b.length() ? b : a;
        } else {
            // 두 수가 똑같을 때를 대비, 똑같을 때는 어떤 수가 big이 되든 상관이 없다.
            big = a;
            small = b;
            for(int i=0; i<a.length(); i++) {
                if(a.charAt(i) - '0' > b.charAt(i) - '0') {
                    big = a;
                    small = b;
                } else if(a.charAt(i) - '0' < b.charAt(i) - '0') {
                    big = b;
                    small = a;
                }
            }
        }

        char[] arr = new char[big.length()];
        int counter = big.length() - small.length();

        // big과 small의 길이 차이를 측정한 뒤 small의 앞에 그 길이 만큼 0을 붙여준다.
        for(int i=0; i<counter; i++) {
            arr[i] = '0';
        }
        for(int i=0; i<small.length(); i++) {
            arr[counter + i] = small.charAt(i);
        }

        for(int i=big.length()-1; i>=0; i--) {
            int aElement = big.charAt(i) - '0';
            int bElement = arr[i] - '0';
//            System.out.println(aElement + " , " + bElement);
            if(aElement + bElement >= 10) {
                stack.push((aElement + bElement) % 10);
                if(i != 0) {
                    arr[i - 1] = (char)(((arr[i - 1] - '0') + 1) + '0');
                } else {
                    stack.push(1);
                    break;
                }
            } else {
                stack.push(aElement + bElement);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }
}
