package baekJoon.normal;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// 4673번
public class Self_Number {
    static int temp = 0;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        for(int i=1; i<=10000; i++){
            check(i);
        }
        bw.flush();
        bw.close();
    }
    static void check(int num)throws IOException{
        for(int i=num; i>0; i--){
            if(Is_Self(i, num)) {
                return;
            }
        }
        bw.write(num + "\n");
    }
    static boolean Is_Self(int num, int target) {
        temp = num;
        num %= 10000;
        temp += num/1000;
        num %= 1000;
        temp += num/100;
        num %= 100;
        temp += num/10;
        num %= 10;
        temp += num;

        return temp == target;
    }
}
