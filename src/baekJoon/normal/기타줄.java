package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 기타줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n,m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int six, each, minSix, minEach;
        minSix = minEach = Integer.MAX_VALUE;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            six = Integer.parseInt(st.nextToken());
            each = Integer.parseInt(st.nextToken());
            minSix = Math.min(minSix, six);
            minEach = Math.min(minEach, each);
        }
        if(minEach * 6 < minSix) {
            minSix = minEach * 6;
        }
        int result1 = minSix * (n / 6) + minEach * (n % 6);
        int result2 = minSix * (n / 6 + 1);
        System.out.println(Math.min(result1, result2));
    }
}
