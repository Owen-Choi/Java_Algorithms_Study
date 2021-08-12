package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 1436번
public class Director_Shom {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int Count = 0;
        long Num = 0;
        int SixCount;
        String temp;
        while(Count != N) {
            SixCount = 0;
            Num++;
            temp = String.valueOf(Num);
            for(int i=0; i<temp.length(); i++){
                if(temp.charAt(i) == '6')
                    SixCount++;
                else if(temp.charAt(i) != '6' && SixCount != 0){
                    SixCount = 0;
                }
                if(SixCount >= 3){
                    Count++;
                    break;
                }
            }
        }

        System.out.println(Num);
    }
}
