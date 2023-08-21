package programmers_real.level2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/172927

public class Mining {

    public static void main(String[] args) {
//        int [] picks = {1,3,2};
        int [] picks = {0,1,1};
//        String [] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        int solution = new MiningSolution().solution(picks, minerals);
        System.out.println(solution);
    }
}

class MiningSolution {
    public int solution(int[] picks, String[] minerals) {
        int stamina = 0;
        int max = Math.min(picks[0] * 5 + picks[1] * 5 + picks[2] * 5, minerals.length);
        ArrayList<ArrayList<String>> chunk = new ArrayList<>();
        int counter = 0;
        ArrayList<String> element = new ArrayList<>();
        for(int i=0; i<max; i++, counter++) {
            if(counter == 5) {
                counter = 0;
                chunk.add(element);
                element = new ArrayList<>();
                element.add(minerals[i]);
            } else {
                element.add(minerals[i]);
            }
        }
        if(counter != 0) {
            chunk.add(element);
        }

        chunk.sort(new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                long diamond1 = o1.stream().filter(e -> e.equals("diamond")).count();
                long diamond2 = o2.stream().filter(e -> e.equals("diamond")).count();
                long iron1 = o1.stream().filter(e -> e.equals("iron")).count();
                long iron2 = o2.stream().filter(e -> e.equals("iron")).count();
                if(diamond1 == diamond2) {
                    return (int)(iron2 - iron1);
                } else if(diamond1 != diamond2){
                    return (int)(diamond2 - diamond1);
                } else {
                    return o1.size() - o2.size();
                }
            }
        });

        for (ArrayList<String> strings : chunk) {
            int pick = 0;
            if(picks[0] != 0) {
                pick = 0;
                picks[0]--;
            } else if(picks[1] != 0) {
                pick = 1;
                picks[1]--;
            } else {
                pick = 2;
                picks[2]--;
            }
            for (String string : strings) {
                if(pick == 0) {
                    stamina++;
                } else if(pick == 1) {
                    if(string.equals("diamond"))
                        stamina += 5;
                    else
                        stamina++;
                } else {
                    if(string.equals("diamond"))
                        stamina += 25;
                    else if(string.equals("iron"))
                        stamina += 5;
                    else
                        stamina++;
                }
            }
        }

        return stamina;
    }
}
