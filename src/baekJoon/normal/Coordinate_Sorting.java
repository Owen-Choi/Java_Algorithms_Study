package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Coordinate_Sorting {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] arr = new Point[N];

        while(N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[arr.length - N--] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) System.out.println(arr[i].toString());
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point() {}

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x < o.x) return 1;
            else if(this.x == o.x) {
                if(this.y <= o.y) return 1;
            }

            return -1;
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }

    }
}
