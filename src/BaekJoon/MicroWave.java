package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10162번
public class MicroWave {
    static int Input;
    static final int A = 300;
    static final int B = 60;
    static final int C = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        if(Input % 10 != 0) {
            System.out.println(-1);
            return;
        }
        int Acount = 0;
        int Bcount = 0;
        int Ccount = 0;

        while(Input > 0){
            if(Input >= A){
                Acount++;
                Input -= A;
            }
            else if(Input >= B){
                Bcount++;
                Input -= B;
            }
            else{
                Ccount++;
                Input -= C;
            }
        }

        System.out.println(Acount + " " + Bcount + " " + Ccount);
    }
}
