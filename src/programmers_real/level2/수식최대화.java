package programmers_real.level2;

import java.util.*;
public class 수식최대화 {
    public static void main(String[] args) {
        String s = "100-200*300-500+20";
        System.out.println(new MaximizeNumber().solution(s));
    }
}

class MaximizeNumber {
    // - : 0, + : 1, * : 2
    int[] arr = {0,0,0};
    Map<Character, Integer> map = new HashMap<>();
    int result = 0;
    boolean[] flag = new boolean[3];
    Queue<String> queue = new LinkedList<>();
    Queue<String> calc;
    String s;

    public long solution(String expression) {
        long answer = 0;
        // 정해진 우선순위에 따라서 연산하는 로직을 작성해야 함.
        // 큐로 구현?
        s = expression;
        String temp = "";
        int counter = 0;
        while(counter < expression.length()) {
            temp = "";
            while(counter < expression.length() && Character.isDigit(expression.charAt(counter))) {
                temp += Character.toString(expression.charAt(counter));
                counter++;
            }
            if(temp.length() == 0)
                temp = Character.toString(expression.charAt(counter++));

            queue.offer(temp);
        }
        calc = new LinkedList<>(queue);
        dfs(0);
        return answer;
    }

    // 중복을 허용하지 않는 순열로 우선순위를 결정하겠음
    void dfs(int value) {
        if(value == 3) {
            Queue<String> temp = new LinkedList<>();
            int counter = 0;
            // 여기서 로직을 전개하면 됨
            map.put('-', arr[0]);
            map.put('+', arr[1]);
            map.put('*', arr[2]);
            long prev = 0l;
            while(counter < 3) {
                while(!calc.isEmpty()) {
                    String poll = calc.poll();
                    if(!poll.equals("-") && !poll.equals("+") && !poll.equals("*")) {
                        // prev = Long.parseLong(poll);
                        temp.offer(poll);
                    } else {
                        // poll 이 만약 수식이고,
                        if(map.get(poll.charAt(0)) == counter) {
                            // 이번에 계산할 차례가 되었다면
                            long tempResult = 0l;
                            if(poll.equals("-")) {
                                // 수식이 나왔다는건 뒤에 반드시 숫자가 따라온다는 뜻. 하나 더 빼서 연산한 결과 저장
                                tempResult = Long.parseLong(temp.poll()) - Long.parseLong(calc.poll());
                                temp.offer(Long.toString(tempResult));
                            } else if(poll.equals("+")) {
                                tempResult = Long.parseLong(temp.poll()) + Long.parseLong(calc.poll());
                                temp.offer(Long.toString(tempResult));
                            } else if(poll.equals("*")) {
                                tempResult = Long.parseLong(temp.poll()) * Long.parseLong(calc.poll());
                                temp.offer(Long.toString(tempResult));
                            }
                        } else {
                            // 이번에 계산할 차례가 아니라면 temp에 수식을 그대로 저장
                            temp.offer(poll);
                        }
                    }
                }
                counter++;
                // 다음번 계산을 위해서 queue를 새로 할당해줌
                calc = new LinkedList<>(temp);
                temp.clear();
            }
            System.out.println(calc.poll());
            // 리턴하기 전에 다음 연산을 위해서 queue를 다시 할당해준다.
            calc = new LinkedList<>(queue);
            return;
        }
        for(int i=0; i<3; i++) {
            if(!flag[i]) {
                flag[i] = true;
                arr[i] = value;
                dfs(value + 1);
                flag[i] = false;
            }
        }
    }
}
