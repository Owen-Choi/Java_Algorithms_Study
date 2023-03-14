package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SelfFire {

    static int N;
    static int[][] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][3];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            data[i][0] = Integer.parseInt(st.nextToken()) + (i + 1);
            data[i][1] = Integer.parseInt(st.nextToken());
            data[i][2] = i+1;
        }
        Arrays.sort(data, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int result = 0;
        int currentDate = 0;
        boolean[] flag = new boolean[N + 2];
        for(int i=0; i<data.length; i++) {
            if(data[i][0] <= N + 1 && !flag[data[i][0]] && data[i][2] >= currentDate) {
                currentDate = data[i][0];
                System.out.println(currentDate);
                result += data[i][1];
                flag[data[i][0]] = true;
            }
        }
        System.out.println(result);
    }
}
