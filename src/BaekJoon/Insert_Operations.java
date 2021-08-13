package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 14888번
public class Insert_Operations {
    static int N;
    static int[] arr;
    static final int PLUS_NUM = 0;
    static final int MINUS_NUM = 1;
    static final int MULTIPLE_NUM = 2;
    static final int DIVIDE_NUM = 3;
    static int[] operations = new int[4];
    static int MAX = -1;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        operations[PLUS_NUM] = Integer.parseInt(st.nextToken());
        operations[MINUS_NUM] = Integer.parseInt(st.nextToken());
        operations[MULTIPLE_NUM] = Integer.parseInt(st.nextToken());
        operations[DIVIDE_NUM] = Integer.parseInt(st.nextToken());
        recur(1, arr[0]);
        System.out.println(MAX);
        System.out.println(MIN);
    }
    // index는 연산자 배열의 인덱스
    static void recur(int Count, int Value){
        if(Count == N){
            MIN = Math.min(MIN, Value);
            MAX = Math.max(MAX, Value);
            return;
        }
        for(int i=0; i<4; i++){
                if(operations[i] > 0){
                    if(i == PLUS_NUM){
                        operations[PLUS_NUM]--;
                        recur(Count+1, Value + arr[Count]);
                        operations[PLUS_NUM]++;
                    }
                    else if(i == MINUS_NUM){
                        operations[MINUS_NUM]--;
                        recur(Count+1, Value - arr[Count]);
                        operations[MINUS_NUM]++;
                    }
                    else if(i == MULTIPLE_NUM){
                        operations[MULTIPLE_NUM]--;
                        recur(Count+1, Value * arr[Count]);
                        operations[MULTIPLE_NUM]++;
                    }
                    else if(i == DIVIDE_NUM){
                        operations[DIVIDE_NUM]--;
                        if(Value < 0){
                            Value *= -1;
                            Value = Value / arr[Count];
                            Value *= -1;
                            recur(Count+1, Value);
                        }
                        else{
                            recur(Count+1, Value / arr[Count]);
                        }
                        operations[DIVIDE_NUM]++;
                    }
                }
        }
    }
}
