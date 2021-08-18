package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 2609번
public class LCM_and_GCF {
    static int Num1, Num2;
    static int[] arr = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Num1 = Integer.parseInt(st.nextToken());
        Num2 = Integer.parseInt(st.nextToken());
        int k = 0;
        int temp;
        while(true) {
            temp = CM(Num1, Num2);
            if(temp != -1)
                arr[k++] = temp;
            else
                break;
            Num1 /= temp;
            Num2 /= temp;
        }
        temp = 1;
        for(int i=0; i<k; i++) {
            temp *= arr[i];
        }
        System.out.println(temp);
        System.out.println(temp * Num1 * Num2);
    }
    static int CM(int n1, int n2){
        int temp = Math.min(n1, n2);
        for(int i = 2; i<temp; i++) {
            if(n1 % i == 0 && n2 % i == 0)
                return i;
        }
        return -1;
    }
}
