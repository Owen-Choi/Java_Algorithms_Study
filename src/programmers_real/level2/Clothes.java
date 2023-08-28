package programmers_real.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clothes {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        new ClothesSolution().solution(clothes);
    }
}

class ClothesSolution {
    Map<String, List<String>> map = new HashMap<>();
    public int solution(String[][] clothes) {
        int answer = 0;
        for(int i=0; i<clothes.length; i++) {
            if(!map.containsKey(clothes[i][1]))
                map.computeIfAbsent(clothes[i][1], v -> new ArrayList<>()).add(clothes[i][0]);
            else
                map.get(clothes[i][1]).add(clothes[i][0]);
        }


        return answer;
    }
}
