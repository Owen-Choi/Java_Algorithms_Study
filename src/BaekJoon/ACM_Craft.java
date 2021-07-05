package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.NoSuchElementException;
public class ACM_Craft {
    static int[] time;
    static int BuildingNum;
    public static void main(String[] args) throws IOException, NoSuchElementException {
        int testCase;
        int RuleNum;
        int TargetBuilding = 0;
        int[] vector;
        int j = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BuildingNum = Integer.parseInt(st.nextToken());
        RuleNum = Integer.parseInt(st.nextToken());

        for(int i=0; i<testCase; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for(int k=1; k<=BuildingNum; k++)
                time[k] = Integer.parseInt(st1.nextToken());

            vector = new int[BuildingNum + 1];
            time = new int[BuildingNum + 1];
            List<List<Integer>> list = new ArrayList<List<Integer>>();

            for(int k=0; k<BuildingNum + 1; k++)
                list.add(new ArrayList<Integer>());

            while(j < RuleNum){
                StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

                int c1 = Integer.parseInt(st2.nextToken());
                int c2 = Integer.parseInt(st2.nextToken());

                list.get(c1).add(c2);
                vector[c2]++;
                j++;
            }
            TargetBuilding = Integer.parseInt(br.readLine());
            calc(vector, list, TargetBuilding);
        }
    }
    static void calc(int[] vector, List<List<Integer>>list,int TargetBuilding){
        Queue<Integer> queue = new LinkedList<Integer>();
        int node;
        int[] result = new int[BuildingNum + 1];        //왜 1을 더해주지?
        for(int i=1; i<=BuildingNum; i++){
            result[i] = time[i];

            if(vector[i] == 0)
                queue.offer(i);
        }

        while(!queue.isEmpty()){
            node = queue.poll();
            for(int temp : list.get(node)){
                result[temp] = Math.max(result[temp], result[node] + time[temp]);
                vector[temp]--;

                if(vector[temp] == 0)
                    queue.offer(temp);
            }
        }

        System.out.println(result[TargetBuilding]);
    }
}