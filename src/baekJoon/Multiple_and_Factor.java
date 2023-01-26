package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 5086번
public class Multiple_and_Factor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int Num1 = -1, Num2 = -1;
            while(true){
            st = new StringTokenizer(br.readLine()," ");
            Num1 = Integer.parseInt(st.nextToken());
            Num2 = Integer.parseInt(st.nextToken());
            if(Num1 == 0 && Num2 == 0)
                break;
            if(Num2 % Num1 == 0) {
                sb.append("factor" + '\n');
            }
            else if(Num1%Num2 == 0) {
                sb.append("multiple" + '\n');
            }
            else
                sb.append("neither" + '\n');
        }
        System.out.println(sb);
    }
}
