package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 1541번
public class Lost_Bracket {
    public static void main(String[] args) throws IOException {
        int sum = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sub = br.readLine().split("-");
        for(int i=0; i<sub.length; i++){
            String[] mini = sub[i].split("\\+");
            int temp = 0;
            for(int k=0; k<mini.length; k++){
                temp += Integer.parseInt(mini[k]);
            }
            if(sum == Integer.MAX_VALUE)
                sum = temp;
            else
                sum -= temp;
        }
        System.out.println(sum);
    }
}
