package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 뒤집기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char prev = input.charAt(0);
        int[] arr = new int[2];
        arr[prev - 48]++;
        for(int i=1; i<input.length(); i++) {
            if(prev != input.charAt(i)) {
                prev = input.charAt(i);
                arr[prev - 48]++;
            }
        }
        System.out.println(Math.min(arr[0], arr[1]));
    }
}
