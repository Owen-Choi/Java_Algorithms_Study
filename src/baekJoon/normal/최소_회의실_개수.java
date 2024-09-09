package baekJoon.normal;

import java.util.*;
import java.io.*;

// 4% 오답.
public class 최소_회의실_개수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Meeting> meeting = new PriorityQueue<>();
        PriorityQueue<Integer> room = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            meeting.offer(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        room.offer(meeting.poll().end);
        Meeting poll;
        while(!meeting.isEmpty()) {
            poll = meeting.poll();
            // 새로운 회의실이 필요한 상황
            if(room.peek() > poll.start) {
                room.offer(poll.end);
            } else {
                room.poll();
                room.offer(poll.end);
            }
        }
        System.out.println(room.size());
    }

    // 시작 시간으로 정렬, 시작 시간이 같다면 끝나는 시간으로 정렬
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
