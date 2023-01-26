package baekJoon;

import java.io.*;
import java.util.StringTokenizer;

// 9184번
public class Funny_Function_Execution {
    static int a,b,c;
    static Integer[][][] w = new Integer[102][102][102];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1)
                break;
            else{
                //System.out.println("w("+a+", "+b+", "+c+")" + " = "+recur(a,b,c));
                sb.append("w("+a+", "+b+", "+c+")"+" = "+recur(a,b,c)).append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int recur(int A, int B, int C){
        if(A <= 0 || B <= 0 || C <= 0)
            return 1;
        if(w[A][B][C] == null){
            if(A > 20 || B > 20 || C > 20)
                w[A][B][C] = recur(20, 20, 20);
            else if(A < B && B < C)
                w[A][B][C] = recur(A,B,C-1) + recur(A, B-1,C-1) - recur(A, B-1,C);
            else
                w[A][B][C] = recur(A-1, B, C) + recur(A-1, B-1, C) + recur(A-1, B, C-1) - recur(A-1, B-1, C-1);
        }
        return w[A][B][C];
    }
}
