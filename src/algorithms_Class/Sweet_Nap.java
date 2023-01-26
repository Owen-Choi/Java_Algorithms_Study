package algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sweet_Nap {
    static int TestCase;
    static int[][] arr;
    static int N;
    static final int START = 0;
    static final int FINISH = 1;
    static int MAX = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TestCase = Integer.parseInt(br.readLine());
        N = TestCase;
        arr = new int[TestCase][2];
        StringTokenizer st;
        StringTokenizer stt;
        String Start, Finish;
        int i = 0;
        while(TestCase --> 0) {
            st = new StringTokenizer(br.readLine()," ");
            Start = st.nextToken();
            Finish = st.nextToken();
            stt = new StringTokenizer(Start, ":");
            arr[i][START] = Integer.parseInt(stt.nextToken()) * 100 + Integer.parseInt(stt.nextToken());
            stt = new StringTokenizer(Finish, ":");
            arr[i][FINISH] = Integer.parseInt(stt.nextToken()) * 100 + Integer.parseInt(stt.nextToken());
            i++;
        }
        calc();
        System.out.println(MAX / 100 + " : " + MAX % 100);
    }
    static void calc() {
        // 주어진 입력에서는 시간이 겹치는 경우가 없고, 오름차순으로 입력이 주어지는 것 같다.
        // 만약 겹치는 시간이 생기거나 입력이 뒤죽박죽이라면 Arrays.sort()로 끝나는 시간을 기준으로 정렬해준 뒤 greedy 알고리즘을 써야할 것.
        for(int i=0; i<N-1; i++) {
            if((arr[i][FINISH] % 100) > arr[i+1][START] % 100){
                arr[i+1][START] -= 100;
                arr[i+1][START] += 60;
            }
            MAX = Math.max(arr[i+1][START] - arr[i][FINISH], MAX);
        }
    }
}
