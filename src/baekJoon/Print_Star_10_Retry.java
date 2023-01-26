package baekJoon;

import java.io.*;
// 2447번
public class Print_Star_10_Retry {
    static int Input;
    static char[][] ForPrint;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Input = Integer.parseInt(br.readLine());
        ForPrint = new char[Input][Input];
        recur(0,0,Input,false);
        for(int i=0; i<Input; i++){
            for(int k=0; k<Input; k++){
                sb.append(ForPrint[i][k]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void recur(int x, int y, int input, boolean check){
        if(check){
            for(int i=x; i<x+input; i++)
                for(int k=y; k<y+input; k++) {
                    ForPrint[i][k] = ' ';
                }
            return;
        }
        if(input == 1) {
            ForPrint[x][y] = '*';
            return;
        }

        int DivValue = input/3;
        int Count = 0;
        for(int i=x; i<x+input; i+= DivValue){
            for(int k=y; k<y+input; k+= DivValue) {
                Count++;
                if(Count == 5)
                    recur(i,k,DivValue, true);
                else
                    recur(i,k,DivValue, false);
            }
        }
    }
}
