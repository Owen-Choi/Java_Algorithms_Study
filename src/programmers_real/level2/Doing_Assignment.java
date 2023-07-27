package programmers_real.level2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

// 프로그래머스 level2 - 과제 진행하기
// https://school.programmers.co.kr/learn/courses/30/lessons/176962
public class Doing_Assignment {

    public static void main(String[] args) {
//        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"},
//                {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
//        String[][] plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"},
//                {"ccc", "12:40", "10"}};
        String[][] plans = {{"aaa", "11:50", "30"}, {"bbb", "13:00", "20"},
                {"ccc", "13:10", "30"}};

        Doing_Assignment da = new Doing_Assignment();
        Solution solution = da.new Solution();
        String[] solution1 = solution.solution(plans);
        for (String s : solution1) {
            System.out.println(s);
        }
    }

    class Solution {
        public String[] solution(String[][] plans) {
            Stack<Work> stack = new Stack<>();
            String[] answer = new String[plans.length];
            int counter = 0;
            PriorityQueue<Work> works = new PriorityQueue<>(new Comparator<Work>() {
                @Override
                public int compare(Work o1, Work o2) {
                    return o1.startTime - o2.startTime;
                }
            });

            for(int i=0; i<plans.length; i++) {
                Work work = new Work(plans[i][0], convertTime(plans[i][1]), Integer.parseInt(plans[i][2]));
                works.add(work);
            }

            do {
                while(!works.isEmpty()) {
                    Work poll = works.poll();
                    if(!works.isEmpty()) {
                        Work peek = works.peek();
                        if(peek.startTime - poll.startTime < poll.duration) {
                            poll.duration -= peek.startTime - poll.startTime;
                            stack.push(poll);
                        } else {
                            int remainder = (peek.startTime - poll.startTime) - poll.duration;
                            // 다음 과제까지 남은 시간보다 현재 과제에 소요되는 시간이 더 작다
                            // == 현재 과제를 지금 끝낼 수 있다.
                            answer[counter++] = poll.name;
                            // 여기서 남은 시간동안 stack에서 과제를 마저 처리해줘야 한다.
                            while(remainder > 0 && !stack.isEmpty()) {
                                Work work = stack.pop();
                                if(work.duration <= remainder) {
                                    remainder -= work.duration;
                                    answer[counter++] = work.name;
                                } else {
                                    work.duration -= remainder;
                                    stack.push(work);
                                    break;
                                }
                            }
                        }
                    } else {
                        // 한개의 과제를 제외하고 모두 완료했으므로 한개를 그냥 끝내도 된다.
                        answer[counter++] = poll.name;
                        if(!stack.isEmpty()) {
                            works.add(stack.pop());
                        }
                    }
                }
            } while(!stack.isEmpty());

            return answer;
        }

        private int convertTime(String time) {
            int value = 0;
            String[] strings = time.split(":");
            value += Integer.parseInt(strings[0]) * 60;
            value += Integer.parseInt(strings[1]);

            return value;
        }

        class Work {
            String name;
            int startTime;
            int duration;

            public Work(String name, int startTime, int duration) {
                this.name = name;
                this.startTime = startTime;
                this.duration = duration;
            }
        }
    }
}
