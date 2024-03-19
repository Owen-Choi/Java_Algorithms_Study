package baekJoon.normal;

import java.io.*;
import java.util.*;
public class Thirty {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int[] arr = new int[10];
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            arr[n.charAt(i) - 48]++;
            sum += (n.charAt(i) - 48);
        }
        if (arr[0] == 0 || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            while(arr[i] != 0) {
                sb.append(i);
                arr[i]--;
            }
        }
        System.out.println(sb.toString());
    }
}
