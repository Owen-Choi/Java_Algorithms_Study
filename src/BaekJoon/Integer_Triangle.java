package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1932번
public class Integer_Triangle {
    static int[][] arr;
    static int MaxValue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Input = Integer.parseInt(br.readLine());
        arr = new int[Input+1][Input+1];
        for(int i=0; i<Input; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int k=0; k<i+1; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
                // NoSuchElements Expected
            }
        }
        int tempMax = arr[Input-1][0] + arr[Input-2][0];
        int k = 0;
        int tempI = 0; int tempK = 0;
        // 한번만 도는 루프, 잘못 짠 듯 하다.
        for(int i = Input-1; i>=Input-1; i--){
            for(k=0; k<arr[i].length; k++){
                // 선택지가 오른쪽, 왼쪽 둘 다인 경우
                if(k > 0 && k < arr[i].length-1){
                    if(arr[i-1][k-1] + arr[i][k] > tempMax){
                        tempMax = arr[i-1][k-1] + arr[i][k];
                        tempI = i;  tempK = k;
                    }
                    if(arr[i-1][k] + arr[i][k] > tempMax){
                        tempMax = arr[i-1][k] + arr[i][k];
                        tempI = i; tempK = k;
                    }
                }
                // 선택지가 오른족, 혹은 왼쪽인 경우
                else if(k == 0 || k == arr[i].length - 1){
                    if(k == 0){
                        if(arr[i-1][k] + arr[i][k] > tempMax) {
                            tempMax = arr[i-1][k] + arr[i][k];
                            tempI = i;  tempK = k;
                        }
                    }
                    else{
                        if(arr[i-1][k-1] + arr[i][k] > tempMax) {
                            tempMax = arr[i-1][k-1] + arr[i][k];
                            tempI = i; tempK = k;
                        }
                    }
                }
            }
        }
        int j = 0;
        while(tempI > 0){
            if(tempK == 0){
                MaxValue += arr[tempI][tempK];
                tempI--;
            }
            else if(tempK == arr[tempI].length - 1){
                MaxValue += arr[tempI][tempK-1];
            }
            else{
                if(arr[tempI-1][tempK-1] + arr[tempI][tempK] > arr[tempI-1][tempK] + arr[tempI][tempK]){
                    MaxValue += arr[tempI][tempK];
                    tempK--;
                }
                else
                    MaxValue += arr[tempI][tempK];
                tempI--;
            }
        }
        MaxValue += arr[0][0];
        System.out.println(MaxValue);
    }
}
