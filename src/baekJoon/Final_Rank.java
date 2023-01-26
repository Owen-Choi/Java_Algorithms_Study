package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 위상정렬 활용
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
            changed = new boolean[teamNum + 1][teamNum + 1];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=1; i<=teamNum; i++) {
                int temp1 = Integer.parseInt(st.nextToken());
                list[i] = new ArrayList<>();
                t[temp1] = i;
                for(int k=1; k<=teamNum; k++) {
                    // 자신보다 순위가 낮은 팀은 true로 둔다.
                    if(k != temp1 && !changed[k][temp1])
                        changed[temp1][k] = true;
                }
            }
            change = Integer.parseInt(br.readLine());
            int temp1, temp2;
            for(int i=0; i<change; i++) {
                st = new StringTokenizer(br.readLine()," ");
                temp1 = Integer.parseInt(st.nextToken());
                temp2 = Integer.parseInt(st.nextToken());
                Ranking_Change(temp1, temp2);
            }
            Topoloy();
            System.out.println();
        }
    }
    // 이름 그대로 순위를 바꾸는 함수
    static void Ranking_Change(int temp1, int temp2) {
        if(!changed[temp1][temp2]) {
            changed[temp1][temp2] = true;
            changed[temp2][temp1] = false;
            t[temp1]--;
            t[temp2]++;
        }
        else {
            changed[temp1][temp2] = false;
            changed[temp2][temp1] = true;
            t[temp1]++;
            t[temp2]--;
        }
    }
    static void Topoloy() {
        // 위상 정렬에서 팀을 선택하는 기준은 작년의 순위로 한다.
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[teamNum + 1];
        Arrays.fill(result, -333);
        for(int i=1; i<=teamNum; i++) {
            if(t[i] == 0)
                queue.offer(i);
        }
        int temp, counter = 0;
        for(int i=1; i<=teamNum; i++) {
            if(queue.size() == 0) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            if(queue.size() > 1) {
                System.out.println("?");
                return;
            }
            temp = queue.poll();
            result[counter++] = temp;
            for(int j=1; j<=teamNum; j++) {
                if(changed[temp][j]) {
                    changed[temp][j] = false;
                    if(--t[j] == 0)
                        queue.offer(j);
                }
            }
        }
        // 출력
        for(int i=0; i<teamNum; i++) {
            if(result[i] == -333)
                continue;
            else
                System.out.print(result[i] + " ");
        }
    }
}
