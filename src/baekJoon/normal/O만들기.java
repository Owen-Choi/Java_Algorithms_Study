package baekJoon.normal;

import java.io.*;
import java.util.*;
public class O만들기 {

    static List<String> list;
    static String[] args = {"+", "-", " "};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc --> 0) {
            int input = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            dfs(1, new StringBuilder("1"), input);
            Collections.sort(list);
            for(String s : list) {
                sb.append(s);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int num, StringBuilder sb, int target) {
        if(num == target) {
            // 공백을 "" 로 치환
            calc(sb);
            return;
        } else {
            for(int i=0; i<3; i++) {
                dfs(num+1, new StringBuilder(sb).append(args[i]).append(num+1), target);
            }
        }
    }

    static void calc(StringBuilder sb) {
        String s = sb.toString().replaceAll(" ", "");
        StringTokenizer st = new StringTokenizer(s, "+|-", true);
        int number = Integer.parseInt(st.nextToken());
        while(st.hasMoreElements()) {
            String oper = st.nextToken();
            if(oper.equals("+")) {
                number += Integer.parseInt(st.nextToken());
            } else {
                number -= Integer.parseInt(st.nextToken());
            }
        }
        if(number == 0) {
            list.add(sb.append("\n").toString());
        }
    }
}
