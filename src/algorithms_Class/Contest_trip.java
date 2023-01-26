package algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Contest_trip {
    static int testCase, cityNum, ScheduleNum, tempNum;
    static String[] cityName;
    static ArrayList<Train>[] list;
    static ArrayList<tempTrain> templist;
    static int MinimumTime;
    static String From, To;
    static int[] dist;                  //기존의 dijkstra는 여기에 간선의 가중치가 들어가지만, 우리는 도착시간을 넣는다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        testCase = Integer.parseInt(br.readLine());
        int time;
        String city;
        while(testCase --> 0) {
            cityNum = Integer.parseInt(br.readLine());
            cityName = new String[cityNum];
            list = new ArrayList[cityNum];
            dist = new int[cityNum];
            for (int i = 0; i < cityNum; i++) {
                cityName[i] = br.readLine();
                list[i] = new ArrayList<>();
                dist[i] = Integer.MAX_VALUE;
            }
            ScheduleNum = Integer.parseInt(br.readLine());
            for(int i=0; i<ScheduleNum; i++) {
                tempNum = Integer.parseInt(br.readLine());
                templist = new ArrayList<>();
                for (int k = 0; k < tempNum; k++) {
                    st = new StringTokenizer(br.readLine(), " ");
                    time = Integer.parseInt(st.nextToken());
                    city = st.nextToken();
                    templist.add(new tempTrain(time, city));
                }
                String departCity, NextCity;
                int departTime, nextTime;
                for (int iter = 0; iter < templist.size() - 1; iter++) {
                    departCity = templist.get(iter).city;
                    NextCity = templist.get(iter + 1).city;
                    departTime = templist.get(iter).time;
                    nextTime = templist.get(iter + 1).time;
                    list[getIndex(departCity)].add(new Train(departTime, nextTime, departCity, NextCity));
                }
            }
                MinimumTime = Integer.parseInt(br.readLine());
                From = br.readLine();
                To = br.readLine();
                // Input ends ::
                for(int p=0; p<list[getIndex(From)].size(); p++) {
                    Solve(list[getIndex(From)].get(p));
                }
                if(dist[getIndex(To)] == Integer.MAX_VALUE)
                    System.out.println("No Connection");
                // + 출발지까지 출력해야 하지만 그건 C코드에서 하자.
                else
                    System.out.println("Arrival : " + dist[getIndex(To)] + " " + To);
            }
        }
    static void Solve(Train t) {
        dist[getIndex(t.Start)] = 0;
        PriorityQueue<Train> queue = new PriorityQueue<>(new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o1.Dest_time - o2.Dest_time;
            }
        });
        queue.add(t);
        Train tt;
        String tempDest;
        int DestTime;
        while(!queue.isEmpty()) {
            tt = queue.poll();
            if(dist[getIndex(tt.Finish)] < tt.Dest_time)
                continue;
            for(int i=0; i<list[getIndex(tt.Finish)].size(); i++) {
                tempDest = list[getIndex(tt.Finish)].get(i).Finish;
                DestTime = list[getIndex(tt.Finish)].get(i).Dest_time;
                if(dist[getIndex(tempDest)] > DestTime) {
                    dist[getIndex(tempDest)] = DestTime;
                    queue.add(tt);
                }
            }
        }
    }
    static class Train {
        int Start_time, Dest_time;
        String Start, Finish;
        public Train(int t, int e, String s, String f) {
            Start_time = t;
            Dest_time = e;
            Start = s;
            Finish = f;
        }
    }
    static class tempTrain {
        int time;
        String city;
        public tempTrain(int time, String city) {
            this.time = time;
            this.city = city;
        }
    }
    static int getIndex(String city) {
        for(int i=0; i<cityNum; i++) {
            if(cityName[i].equals(city))
                return i;
        }
        System.out.println("Cannot find any city :: this may cause some errors");
        return -1;
    }
}
