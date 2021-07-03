package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Le_Petit_Prince {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int MinimalWay = 0;
        int departPosX, departPosY, finPosX, finPosY;
        int CircleNum, CircleX, CircleY, CircleR;
        int CirclePow, Circle_Depart_Pow,   Circle_Fin_Pow;

        while(testCase > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 출발점과 도착점
            departPosX = Integer.parseInt(st.nextToken());
            departPosY = Integer.parseInt(st.nextToken());
            finPosX = Integer.parseInt(st.nextToken());
            finPosY = Integer.parseInt(st.nextToken());

            //행성계의 개수

            CircleNum = Integer.parseInt(br.readLine());
            while(CircleNum > 0) {
                // 행성의 중심좌표와 반지름
                StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
                CircleX = Integer.parseInt(st1.nextToken());
                CircleY = Integer.parseInt(st1.nextToken());
                CircleR = Integer.parseInt(st1.nextToken());

                //출발점과 도착점을 행성의 중심까지의 거리와 반지름으로 비교
                CirclePow = (int)Math.pow(CircleR, 2);
                Circle_Depart_Pow = (int)(Math.pow((CircleX - departPosX),2) + Math.pow((CircleY - departPosY),2));
                Circle_Fin_Pow = (int)(Math.pow((CircleX - finPosX),2) + Math.pow((CircleY - finPosY),2));
                // 둘 다 원 안에 있는 경우 행성계를 통과할 필요가 없다.
                if(Circle_Depart_Pow < CirclePow && Circle_Fin_Pow < CirclePow){
                    CircleNum--;
                    continue;
                }
                // 출발점과 원의 중심까지의 거리가 반지름보다 작다면 나가면서 행성계를 통과해야 한다.
                else if(Circle_Depart_Pow < CirclePow){
                    MinimalWay++;
                }
                else if(Circle_Fin_Pow < CirclePow){
                    MinimalWay++;
                }
                CircleNum--;
            }
            System.out.println(MinimalWay);
            MinimalWay = 0;
            testCase--;
        }
    }
}
