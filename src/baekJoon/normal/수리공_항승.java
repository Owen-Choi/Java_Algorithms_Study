package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 수리공_항승 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n,l;
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        // 크기 순으로 오름차순 정렬하고, 앞에서부터 순서대로 탐색하며 테이프의 길이로 커버할 수 있다면 다음 구멍으로 넘어가고,
        // 커버할 수 없다면 여태까지 지나온 구멍들을 매운 뒤 구멍을 옮기는 풀이!
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[1001];
        for(int i=0; i<n; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }
        int result = 0;
        for(int i=1; i<=1000; i++) {
            if(arr[i] != 0) {
                i += l - 1;
                result++;
            }
        }

        System.out.println(result);
    }
}
