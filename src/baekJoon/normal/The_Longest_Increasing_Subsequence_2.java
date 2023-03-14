package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 12015번
public class The_Longest_Increasing_Subsequence_2 {
    static int N;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int temp;
        list.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) {
            temp = arr[i] = Integer.parseInt(st.nextToken());
            if(temp > list.get(list.size() - 1)) list.add(temp);
            else {
                BinarySearch(temp);
            }
        }
        System.out.println(list.size() - 1);
    }
    static void BinarySearch(int Input) {
        int left = 0, right = list.size()-1, mid;
        while(left < right) {
            mid = (left + right) / 2;
            if(list.get(mid) >= Input)
                right = mid;
            else
                left = mid + 1;
        }
        list.set(right, Input);
    }
}
