package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10942번, 펠린드롬?, 골드 4
public class Palindrome_QM {

    static int N;
    static int[] num;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sb.append(check(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1)).append('\n');
        }
        System.out.println(sb.toString());

    }

    public static int check(int S, int E) {
        if(S == E) {
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=S; i<=E; i++) {
            sb.append(num[i]);
        }
        String tmp = sb.toString();
        String firstHalf = tmp.substring(0, tmp.length() / 2);
        String lastHalf;
        if(tmp.length() % 2 != 0) {
            lastHalf = tmp.substring(tmp.length() / 2 + 1, tmp.length());
        } else {
            lastHalf = tmp.substring(tmp.length() / 2, tmp.length());
        }
        StringBuffer stringBuffer = new StringBuffer(lastHalf);
        String reverse = stringBuffer.reverse().toString();
        if(reverse.equals(firstHalf)) {
            return 1;
        }
        return 0;
    }
}
