package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1927번
public class Minimum_Heap {
    static int Input;
    static int [] arr;
    static int DataNum = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        arr = new int[Input + 1];
        while(Input > 0){
            Input--;
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                if(isEmpty())
                    System.out.println("0");
                else
                    System.out.println(Delete());
            }
            else
                Insert(temp);
        }
    }
    static boolean isEmpty(){
        return DataNum == 0;
    }
    static int Delete() {
        int tempNum;
        tempNum = arr[1];
        arr[1] = arr[DataNum--];
        resize();
        return tempNum;
    }
    static void Insert(int num) {
        int tempIndex = ++DataNum;
        if(tempIndex == 1) {
            arr[1] = num;
            return;
        }
        else
            arr[tempIndex] = num;
        while(tempIndex > 1){
            if(arr[tempIndex] < arr[tempIndex/2]){
                // swap
                int temp = arr[tempIndex];
                arr[tempIndex] = arr[tempIndex/2];
                arr[tempIndex/2] = temp;
                tempIndex /= 2;
            }
            else
                break;
        }
    }
    static void resize(){
        if(DataNum == 0 || DataNum == 1)
            return;
        else{
            int tempIndex = 1;
            while(true){
                int temp;
                if(tempIndex * 2 > Input + 1)
                    break;
                if(arr[tempIndex] > arr[tempIndex * 2]){
                    temp = arr[tempIndex];
                    arr[tempIndex] = arr[tempIndex * 2];
                    arr[tempIndex * 2] = temp;
                    tempIndex *= 2;
                    continue;
                }
                else if(arr[tempIndex] > arr[tempIndex * 2 + 1]){
                    temp = arr[tempIndex];
                    arr[tempIndex] = arr[tempIndex * 2 + 1];
                    arr[tempIndex * 2 + 1] = temp;
                    tempIndex = tempIndex * 2 + 1;
                    continue;
                }
                break;
            }
        }
    }
}
