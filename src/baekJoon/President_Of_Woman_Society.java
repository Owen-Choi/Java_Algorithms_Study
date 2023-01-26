package baekJoon;

import java.io.*;
// 2775번
public class President_Of_Woman_Society {
    static int TestCase;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TestCase = Integer.parseInt(br.readLine());
        int floor, room;
        while(TestCase > 0){
            TestCase--;
            floor = Integer.parseInt(br.readLine());
            room = Integer.parseInt(br.readLine());
            arr = new int[floor + 1][room + 1];
            for(int i=0; i<=floor; i++){
                for(int k=1; k<=room; k++){
                    if(i == 0)
                        arr[i][k] = k;
                    else if(k == 1)
                        arr[i][k] = 1;
                    else{
                        arr[i][k] = arr[i-1][k] + arr[i][k-1];
                    }
                }
            }
            bw.write(arr[floor][room] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }

}
