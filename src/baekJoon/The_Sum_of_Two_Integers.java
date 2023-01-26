package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 3273번
public class The_Sum_of_Two_Integers {
    static int Num, target;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[Num];
        for(int i=0; i<Num; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(br.readLine());
        // Input ends
        System.out.println(Solve());
    }
    // sort first, and then find the numbers
    static int Solve() {
        Arrays.parallelSort(arr);
        int result = 0, sum;
        int first = 0, second = arr.length - 1;
        while(first < second) {
            sum = arr[first] + arr[second];
            if(sum == target)
                result++;
            if(sum > target)
                second--;
            else
                first++;
        }
        return result;
    }
}
