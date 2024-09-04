package programmers.level2;

import java.util.*;
import java.io.*;

public class 메뉴_리뉴얼 {
    static List<Character> list;
    static Set<String> set = new HashSet<>();
    static String[] orders_static;
    static List<Node> nodes = new ArrayList<>();
    public static void main(String[] args) {
//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        String[] orders = {"XYZ", "XWY", "WXA"};
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] course = {2,3,5};
//        int[] course = {2,3,4};
        int[] course = {2,3,4};
        String[] result = solution(orders, course);
        for(String element : result) {
            System.out.print(element + " ");
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        list = new ArrayList<>();
        orders_static = orders;
        // 조합 구하는 파트
        // 구한 조합을 확인하는 파트
        // 길이별로 정렬할 필요는 없고, 그냥 동석차까지 다 넣어주고 정렬돌리면 된다.
        for(int i=0; i<course.length; i++) {
            for(int k=0; k<orders.length; k++) {
                combination(0, 0, course[i], new boolean[orders[k].length()], k);
            }
        }
        // 이제 노드 리스트에 노드들이 꽉 들어았을 것이다. 그럼 카우트가 큰 순으로, 카운트가 같다면 문자열이 작은 순으로 정렬한다.
        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.count == o2.count)
                    return o1.value.length() - o2.value.length();
                return o2.count - o1.count;
            }
        });

        List<String> result = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Node prev = nodes.get(0);
        for(int i=0; i<nodes.size(); i++) {
            if(prev.value.length() == nodes.get(i).value.length()) {
                pq.offer(nodes.get(i));
            } else {
                // 길이가 달라지면 pq를 초기화하고 pq에서 값이 큰 녀석들을 새로운 리스트로 옮겨야 한다.
                if(!pq.isEmpty()) {
                    int tempPrev = pq.peek().count;
                    while(!pq.isEmpty() && pq.peek().count == tempPrev) {
                        Node poll = pq.poll();
                        result.add(poll.value);
                    }
                    pq = new PriorityQueue<>();
                    pq.offer(nodes.get(i));
                }
                prev = nodes.get(i);
            }
        }

        if(!pq.isEmpty()) {
            int tempPrev = pq.peek().count;
            while (!pq.isEmpty() && pq.peek().count == tempPrev) {
                Node poll = pq.poll();
                result.add(poll.value);
            }
        }

        Collections.sort(result);
        String[] answer = new String[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void combination(int start, int depth, int size, boolean[] flag, int subject_id) {
        if(size == depth) {
            String temp = "";
            for(Character element : list) {
                temp += element;
            }
            if(!set.contains(temp)) {
                set.add(temp);
                check(temp, subject_id);
            }
            return;
        }

        for(int i=start; i<orders_static[subject_id].length(); i++) {
            if(!flag[i]) {
                flag[i] = true;
                list.add(orders_static[subject_id].charAt(i));
                combination(i, depth+1, size, flag, subject_id);
                list.remove(list.size() - 1);
                flag[i] = false;
            }
        }
    }

    // 만들어낸 조합을 다른 메뉴들이 포함하고 있는지 확인한다.
    public static void check(String combi, int subject_id) {
        // 중요. count 는 1부터 시작
        int count = 1;
        boolean flag;
        for(int i=0; i<orders_static.length; i++) {
            if(i == subject_id)
                continue;

            flag = false;
            for(int k=0; k<combi.length(); k++) {
                if(!orders_static[i].contains(String.valueOf(combi.charAt(k)))) {
                    flag = true;
                    break;
                }
            }
            // 루프가 끝날 동안 flag가 바뀌지 않았다면 combi의 모든 문자가 orders_static 안에 포함된다는 뜻이다.
            // 그럼 count를 하나 추가한다.
            if(!flag)
                count++;
        }

        // count를 구했고, 1차적으로 리스트에 담아준다.
        // 노드를 만들고, 카운트 순으로 먼저 정렬. 카운트가 같다면 문자열의 길이가 짧은 순으로 정렬.
        if(count >= 2) {
            nodes.add(new Node(combi, count));
        }
    }


    // 정렬을 여러 번 수행해야 하므로 여기에 comparable을 구현하지는 않겠다.
//    static class Node {
//        String value;
//        int count;
//
//        Node(String value, int count) {
//            this.value = value;
//            this.count = count;
//        }
//    }

    static class Node implements Comparable<Node>{
        String value;
        int count;

        Node(String value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return o.count - this.count;
        }
    }

//    static boolean[] combination_flag;
//    static List<Character> list;
//    static String target;
//    static Set<String> set = new HashSet<>();
//    public static void main(String[] args) throws IOException {
//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course = {2,3,5};
////        String[] result = solution(orders, course);
////        for(String element : result) {
////            System.out.print(element + " ");
////        }
//    }

//    static String[] solution(String[] orders, int[] course) {
//        PriorityQueue<Node> pq;
//        List<String> resultList = new ArrayList<>();
//        int temp;
//        for (int k = 0; k < course.length; k++) {
//            pq = new PriorityQueue<>();
//            for (int i = 0; i < orders.length; i++) {
//                list = new ArrayList<>();
//                combination_flag = new boolean[orders[i].length()];
//                combination(course[k], 0, orders[i], 0);
//                if(!set.contains(target)) {
//                    set.add(target);
//                    temp = 1;
//                    for (int j = 0; j < orders.length; j++) {
//                        if (i == j) {
//                            continue;
//                        }
//                        temp += check(target, orders[j]);
//                    }
//                    if (temp >= 2) {
//                        pq.offer(new Node(target, temp));
//                    }
//                }
//            }
//            // 지금까지 우선순위 큐에 저장했던 값을 빼서 리스트에 추가해준다.
//            if(!pq.isEmpty()) {
//                int prev = pq.peek().count;
//                while(!pq.isEmpty() && pq.peek().count == prev) {
//                    Node poll = pq.poll();
//                    resultList.add(poll.value);
//                    prev = poll.count;
//                }
//            }
//        }
//
//        Collections.sort(resultList);
//        String[] result = new String[resultList.size()];
//        for(int i=0; i<resultList.size(); i++) {
//            result[i] = resultList.get(i);
//        }
//
//        return result;
//    }
//
//    static int check(String target, String subject) {
//
//        for (int i = 0; i < target.length(); i++) {
//            if (!subject.contains(String.valueOf(target.charAt(i)))) {
//                return 0;
//            }
//        }
//        return 1;
//    }
//
//    static void combination(int size, int depth, String object, int start) {
//        // 여기서 목표하는 조합을 만든 다음 다른 메뉴들이 해당 조합을 포함하는지 확인한다.
//        if (depth == size) {
//            String new_target = "";
//            for (Character element : list) {
//                new_target += element;
//            }
//            target = new_target;
//            return;
//        }
//
//        for (int i = start; i < object.length(); i++) {
//            if (!combination_flag[i]) {
//                combination_flag[i] = true;
//                list.add(object.charAt(i));
//                combination(size, depth + 1, object, i);
//                list.remove(list.size() - 1);
//                combination_flag[i] = false;
//            }
//        }
//    }
//
//    static class Node implements Comparable<Node>{
//        String value;
//        int count;
//        Node(String value, int count) {
//            this.value = value;
//            this.count = count;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return o.count - this.count;
//        }
//    }
}
