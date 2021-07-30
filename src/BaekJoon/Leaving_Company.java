package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14501번
public class Leaving_Company {
    static int Input;
    static Node[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        arr = new Node[Input + 1];
        dp = new Integer[Input + 1];
        dp[0] = 0;
        arr[0] = new Node(0,0);
        for(int i=1; i<=Input; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        dp[1] = arr[1].Value;
        recur(Input);
        System.out.println(dp[Input]);
    }
    private static int recur(int index) {
        // 상담이 가능한 범위
        if(dp[index] == null) {
            if (index + arr[index].End_Date <= Input + 1 && index - arr[index].End_Date >= 0) {
                dp[index] = Math.max(recur(index - arr[index].End_Date) + arr[index].Value, recur(index - 1));
            } else {   //날짜가 초과되는 상담은 건너뜀
                recur(index - 1);
            }
        }
        return dp[index];
    }
    private static class Node{
        int End_Date;
        int Value;
        private Node(int End_Date, int Value){
            this.End_Date = End_Date;
            this.Value = Value;
        }
    }
}
