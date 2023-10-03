package programmers_real.level3;

import java.util.*;

public class TravelRoute {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[] solution = new TravelRouteSolution().solution(tickets);
        for (String s : solution) {
            System.out.print(s + " ");
        }
    }
}

class TravelRouteSolution {
    String[][] t;
    boolean[] flag;
    List<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        t = tickets;
        flag = new boolean[tickets.length];
        dfs("ICN ", "ICN", 0);
        Collections.sort(list);
        return list.get(0).split(" ");
    }

    // dfs 다 돌리고 collection sort
    void dfs(String current, String airport, int depth) {
        if(depth == t.length) {
            list.add(current);
            return;
        }
        for(int i=0; i<t.length; i++) {
            if(!flag[i] && t[i][0].equals(airport)) {
                flag[i] = true;
                dfs(current + t[i][1] + " ", t[i][1], depth + 1);
                flag[i] = false;
            }
        }
    }
}
