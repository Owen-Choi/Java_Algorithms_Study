package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 3036번
public class Rings {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int temp;
        for(int i=1; i<N; i++) {
            if(arr[0] % arr[i] == 0) {
                if(arr[0] > arr[i])
                    System.out.println(arr[0] / arr[i] + "/" + 1);
                else
                    System.out.println(arr[0] / arr[i] + "/" + arr[i]/arr[0]);
            }
            else {
                temp = recur(arr[0], arr[i]);
                System.out.println(arr[0]/temp + "/" + arr[i]/temp);
            }
        }
    }
    static int recur(int a, int b) {
        if(b == 0)
            return a;
        return recur(b, a%b);
    }
}
