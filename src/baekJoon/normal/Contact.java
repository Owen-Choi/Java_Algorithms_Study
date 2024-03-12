package baekJoon.normal;

import java.util.*;
import java.io.*;

public class Contact {
    public static void main(String[] args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String regex = "(100+1+|01)+";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            if(br.readLine().matches(regex)) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
