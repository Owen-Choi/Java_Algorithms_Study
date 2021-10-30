package Algorithms_Class;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Term_project_Sketch {
    public static void main(String[] args) throws IOException {

    }
    static class Station {
        String Line;
        String Station_name;
        String Next_station;
        float distance;
        boolean Is_final;
        public Station(String Line, String Station_name, String Next_station, float distance, boolean Is_final) {
            this.Line = Line;
            this.Station_name = Station_name;
            this.Next_station = Next_station;
            this.distance = distance;
            this.Is_final = Is_final;
        }
    }
}

