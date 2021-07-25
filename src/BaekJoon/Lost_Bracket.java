package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 1541번
public class Lost_Bracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Input = br.readLine();
        String newString = Input;
        boolean isMinus = false;
        for(int i=0; i<Input.length(); i++){
            if(Input.charAt(i) == '-'){
                isMinus = true;
                continue;
            }
            if(isMinus && Input.charAt(i) == '+'){
                newString = newString.substring(0,i) + '-' + newString.substring(i+1);
            }
            if(isMinus && Input.charAt(i) == '-')
                isMinus = false;
        }
        System.out.println(newString);
        int k=0;    int[] values = new int[newString.length()];
        char[] arith = new char[newString.length()];
        boolean SWM = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<newString.length(); i++){
            if(newString.charAt(i) != '+' && newString.charAt(i) != '-'){
                sb.append(newString.charAt(i));
            }
            else{
                if(i == 0){
                    SWM = true;
                    continue;
                }

                values[k] = Integer.parseInt(sb.toString());
                sb.setLength(0);
                arith[k] = newString.charAt(i);
                k++;
            }
        }
        values[k] = Integer.parseInt(sb.toString());
            int result = values[0];
            for (int i = 1; i < values.length; i++) {
                result = arith[i - 1] == '+' ? result + values[i] : result - values[i];
            }
        result = SWM ? result - values[0] * 2 : result;
        System.out.println(result);
    }
}
