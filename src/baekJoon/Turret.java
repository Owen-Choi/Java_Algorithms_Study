package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Turret {
    static int calcPosition(int X1, int Y1, int Dist1, int X2, int Y2, int Dist2){
        //두 좌표 사이의 거리의 제곱
        int distance_Pow = (int)Math.pow((X1-X2),2) + (int)Math.pow((Y1-Y2),2);
        // 두 좌표의 값이 같고 원의 반지름도 같은 경우 (가능성 무한)
        if(X1 == X2 && Y1 == Y2 && Dist1 == Dist2)
            return -1;
        //내접
        else if(distance_Pow == Math.pow((Dist2 - Dist1),2))
            return 1;
        // 한 원이 다른 원을 포함 (가능성 X)
        else if(distance_Pow < Math.pow((Dist2 - Dist1),2))
            return 0;
        //한 점에서 만나는 경우
        else if(distance_Pow == Math.pow((Dist2 + Dist1),2))
            return 1;
        //접점이 없는 경우
        else if(distance_Pow > Math.pow((Dist1 + Dist2),2))
            return 0;
        else
            return 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i;  int Xaxis1;  int Yaxis1;    int Xaxis2; int Yaxis2; int dist1;  int dist2;
        // testcase 먼저 읽혀주기
        int testCase = Integer.parseInt(br.readLine());
        for(i = 0; i<testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Xaxis1 = Integer.parseInt(st.nextToken());
            Yaxis1 = Integer.parseInt(st.nextToken());
            dist1 = Integer.parseInt(st.nextToken());
            Xaxis2 = Integer.parseInt(st.nextToken());
            Yaxis2 = Integer.parseInt(st.nextToken());
            dist2 = Integer.parseInt(st.nextToken());

            System.out.println(calcPosition(Xaxis1, Yaxis1, dist1, Xaxis2, Yaxis2, dist2));
        }

    }
}
