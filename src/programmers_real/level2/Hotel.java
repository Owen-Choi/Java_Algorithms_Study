package programmers_real.level2;

import java.util.*;

public class Hotel {

    public static void main(String[] args) {
        String[][] times
                = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(new HotelSolution().solution(times));
    }
}

class HotelSolution {
    public int solution(String[][] book_time) {
        int answer = 0;
        List<Node> list = new ArrayList<>();
        for(int i=0; i< book_time.length; i++) {
            // 문자로 된 시간을 정수로 변환
            int hour, minute, start, end;
            String[] startTime = book_time[i][0].split(":");
            hour = Integer.parseInt(startTime[0]);
            minute = Integer.parseInt(startTime[1]);
            start = (hour * 60) + minute;

            String[] endTime = book_time[i][1].split(":");
            hour = Integer.parseInt(endTime[0]);
            minute = Integer.parseInt(endTime[1]);
            end = (hour * 60) + minute + 10;

            list.add(new Node(start, end));
        }

        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        List<Node> result = new ArrayList<>();
        result.add(list.get(0));
       for(int i=1; i < list.size(); i++) {
           int min = Integer.MAX_VALUE;
           int minIndex = 0;
           for(int k=0; k < result.size(); k++) {
               // 끝나는 시간이 최소인 값을 찾는다.
               if(min > result.get(k).end) {
                   min = result.get(k).end;
                   minIndex = k;
               }
           }
           if(min > list.get(i).start) {
               // 시작시간이 현재 대여중인 방들 중 끝나는 최소 시간보다 이르단 말은 방이 겹친다는 뜻.
               result.add(new Node(list.get(i).start, list.get(i).end));
           } else {
               // 그렇지 않다면 현재 대여중인 방 중 가장 끝나는 시간이 이른 방을 배정해줌. (어차피 끝났으니까)
               result.set(minIndex, new Node(list.get(i).start, list.get(i).end));
           }
       }
        return result.size();
    }
}

class Node {
    int start;
    int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
