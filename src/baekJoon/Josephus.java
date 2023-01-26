package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1158번
public class Josephus {
    static int[] arr;
    static boolean[] flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for(int i=1; i<=N; i++)
            arr[i - 1] = i;

        flag = new boolean[N+1];
        int count=0;
        int index = 0;
        int TotalCount = 0;
        int tempIndex = 0;
        System.out.print("<");
        while(TotalCount < N){
            count = 0;
            while(count != K){
                if(flag[arr[index]] == false){
                    count++;
                    tempIndex = index;
                    index++;
                    if(index >= N)
                        index = index%(N);
                }
                else if(flag[arr[index]] == true){
                    index++;
                    if(index >= N)
                        index = index%(N);
                }
            }
            if(tempIndex >= N)
                tempIndex = tempIndex % N;
            flag[arr[tempIndex]] = true;
            System.out.print(arr[tempIndex]);
            TotalCount++;
            if(TotalCount < N)
                System.out.print(", ");
        }
        System.out.print(">");
    }
}
