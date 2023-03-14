package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class World_Travel {
    static int testCase, Vertex, Edge;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int From, To;
        while(testCase --> 0) {
            st = new StringTokenizer(br.readLine()," ");
            Vertex = Integer.parseInt(st.nextToken());
            Edge = Integer.parseInt(st.nextToken());
            arr = new int[Vertex + 1];
            for(int i=0; i<Edge; i++) {
                st = new StringTokenizer(br.readLine()," ");
                From = Integer.parseInt(st.nextToken());
                To = Integer.parseInt(st.nextToken());
                arr[From] = To;
                arr[To] = From;
            }
            sb.append(Vertex - 1).append('\n');
        }
        System.out.println(sb);
    }
}
