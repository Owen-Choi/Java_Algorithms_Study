package woj;

import java.util.Scanner;
import java.util.Stack;

public class TrainCross {
    // S : 교차로에 넣음
    // X : 통과
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n  = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int next = 1, counter = 0, iterator = 0;
        Stack<Integer> order = new Stack<>();
        StringBuilder sb = new StringBuilder();
        // 모든 기차가 교차로에 들렀다가 통과하는 2*n의 횟수 만큼 반복한다.
        for(int i=0; i<2*n; i++) {
            if(!order.isEmpty() && order.peek() == next) {
                // 예제에서도 1번 기차를 바로 통과시키는게 아니라, 교차로로 진입시킨 후 통과시킨다.
                // 따라서 일단 스택에 다 넣고, 그 뒤에 검증을 하는게 맞다.
                order.pop();
                sb.append("X");
                next++;
                iterator++;
            } else if(counter < n) {
                // 인덱스 에러가 발생하지 않는 범위라면
                order.push(arr[counter++]);
                sb.append("S");
                iterator++;
            }
        }
        if(iterator != 2*n) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(sb.toString());
        }
    }
}
