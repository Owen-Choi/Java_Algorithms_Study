package programmers_real.level2.sequencesum;

public class SequenceSumAgain {

    public static void main(String[] args) {
        int[] sequence = {1,1,1,2,3,4,5};
        int sum = 5;

        int[] solution = new Solution_SequenceSum().solution(sequence, sum);
        for (int i : solution) {
            System.out.println(i);
        }
    }
    }
}

class SequenceSumAgainSolution {
    public int[] solution(int[] s, int k) {
        int left = 0, right = 1, value = 0;
        while(left <= right) {

        }
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
