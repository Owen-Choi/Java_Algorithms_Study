package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 7568번
public class Big_Guy {
    static int Input;
    static final int WEIGHT = 0;
    static final int HEIGHT = 1;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        arr = new int[Input+1][2];
        StringTokenizer st;
        for(int i=0; i<Input; i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][WEIGHT] = Integer.parseInt(st.nextToken());
            arr[i][HEIGHT] = Integer.parseInt(st.nextToken());
        }
        int grade = 0;
        int tempCount = 0;
        for(int i=0; i<Input; i++){
            grade = 0;
            for(int k=0; k<Input; k++){
                tempCount = 0;
                for(int j=0; j<2; j++) {
                    if(i == k)
                        break;
                    else{
                        if(arr[i][j] < arr[k][j])
                            tempCount++;
                    }
                }
                if(tempCount == 2){
                    grade++;
                }
            }
            System.out.print((grade + 1) + " ");
        }
    }
}
