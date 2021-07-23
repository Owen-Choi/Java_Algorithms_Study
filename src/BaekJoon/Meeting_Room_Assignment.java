package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1931
public class Meeting_Room_Assignment {
    static int RoomCount;
    static Integer[] MR;
    static int MeetingCount = 1;
    static int Min = Integer.MAX_VALUE;
    static int Max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        RoomCount = Integer.parseInt(br.readLine());
        MR = new Integer[RoomCount + 2];
        int StartTime;
        int EndTime;
        for(int i=0; i<RoomCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StartTime = Integer.parseInt(st.nextToken());
            EndTime = Integer.parseInt(st.nextToken());
            Min = Math.min(Min, EndTime);
            Max = Math.max(Max, EndTime);
            if(MR[StartTime] != null){
                MR[StartTime] = Math.min(MR[StartTime], EndTime);
            }
            else
                MR[StartTime] = EndTime;
        }
        for(int i = Min; i<Max;){
            if(MR[i] == null)
                i++;
            else {
                MeetingCount++;
                i = MR[i];
            }
        }
        System.out.println(MeetingCount);
    }
}
