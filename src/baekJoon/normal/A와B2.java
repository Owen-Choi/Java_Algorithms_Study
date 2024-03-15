package baekJoon.normal;

import java.io.*;

public class A와B2 {

    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b= br.readLine();
        // dfs
        dfs(new StringBuilder(b), new StringBuilder(a));
        System.out.println(flag ? 1 : 0);
    }

    // 역으로 탐색한다.
    static void dfs(StringBuilder value, StringBuilder target) {
        if(value.length() == target.length()) {
            if(value.toString().equals(target.toString()))
                flag = true;
        } else {
            if(value.charAt(value.length() - 1) == 'A') {
                // 마지막에 A가 존재하면 A를 뗀 경우를 탐색한다.
                dfs(new StringBuilder(value.substring(0,value.length()-1)), target);
            }
            if(value.charAt(0) == 'B') {
                // 처음에 B가 존재한다면 뒤집은 뒤 B를 뗀 경우를 탐색한다.
                dfs(new StringBuilder(value.reverse().substring(0,value.length()-1)), target);
            }
        }
    }
}
