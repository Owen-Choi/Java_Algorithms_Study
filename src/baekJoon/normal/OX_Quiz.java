package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 8958
public class OX_Quiz {
    static int totalScore = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());
        while(TestCase > 0) {
            totalScore = 0;
            TestCase--;
            String Temp = br.readLine();
            int i = 0;
            int Score = 0;
            while(i < Temp.length()){
                if(Temp.charAt(i) == 'O'){
                    totalScore += ++Score;
                }
                else
                    Score = 0;
                i++;
            }
            System.out.println(totalScore);
        }
    }
}
