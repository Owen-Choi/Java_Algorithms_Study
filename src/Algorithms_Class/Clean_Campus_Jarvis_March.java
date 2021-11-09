package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Clean_Campus_Jarvis_March {
    static int testCase;
    static Fresh[] fresh;
    static int student_Num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        float tempX, tempY;
        while(testCase --> 0) {
            //blank
            student_Num = Integer.parseInt(br.readLine());
            fresh = new Fresh[student_Num];

            for(int i=0; i<student_Num; i++) {
                st = new StringTokenizer(br.readLine()," ");
                tempX = Float.parseFloat(st.nextToken());
                tempY = Float.parseFloat(st.nextToken());
                fresh[i] = new Fresh(tempX, tempY);
            }
            // 입력부 종료
        }
        Solve();
    }
    static class Fresh {
        float x, y;
        boolean tied;
        public Fresh(float x, float y) {
            this.x = x;
            this.y = y;
            tied = false;
        }
    }

    static float computeAngle(Fresh Pivot, Fresh other) {
        float Dx, Dy;
        float Angle;
        Dx = other.x - Pivot.x;
        Dy = other.y - Pivot.y;
        // Dx와 Dy가 0이라는 것은 두 점이 일치한다는 것이고 이 경우 각도는 0이 된다.
        if(Dx == 0 && Dy == 0) Angle = 0;
        else {
            Angle = Math.abs(Dy) / (Math.abs(Dx) + Math.abs(Dy));
            // Dx가 음수이고, Dy가 양수이면 점은 2사분면에 위치한다.
            if(Dx < 0 && Dy >= 0) {
                Angle = 2 - Angle;
            }
            else if(Dx <= 0 && Dy < 0) {
                Angle = 2 + Angle;
            }
            else if(Dx > 0 && Dy < 0) {
                Angle = 4 - Angle;
            }
        }
        return Angle * 90.0f;
    }
    static void Solve() {
        float init_x, init_y, tempAngle;
        init_x = init_y = 0.0f;
        int MinIndex = 0;
        Queue<Fresh> queue = new LinkedList<>();
        queue.add(new Fresh(init_x, init_y));
        Fresh Pivot, MinFresh = null;
        float Min = Float.MAX_VALUE;
        while(!queue.isEmpty()) {
            Pivot = queue.poll();
            Min = Float.MAX_VALUE;
            for (int i = 0; i < student_Num; i++) {
                if (!fresh[i].tied) {
                    tempAngle = computeAngle(Pivot, fresh[i]);
                    if(tempAngle < Min) {
                        MinFresh = fresh[i];
                        MinIndex = i;
                    }
                }
            }
            fresh[MinIndex].tied = true;
            queue.add(MinFresh);
        }
    }
}
