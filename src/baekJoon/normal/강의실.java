package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 강의실 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Lecture> lectures = new PriorityQueue<>();
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            lectures.add(new Lecture(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        rooms.offer(lectures.poll().end);
        while(!lectures.isEmpty()) {
            Lecture poll = lectures.poll();
            if(rooms.peek() <= poll.start) {
                rooms.poll();
                rooms.offer(poll.end);
            } else {
                rooms.offer(poll.end);
            }
        }
        System.out.println(rooms.size());
    }

    static class Lecture implements Comparable<Lecture>{
        int num;
        int start;
        int end;

        Lecture(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if(this.start == o.start) {
                // TODO 종료 시간이 빠른 순
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
