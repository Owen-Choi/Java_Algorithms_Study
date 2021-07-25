package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 5585번
public class Change {
    static int num = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = 1000 - Integer.parseInt(br.readLine());
        while(change != 0){
            if(change >= 500){
                change -= 500;
                num++;
            }
            else if(change >= 100){
                change -= 100;
                num++;
            }
            else if(change >= 50){
                change -= 50;
                num++;
            }
            else if(change >= 10){
                change -= 10;
                num++;
            }
            else if(change >= 5){
                change -= 5;
                num++;
            }
            else{
                change--;
                num++;
            }
        }
        System.out.println(num);
    }
}
