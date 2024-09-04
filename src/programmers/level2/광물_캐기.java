package programmers.level2;

import java.util.*;

public class 광물_캐기 {
    public static void main(String[] args) {
//        int[] picks = {1, 3, 2};
        int[] picks = {0,1,1};
//        int[] picks = {1,0,1};
//        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
//        String[] minerals = {"iron", "iron", "iron", "iron", "stone", "diamond"};
        int solution = new MiningSolution().solution(picks, minerals);
        System.out.println(solution);
    }

    static class MiningSolution {
        static final String dia = "diamond";
        static final String ir = "iron";
        public int solution(int[] picks, String[] minerals) {

            // 1. 곡괭이로 캘 수 있는 최대 길이를 구함
            int max = Math.min(picks[0] * 5 + picks[1] * 5 + picks[2] * 5, minerals.length);
            ArrayList<ArrayList<String>> chunks = new ArrayList<>();
            ArrayList<String> element = new ArrayList<>();
            int answer = 0;
            // 5개씩 끊어서 리스트를 저장한다.
            int count = 0;
            for(int i=0; i<max; i++, count++) {
                // 1 2 3 4 5 6 7 8 9 10
                // 1 2 3 4 0 1 2 3 4 0
                if(count == 5) {
                    count = 0;
                    chunks.add(element);
                    element = new ArrayList<>();
                    element.add(minerals[i]);
                } else {
                    element.add(minerals[i]);
                }
            }
            if(count != 0) {
                chunks.add(element);
            }

            // 가능한 길이 만큼 끊은 청크를 정렬한다.
            // comparator 활용 :: 각 광물의 종류별로 개수를 카운트하고, 광물의 가치만큼 값을 곱해서 정렬한다.
            chunks.sort(new Comparator<ArrayList<String>>() {
                @Override
                public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                    // stream 말고 1차원적으로 카운트하겠다.
                    int dia1 = 0, dia2 = 0, ir1 = 0, ir2 = 0, st1 = 0, st2 = 0;
                    int result1 = 0, result2 = 0;
                    for(String temp : o1) {
                        if(temp.equals(dia))
                            dia1++;
                        else if(temp.equals(ir))
                            ir1++;
                        else
                            st1++;
                    }

                    for(String temp : o2) {
                        if(temp.equals(dia))
                            dia2++;
                        else if(temp.equals(ir))
                            ir2++;
                        else
                            st2++;
                    }
                    result1 = (dia1 * 25) + (ir1 * 5) + (st1);
                    result2 = (dia2 * 25) + (ir2 * 5) + (st2);

                    return result2 - result1;
//                    if(dia1 == dia2) {
//                        return (int)(ir2 - ir1);
//                    } else if(dia1 != dia2){
//                        return (int)(dia2 - dia1);
//                    } else {
//                        return o1.size() - o2.size();
//                    }
                }
            });

            StringBuilder sb = new StringBuilder();
            for(ArrayList<String> list : chunks) {
                for(String each : list) {
                    sb.append(each).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());

            // 청크 정렬이 끝났으면 곡괭이가 좋은 순으로 캐기만 하면 됨.
            // 여기서 문제가 생겼는데, 어디가 문제인지 모르겠다.
            for(ArrayList<String> list : chunks) {
                int index = 0;
                for(String mineral : list) {
                    if(picks[0] > 0) {
                        // 다이아몬드 곡괭이는 다 1로 캘 수 있으니 리스트의 길이를 더해주고 끝냄 :: 최적화
                        answer += list.size();
                        index = 0;
                        // 아래 코드가 잘못됐었음. 여기서 한번 깎이고, 반복문이 끝났을 때 한번 더 깎인다.
                        // picks[index]--;
                        break;
                    } else if(picks[1] > 0) {
                        answer = mineral.equals(dia) ? answer + 5 : answer + 1;
                        index = 1;
                    } else {
                        answer = mineral.equals(dia) ? answer + 25 : mineral.equals(ir) ? answer + 5 : answer + 1;
                        index = 2;
                    }
                }
                picks[index]--;
            }
//            for (ArrayList<String> strings : chunks) {
//                int pick = 0;
//                if(picks[0] != 0) {
//                    pick = 0;
//                    picks[0]--;
//                } else if(picks[1] != 0) {
//                    pick = 1;
//                    picks[1]--;
//                } else {
//                    pick = 2;
//                    picks[2]--;
//                }
//                for (String string : strings) {
//                    if(pick == 0) {
//                        answer++;
//                    } else if(pick == 1) {
//                        if(string.equals("diamond"))
//                            answer += 5;
//                        else
//                            answer++;
//                    } else {
//                        if(string.equals("diamond"))
//                            answer += 25;
//                        else if(string.equals("iron"))
//                            answer += 5;
//                        else
//                            answer++;
//                    }
//                }
//            }

            return answer;
        }
    }
}
