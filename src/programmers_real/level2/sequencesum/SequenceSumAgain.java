package programmers_real.level2.sequencesum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SequenceSumAgain {

    public static void main(String[] args) {
        int[] sequence = {1,1,2,2,2,3,5};
        int sum = 4;

        int[] solution = new SequenceSumAgainSolution().solution(sequence, sum);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}

class SequenceSumAgainSolution {
    public int[] solution(int[] s, int k) {
        int left = 0, right = 0, value = s[0];
        List<Node> list = new ArrayList<>();
        while(true) {
            if(value == k) {
                list.add(new Node(left, right));
            }
            if(left == right && right == s.length)
                break;
            if(value <= k && right < s.length) {
                right++;
                if(right < s.length)
                    value += s[right];
            } else {
                if(left < s.length) {
                    value -= s[left++];
                }
            }
        }
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int length1 = o1.end - o1.start;
                int length2 = o2.end - o2.start;
                if(length1 == length2) {
                    return o1.start - o2.start;
                }
                return length1 - length2;
            }
        });

        int[] answer = {list.get(0).start, list.get(0).end};
        return answer;
    }

    class Node {
        int start;
        int end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
