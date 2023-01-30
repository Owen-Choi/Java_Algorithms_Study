package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Returning_to_Farm {

    static int n;
    static int [][] values;
    static int [][] sumVal;
    static List<Integer> sum1 = new ArrayList<>();
    static List<Integer> sum2 = new ArrayList<>();
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        values = new int[n][n];
        sumVal = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int k=0; k<n; k++) {
                values[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        // 오른쪽 위, 왼쪽 아래부터
        for(int i=0; i<n-1; i++) {
            for(int k=0; k<n-1; k++) {

            }
        }

    }

    public static void rightDown(int X, int Y) {
        for(int x=0; x<X; x++) {
            sum = 0;
            // y값의 증가도 아래 코드로 함께 고려할 수 있다.
            for(int y = 0; y<Y; y++) {

            }
        }
    }
}
