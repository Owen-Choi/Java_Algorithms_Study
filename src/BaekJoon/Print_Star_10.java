package BaekJoon;

import java.io.*;
// 2447번
public class Print_Star_10 {
    static int Input;
    static char[][] recursive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Input = Integer.parseInt(br.readLine());
        recursive = new char[Input][Input];
        recur(0,0,Input,false);
        for(int i=0; i<Input; i++){
            for(int k=0; k<Input; k++){
                sb.append(recursive[i][k]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void recur(int x, int y, int N, boolean blank){
        if(blank){
            for(int i = x; i< x+N; i++){
                for(int k = y; k< y + N; k++)
                    recursive[i][k] = ' ';
            }
            return;
        }
        if(N==1){
            recursive[x][y] = '*';
            return;
        }
        int INC = N/3;
        int count = 0;
        for(int i=x; i<x+N; i += INC){
            for(int k=y; k<y+N; k += INC){
                count++;
                if(count == 5)
                    recur(i,k,INC, true);
                else
                    recur(i,k,INC,false);
            }
        }
    }
}
