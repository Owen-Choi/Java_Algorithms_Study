package Algorithms_Class;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Term_project_Sketch {
    static String url = "jdbc:mysql://localhost:3306/Alg_term";
    static String userName = "root";
    static String password = "12345";
    static int userNum;
    static user[] users;
    public static void main(String[] args) throws Exception {
        // mysql 서버와 연결. 이 connection을 통해 쿼리 보내고 결과 받음
        //Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, userName, password);
        //Statement statement = connection.createStatement();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Enter the number of user : ");
        userNum = Integer.parseInt(br.readLine());
        users = new user[userNum];
        for(int i=0; i<userNum; i++) {
            System.out.println("Please Enter the location of user " + i);
            String tempName = br.readLine();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM station_info WHERE Name = ?");
            statement.setString(1, tempName);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                String tempLine =resultSet.getString(1);
                String tn = resultSet.getString(2);
                float lat = resultSet.getFloat(3);
                float lon = resultSet.getFloat(4);
                boolean fin = resultSet.getBoolean(5);
                System.out.println(tempLine + " " + tn + " " + lat + " " + lon + " " + fin);
            }
        }
    }
    // 역간 이동에 대한 클래스. 호선정보, 출발역, 도착역, 거리, 종착역 여부를 정보로 갖는다.
    static class Station_Move {
        String Line;
        String Station_name;
        String Next_station;
        float distance;
        public Station_Move(String Line, String Station_name, String Next_station, float distance) {
            this.Line = Line;
            this.Station_name = Station_name;
            this.Next_station = Next_station;
            this.distance = distance;
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
        boolean Is_Final;
        public Station_info(String Line_Info, String Station_name, float x, float y, boolean Is_Final) {
            this.Line_Info = Line_Info;
            this.Station_name = Station_name;
            this.x = x;
            this.y = y;
            this.Is_Final = Is_Final;
        }
    }
}

