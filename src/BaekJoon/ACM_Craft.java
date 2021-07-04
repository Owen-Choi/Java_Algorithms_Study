package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACM_Craft {

    static class Node{
        private int data;
        private Node next;
        private boolean check;
        public Node(int data){
            this.data = data;
        }
        public Node(){
        }
    }

    public static void main(String[] args) throws IOException {
        int testCase;   int BuildingCount;  int RuleCount;  int i = 0;
        int[] buildTime;    int RequiredBuilding;   int TargetBuilding; int FinalBuilding = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node[] table = null;
        testCase = Integer.parseInt(br.readLine());
        while(testCase > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            BuildingCount = Integer.parseInt(st.nextToken());
            // 체인 해쉬법을 이용하기 위해 table 선언
            table = new Node[BuildingCount];
            buildTime = new int[BuildingCount];
            RuleCount = Integer.parseInt(st.nextToken());
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            // 빌딩 건축 시간 입력받음
            while(i < BuildingCount){
                buildTime[i] = Integer.parseInt(st1.nextToken());
            }
            // 룰 입력받음
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            while(RuleCount > 0){
                RequiredBuilding = Integer.parseInt(st2.nextToken());
                TargetBuilding = Integer.parseInt(st2.nextToken());
                Node First = new Node(RequiredBuilding);
                Node Second = new Node(TargetBuilding);
                //체인 해쉬
                if(table[RequiredBuilding] == null) {
                    table[RequiredBuilding] = First;
                    table[RequiredBuilding].next = Second;
                }
                else{
                    Node ptr = table[RequiredBuilding];
                    while(ptr.next != null){
                        ptr = ptr.next;
                    }
                    ptr.next = Second;
                }
                RuleCount--;
            }
            FinalBuilding = Integer.parseInt(br.readLine());
            testCase--;
        }

        Node CurrentBuilding = new Node();
        while(CurrentBuilding.data != FinalBuilding){
            for(int k = 0; k < FinalBuilding; k++){
                if(table[k].next == null)
                    continue;
                else{
                    Node ptr = table[k];
                    while(ptr != null){

                    }
                }
            }
        }

    }
}
