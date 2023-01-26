package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

// 2164번
public class Card_2 {
    static int Input;
    public static void main(String[] args) throws IOException{
        LinkedList<Integer> list = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        for(int i=1; i<=Input; i++){
            list.add(i);
        }
        int temp;
        while(list.size() != 1){
            list.removeFirst();
            temp = list.get(0);
            list.addLast(temp);
            list.removeFirst();
        }
        System.out.println(list.get(0));
    }
}
