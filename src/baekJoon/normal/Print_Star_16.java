package baekJoon.normal;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
// 10991번
public class Print_Star_16 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int Input = sc.nextInt();
            for(int i=0; i<Input; i++){
                // 시작 지점까지 띄워준다.
                sb.append(" ".repeat(Input - i - 1));
                for(int j=1; j<= i*2 + 1; j++){
                    if(j % 2 == 0)
                        sb.append(" ");
                    else
                        sb.append("*");
                }
                if(i == Input-1)
                    break;
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
    }
}
