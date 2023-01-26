package baekJoon;

import java.io.*;
// 11729번
public class Hanoi_Tower {
    static int size;
    static int Switch;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        recur(size, 0, 2);
        System.out.println(Switch);
        bw.write(sb.toString());
        bw.flush(); bw.close();
    }
    static void recur(int size, int StartPosition, int FinishPosition){
        if(size == 1){
            sb.append(StartPosition+1);
            sb.append(" ");
            sb.append(FinishPosition+1);
            sb.append("\n");
            Switch++;
        }
        else{
            recur(size-1, StartPosition,3 - (StartPosition + FinishPosition));
            sb.append(StartPosition+1);
            sb.append(" ");
            sb.append(FinishPosition+1);
            sb.append("\n");
            Switch++;
            recur(size-1, 3 - (StartPosition + FinishPosition), FinishPosition);
        }
    }
}
