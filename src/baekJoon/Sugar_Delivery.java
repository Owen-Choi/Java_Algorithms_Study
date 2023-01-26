package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2839번
public class Sugar_Delivery {
    static int input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(br.readLine());
        int count = 0;

        while(true){
            if(input % 5 == 0){
                System.out.println(input/5 + count);
                break;
            }
            else if(input <= 0){
                System.out.println(-1);
                break;
            }
            input -= 3;
            count++;
        }
    }


}
