package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 14501번
public class Leaving_Company {
    static int Input;
    static ArrayList<Node>[] list;
    static Integer [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        list = new ArrayList[Input];
        // ArrayList
        for(int i=0; i<Input; i++)
            list[i] = new ArrayList<Node>();
        dp = new Integer[Input+1];
        dp[0] = 0;
        for(int i=0; i<Input; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list[i].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }
    static int recur(int index){
        if(dp[index] == null){

        }
        return dp[index];
    }
    private static class Node {
        int End_Date;
        int Value;
        private Node(int End_Date, int Value){
            this.End_Date = End_Date;
            this.Value = Value;
        }
    }
}
