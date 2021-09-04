package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coordinate_Sorting_2 {
    static int PointNum;
    static Point[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PointNum = Integer.parseInt(br.readLine());
        arr = new Point[PointNum];
        StringTokenizer st;
        for(int i=0; i<PointNum; i++) {
            st = new StringTokenizer(br.readLine()," ");
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        for(int i=0; i<PointNum; i++)
            System.out.println(arr[i].toString());
    }

    static class Point implements Comparable<Point>{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        // 음수 또는 0인 경우에는 두 객체의 자리가 유지
        // 양수인 경우 두 객체의 자리가 바뀜.
        public int compareTo(Point p) {
            if(this.y < p.y)
                return -1;
            else if(this.y == p.y) {
                if(this.x <= p.x )
                    return -1;
            }
            return 1;
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }
}
