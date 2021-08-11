package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1018번
public class RePaint_Chess_Plate {
    static int M;
    static int N;
    static int Min = Integer.MAX_VALUE;
    static char[][] plate;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        plate = new char[M][N];
        String temp;
        for(int i = 0; i<M; i++){
            temp = br.readLine();
            for(int k=0; k<N; k++){
                plate[i][k] = temp.charAt(k);
            }
        }

        for(int i=0; i+7<M; i++){
            for(int k=0; k+7<N; k++){
                Check(i, k);
            }
        }

        System.out.println(Min);
    }
    static void Check(int X_StartPos, int Y_StartPos){
        int Change_Num = 0;
        char[][] temp_plate = new char[plate.length][plate[0].length];
        for(int i=0; i<plate.length; i++){
            System.arraycopy(plate[i], 0, temp_plate[i], 0, plate[0].length);
        }
        for(int i=X_StartPos; i<X_StartPos + 8; i++){
            for(int k=Y_StartPos; k<Y_StartPos + 7; k++){
                if(temp_plate[i][k] == temp_plate[i][k+1]){
                    Change_Num++;
                    temp_plate[i][k+1] = temp_plate[i][k+1] == 'B' ? 'W' : 'B';
                }
            }
        }

        for(int i=0; i<M; i++){
            for(int k=0; k<N; k++){
                System.out.print(temp_plate[i][k]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(Change_Num);
        System.out.println("=========================================");
        System.out.println();

        Min = Math.min(Change_Num, Min);
    }
}
