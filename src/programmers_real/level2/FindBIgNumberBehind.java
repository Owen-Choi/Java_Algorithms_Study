package programmers_real.level2;

import java.util.Stack;

public class FindBIgNumberBehind {
    public static void main(String[] args) {
        int[] input = {9, 1, 5, 3, 6, 2};
//        int[] input = {2, 3, 3, 5};
        int[] solution = new FindBIgNumberBehindSolution().solution(input);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}

class FindBIgNumberBehindSolution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=numbers.length - 1; i>=0; i--) {
                while(!stack.isEmpty() && numbers[i] >= stack.peek()) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    answer[i] = -1;
                    stack.push(numbers[i]);
                } else {
                    answer[i] = stack.peek();
                    stack.push(numbers[i]);
                }
        }
        return answer;
    }
}
