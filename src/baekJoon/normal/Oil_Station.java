package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 13305번
public class Oil_Station {
    static int N;
    static int[] KM;
    static int[] Oil;
    static int Min = Integer.MAX_VALUE;
    static long Value = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        KM = new int[N-1];
        Oil = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N-1; i++){
            KM[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            Oil[i] = Integer.parseInt(st.nextToken());
            if(i < N-1){
                Min = Math.min(Min, Oil[i]);
            }
        }
        for(int i=0; i<N-1; i++) {
            if(Oil[i] == Min) {
                int temp = 0;
                for(int k = i; k<N-1; k++){
                    temp += KM[k];
                }
                Value += (long)temp * Min;
                break;
            }
            else {
                if(Oil[i] > Oil[i+1])
                    Value += (long)KM[i] * Oil[i];
                else{
                    long tempValue = 0;
                    for(int j = i; j < N-1; j++){
                        if(Oil[j] < Oil[i]) {
                            Value += tempValue * Oil[i];
                            i = j-1;
                            break;
                        }
                        tempValue += KM[j];
                    }
                }
            }
        }
        System.out.println(Value);
    }

}
