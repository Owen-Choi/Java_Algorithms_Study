package programmers_real.level3;

import java.util.*;
public class 보석쇼핑 {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        String[] gems = {"AA", "AB", "AC", "AA", "AC"};
//        String[] gems = {"XYZ", "XYZ", "XYZ"};
//        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        int[] solution = new JewelSolution().solution(gems);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}

class JewelSolution {
    Set<String> gemSet = new HashSet<>();
    public int[] solution(String[] gems) {
        int[] answer = {};
        // 일단 set에 넣었다가 빼서 보석 종류의 개수를 알아내자.
        // 특정 조건을 만족하는 최소 범위 == 투포인터 문제
        Map<String, Integer> map = new HashMap<>();
        String prev;
        int left = 0, right = 0;
        for(int i=0; i<gems.length; i++) {
            gemSet.add(gems[i]);
        }
        int size = gemSet.size();
        ArrayList<int[]> result = new ArrayList<>();
        map.put(gems[0], 1);
        prev = gems[0];
        while(true) {
            if(left == right && right == gems.length)
                break;

            int current = map.size();
            if(current == size) {
                result.add(new int[]{left + 1, right + 1});
            }
            if(current < size && right < gems.length) {
                right++;
                if(right < gems.length) map.put(gems[right], map.getOrDefault(gems[right],0) + 1);
            } else {
                if(left < gems.length) {
                    left++;
                    int t = map.getOrDefault(prev, 0);
                    if(t - 1 > 0) {
                        map.put(prev, t - 1);
                    } else if(t - 1 == 0) {
                        map.remove(prev);
                    }
                    if(left < gems.length)
                        prev = gems[left];
                }
            }
        }
        Collections.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] - o1[0] == o2[1] - o2[0])
                    return o1[0] - o2[0];
                return (o1[1] - o1[0]) - (o2[1] - o2[0]);
            }
        });
        return result.get(0);
    }
}
