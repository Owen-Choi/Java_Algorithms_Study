package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 2309번
public class Seven_Dwarfs {
    static int [] arr = new int[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int sum = 0;
        int Index = 0;
        int [] temp = new int[7];
        for(int i=0; i<8; i++){
            for(int k=0; k<9; k++){
                sum = 0;
                Index = 0;
                if(k == i)
                    continue;
                else{
                    for(int j=0; j<9; j++){
                        if( j == i || j == k)
                            continue;
                        else
                            temp[Index++] = arr[j];
                    }
                }
                for(int p = 0; p<7; p++){
                    sum += temp[p];
                }
                if(sum == 100) {
                    Arrays.sort(temp);
                    for(int tempVal : temp){
                        System.out.println(tempVal);
                    }
                    return;
                }
            }
        }
    }
}
