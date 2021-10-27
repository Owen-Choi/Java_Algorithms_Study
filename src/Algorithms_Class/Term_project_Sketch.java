package Algorithms_Class;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Term_project_Sketch {
    static String Line;
    static StationNode[][] SN;
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\oldst\\Desktop\\Node_Info.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String tempLine = null;
        StringTokenizer st;
        int LineNum = -1, StationNum = 0;
        SN = new StationNode[2][4];     //일단 임의로 호선 2개, 역 4개로 설정하였습니다.
        while((tempLine = br.readLine()) != null) {
            st = new StringTokenizer(tempLine);
            if(st.countTokens() == 1) {
                Line = st.nextToken();
                LineNum++;              //만약 입력에서 토큰의 개수가 하나라면, 즉 역의 정보가 아닌 호선의 정보가 들어온다면
                StationNum = 0;         // 호선의 인덱스를 하나 증가시키고 역의 인덱스를 0으로 다시 초기화
                continue;
            }
            SN[LineNum][StationNum++] = new StationNode(st.nextToken(),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<2; i++) {
            System.out.println();
            for(int k=0; k<4; k++) {
                System.out.print(SN[i][k].StationLine + " " + SN[i][k].StationNumber + " " + SN[i][k].value + " ");
            }
            System.out.println();
        }
    }
    static class StationNode {
        String StationLine;
        String CurrentStation;
        String DestStation;
        int value;
        public StationNode(String StationLine, String CurrentStation,String DestStation, int value) {
            this.StationLine = StationLine;
            this.CurrentStation = CurrentStation;
            this. DestStation = DestStation;
            this.value = value;
        }

    }
}
