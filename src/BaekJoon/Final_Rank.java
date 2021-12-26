package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 위상정렬 활용
// 이게 어딜 봐서 위상정렬이지?
public class Final_Rank {
    static int testCase, teamNum;
    static int[] t;
    static boolean[][] changed;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        int change;
        while(testCase --> 0) {
            teamNum = Integer.parseInt(br.readLine());
            t = new int[teamNum+1];
            list = new ArrayList[teamNum + 1];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=1; i<=teamNum; i++) {
                int temp1 = Integer.parseInt(st.nextToken());
                list[i] = new ArrayList<>();
                t[temp1] = i;
            }
            change = Integer.parseInt(br.readLine());
            changed = new boolean[teamNum + 1][teamNum + 1];
            int temp1, temp2;
            for(int i=0; i<change; i++) {
                st = new StringTokenizer(br.readLine()," ");
                temp1 = Integer.parseInt(st.nextToken());
                temp2 = Integer.parseInt(st.nextToken());
                changed[temp1][temp2] = true;
                changed[temp2][temp1] = true;
            }
            // 예시 1번에서 답이 5 3 2 4 1인 이유는 2 4, 3 4 가
            // 차례로 있지만 2 3은 없기 떄문에 2는 여전히 3보다 뒤에 존재한다.
            Make_Edge();
        }
    }
    static void Make_Edge() {
        // 이 메서드에서는 변화가 있는 팀을 기준으로 간선을 만들 것임.
        for(int i=1; i<=teamNum; i++) {
            for(int k=1; k<=teamNum; k++) {
                if(changed[i][k]) {
                   // 순위에 변동이 있다면 어떻게 해야하지?
                   // 일단 2 4, 3 4의 4처럼 겹치는 항목이 있는 지 확인해야하나?
                }
            }
        }
    }
    static void Topoloy() {
        // 위상 정렬에서 팀을 선택하는 기준은 작년의 순위로 한다.

    }
}
