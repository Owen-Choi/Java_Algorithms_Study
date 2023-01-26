package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 1931
public class Meeting_Room_Assignment {
    static int RoomCount;
    static int[][] MR;
    static int MeetingCount = 0;
    static int Min = Integer.MAX_VALUE;
    static int Max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        RoomCount = Integer.parseInt(br.readLine());
        MR = new int[RoomCount][2];
        for(int i=0; i<RoomCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            MR[i][0] = Integer.parseInt(st.nextToken());
            MR[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(MR, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });
        int EndTime = 0;
        for(int i=0; i<RoomCount; i++){
            if(EndTime <= MR[i][0]){
                EndTime = MR[i][1];
                MeetingCount++;
            }
        }
        System.out.println(MeetingCount);
    }
}
