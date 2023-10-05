package programmers_real.pccp;

import java.util.*;
public class 유전법칙 {
    public static void main(String[] args) {
        int[][] q = {{3,8}, {2,2}};
        String[] solution = new GeneSolution().solution(q);
        for (String s : solution) {
            System.out.print(s + " ");
        }
    }
}


class GeneSolution {
    public String[] solution(int[][] queries) {
        // 26 / 4 = 6, 26 % 4 != 0, 즉 부모세대에서 7번째 자손의 26 % 4 번째 자식
        String[] answer = new String[queries.length];
        int counter = 0;
        Stack<Node> stack = new Stack<>();
        String result = "";
        String[] mixGen = {"RR", "Rr", "Rr", "rr"};
        int generation = 0, target = 0, order = 0, childOrder = 0, position = 0;
        for(int i=0; i<queries.length; i++) {
            generation = queries[i][0];
            target = queries[i][1];
            while(generation > 1) {
                order = target % 4 == 0 ? 4 : target % 4;
                if(target % 4 != 0) target = (target / 4) + 1;
                else target = target / 4;
                generation--;
                stack.push(new Node(generation, order));
            }
            int size = stack.size();
            result = "Rr";
            for(int k=0; k<size; k++) {
                Node pop = stack.pop();
                // 이제부터 위에서 찾아내려가면 된다.
                if(result == "Rr") {
                    result = mixGen[pop.childOrder - 1];
                } else if(result == "RR") result = "RR";
                else result = "rr";
            }
            answer[counter++] = result;
        }
        return answer;
    }
}

class Node {
    int generation;
    int childOrder;
    public Node(int g, int c) {
        this.generation = g;
        this.childOrder = c;
    }
}
