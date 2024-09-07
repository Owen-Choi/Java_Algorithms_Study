package baekJoon.normal;

import java.io.*;
import java.util.Stack;

public class 옥상_정원_꾸미기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n은 최대 8만.
        // 주의 : 8만부터 1까지 다 더하게 되는 테스트케이스가 존재하는 듯 하다.
        // 결과를 저장해주는 변수의 타입이 정수라면 오답을 맞게 된다.
        int n = Integer.parseInt(br.readLine());
        // 각 빌딩의 높이는 최대 10억.
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        for(int i=0; i<n; i++) {
            if(stack.isEmpty()) {
                stack.push(arr[i]);
            } else if(arr[i] < stack.peek()) {
                result += stack.size();
                stack.push(arr[i]);
            } else {
                while(!stack.isEmpty() && arr[i] >= stack.peek()) {
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    result += stack.size();
                }
                stack.push(arr[i]);
            }
        }
        // 반복문이 종료된 이후 남은 스택에 대해서 처리해 줄 필요는 없음.
        // 5 6으로 마무리가 됐다면, 어차피 6은 마지막이라 더 이상 볼 수 있는 빌딩이 없음
        // 5 4로 마무리가 됐다면, 내부 로직에 의해서 이미 result에 값이 더해졌기 때문에 별도의 처리는 필요 없음.
        System.out.println(result);
    }
}
