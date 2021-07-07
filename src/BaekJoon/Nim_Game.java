package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Nim_Game {
    static int[] arr;
    static boolean[] bool_arr;
    static boolean koosaga_advantage;
    static boolean cubelover_advantage;
    static int total = 0;
    static int input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[input];
        bool_arr = new boolean[input];
        total = input;
        for(int i = 0; i < input; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //시작은 koosaga
        // 본인 차례에 짝수 더미여야 유리
        if(arr[0] == 1 && input > 1){
                if(input % 2 == 0) {
                    koosaga_advantage = true;
                    cubelover_advantage = false;
                }
                else{
                    koosaga_advantage = false;
                    cubelover_advantage = true;
                }
        }
        else if(arr[0] != 1 && input > 1){
            if(input % 2 == 0) {
                koosaga_advantage = false;
                cubelover_advantage = true;
            }
            else{
                koosaga_advantage = true;
                cubelover_advantage = false;
            }
        }

    }

    static void koosaga(){
        // 유리한 상황이면
        int i;
        if(koosaga_advantage){
            for(i=0; i<input; i++){
                if(!bool_arr[i] && arr[i] == 1) {
                    bool_arr[i] = true;
                    break;
                }
            }
        }
        // 불리한 상황이면
        // 값이 1인 배열을 찾아보고, 있으면 제거 후 유리한 상황으로 돌입
        else if(cubelover_advantage){
            for(i=0; i<input; i++){
                if(!bool_arr[i] && arr[i] == 1) {
                    bool_arr[i] = true;
                    koosaga_advantage = true;
                    cubelover_advantage = false;
                    break;
                }
            }

        }
    }

    static void cubelover() {
        if(cubelover_advantage)
            total = total - 1;
        else if(koosaga_advantage){

        }
    }
}
