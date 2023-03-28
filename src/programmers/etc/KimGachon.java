package programmers.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class KimGachon {
    static int t, book1C, book2C;
    static int[] book2;
    static HashSet<Integer> book1 = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        while(t --> 0) {
        book1C = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<book1C; i++) {
            book1.add(Integer.parseInt(st.nextToken()));
        }
        book2C = Integer.parseInt(br.readLine());
        book2 = new int[book2C];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<book2C; i++) {
            book2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<book2C; i++) {
            if(book1.contains(book2[i])) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    }
}
