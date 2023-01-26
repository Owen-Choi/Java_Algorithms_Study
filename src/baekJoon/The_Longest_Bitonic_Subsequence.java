package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11054번
public class The_Longest_Bitonic_Subsequence {
    static int N;
    static int[] arr;
    static int[] INC;
    static int[] DSC;
    static int MAX = -1;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        INC = new int[N];
        DSC = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            INC[i] = 1;
            DSC[i] = 1;
        }
        for(int i=0; i<N; i++){
            for(int k=i-1; k>=0; k--){
                if(arr[k] < arr[i]){
                    INC[i] = Math.max(INC[i], INC[k] + 1);
                }
            }
        }
        for(int i=N-1; i>=0; i--){
            for(int k=i+1; k<N; k++) {
                if(arr[k] < arr[i])
                    DSC[i] = Math.max(DSC[i], DSC[k] + 1);
            }
        }
        for(int i=0; i<N; i++){
            MAX = Math.max(MAX, INC[i]+DSC[i] - 1);
        }
        System.out.println(MAX);
    }
}
