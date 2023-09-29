package programmers_real.level2;

import java.util.*;
public class DividingElectrocity {
    public static void main(String[] args) {
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int n = 9;
        System.out.println(new DividingElectrocitySolution().solution(n, wires));
    }
}


class DividingElectrocitySolution {
    boolean[] flag;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ArrayList<Integer>[] list = new ArrayList[n];
        flag = new boolean[n];
        // 크루스칼, 간선을 하나씩 끊어가며 최적의 해 찾아보기
        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<wires.length; i++) {
            list[wires[i][0] - 1].add(wires[i][1] - 1);
            list[wires[i][1] - 1].add(wires[i][0] - 1);
        }

        // 간선을 하나씩 끊으며 결과를 보겠다.
        Queue<Integer> queue = new LinkedList<>();
        int aCount = 0, bCount = 0;
        for(int i=0; i<wires.length; i++) {
            // 연결된 부분의 반대쪽을 끊어놓겠다.
            flag[wires[i][1] - 1] = true;
            flag[wires[i][0] - 1] = true;
            queue.offer(wires[i][0] - 1);
            aCount = 0;
            while(!queue.isEmpty()) {
                int poll = queue.poll();
                aCount++;
                for(int j=0; j<list[poll].size(); j++) {
                    if(!flag[list[poll].get(j)]) {
                        flag[list[poll].get(j)] = true;
                        queue.offer(list[poll].get(j));
                    }
                }
            }
            // flag 배열 초기화
            Arrays.fill(flag, false);
            // 반대쪽의 개수를 확인하겠음
            flag[wires[i][0] - 1] = true;
            flag[wires[i][1] - 1] = true;
            queue.offer(wires[i][1] - 1);
            bCount = 0;
            while(!queue.isEmpty()) {
                int poll = queue.poll();
                bCount++;
                for(int j=0; j<list[poll].size(); j++) {
                    if(!flag[list[poll].get(j)]) {
                        flag[list[poll].get(j)] = true;
                        queue.offer(list[poll].get(j));
                    }
                }
            }
            answer = Math.min(answer, Math.abs(aCount - bCount));
            Arrays.fill(flag, false);
        }
        return answer;
    }
}
