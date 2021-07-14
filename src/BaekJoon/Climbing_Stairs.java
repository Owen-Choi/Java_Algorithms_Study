package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2579번
public class Climbing_Stairs {
    static int Input;
    static int[] stairs;
    static int TotalScore = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        stairs = new int[Input+1];
        for(int i=1; i<=Input; i++)
            stairs[i] = Integer.parseInt(br.readLine());
        int stepChecker = 0;
        for(int i=0; i<Input;){
            if(stepChecker < 2 && stairs[i+1] > stairs[i+2]){
                TotalScore += stairs[++i];
                stepChecker++;
            }
            else if(stepChecker < 2 && stairs[i+1] < stairs[i+2]){
                i += 2;
                TotalScore += stairs[i];
                stepChecker = 0;
            }
            else if(stepChecker == 2){
                i += 2;
                TotalScore = stairs[i];
                stepChecker = 0;
            }
        }
        TotalScore += stairs[Input];
        System.out.println(TotalScore);
    }
}
