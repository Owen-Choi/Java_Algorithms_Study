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
    static int [][] cache;
    static List<Integer> sum1 = new ArrayList<>();
    static List<Integer> sum2 = new ArrayList<>();
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        values = new int[n][n];
        cache = new int[n][n];
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
        for(int x=X+1; x<n; x++) {
            sum = 0;
            // y값의 증가도 아래 코드로 함께 고려할 수 있다.
            for(int y = Y + 1; y<n; y++) {
                // 일단 먼저 더해준다.
                sum += values[x][y];
                if(x == X) {
                    cache[x][y] = sum;
                } else {
                    cache[x][y] += cache[x-1][y] + sum;
                }
                sum2.add(cache[x][y]);
            }
        }
    }

    public static void leftUp(int X, int Y) {
        // TODO 위험 예상 구간
        for(int x=X; x>=0; x--) {
            sum = 0;
            for(int y=Y; y>=0; y--) {
                sum += values[x][y];
                if(x == X) {
                    cache[x][y] = sum;
                } else {
                    cache[x][y] = cache[x+1][y] + sum;
                }
                sum1.add(cache[x][y]);
            }
        }
    }

    public static void rightUp(int X, int Y) {
        for(int x=X + 1; x<n; x++) {
            sum = 0;
            for(int y=Y-1; y>=0; y--) {
                sum += cache[x][y];
                if(x == X) {
                    cache[x][y] = sum;
                } else {
                    cache[x][y] = cache[x-1][y] + sum;
                }
                sum2.add(cache[x][y]);
            }
        }
    }

    public static void leftDown(int X, int Y) {

    }
}
