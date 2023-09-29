package woj;

import java.util.*;
public class Permutation {
    static Stack<Integer> st;
    static int[] arr;
    static boolean[] flag;
    public static void main(String[] args) {
        st = new Stack<>();
        arr = new int[] {1,2,3,4,5,6,7,8,9};
        flag = new boolean[9];
        permut(9, 3);
    }

    static void permut(int n, int k) {
        if(st.size() == k) {
            for(Integer element : st) {
                System.out.print(element + " ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++) {
            if(!flag[i]) {
                flag[i] = true;
                st.push(arr[i]);
                permut(n, k);
                st.pop();
                flag[i] = false;
            }
        }
    }
}
