package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 2577번
public class The_Number_Of_Integer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        long Multiple = (A*B*C);
        String MultipleSen = Long.toString(Multiple);
        int[] arr = new int[MultipleSen.length() > 9 ? MultipleSen.length() : 10];
        int i=0;
        while(i < MultipleSen.length()){
            arr[Character.getNumericValue(MultipleSen.charAt(i))]++;       //Char형이 자동으로 int로 바뀌나?
            i++;
        }

        for(i=0; i<=9; i++){
            System.out.println(arr[i]);
        }
    }
}
