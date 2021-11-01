package Algorithms_Class;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Term_project_Sketch {
    public static void main(String[] args) throws IOException {

    }
    // 역간 이동에 대한 클래스. 호선정보, 출발역, 도착역, 거리, 종착역 여부를 정보로 갖는다.
    static class Station_Move {
        String Line;
        String Station_name;
        String Next_station;
        float distance;
        boolean Is_final;
        public Station_Move(String Line, String Station_name, String Next_station, float distance, boolean Is_final) {
            this.Line = Line;
            this.Station_name = Station_name;
            this.Next_station = Next_station;
            this.distance = distance;
            this.Is_final = Is_final;
        }
    }
    // user 클래스. 처음 출발하는 역 노드, 누적 거리값, 여태 지나온 역들을 담을 queue를 가진다.
    static class user {
        Station_info Current_station;
        Queue<Station_info> Node_queue;
        float Cumulated_dist;
        public user(Station_info Current_station, float Cumulated_dist) {
            this.Current_station = Current_station;
            this.Cumulated_dist = Cumulated_dist;
            Node_queue = new LinkedList<>();
        }
    }
    // 역 정보 클래스. 역의 이름과 좌표값을 가진다.
    static class Station_info {
        String Line_Info;
        String Station_name;
        float x, y;
        public Station_info(String Line_Info, String Station_name, float x, float y) {
            this.Line_Info = Line_Info;
            this.Station_name = Station_name;
            this.x = x;
            this.y = y;
        }
    }
}

