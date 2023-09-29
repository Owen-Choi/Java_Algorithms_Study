package woj;

import java.util.*;
public class Combination {
    static Stack<Integer> st;
    static int[] arr;
    static boolean[] flag;
    public static void main(String[] args) {
        st = new Stack<>();
        arr = new int[]{1,2,3,4,5,6,7,8,9};
        flag = new boolean[9];
        combination(0, 3);
    }

    static void combination(int idx, int k) {
        if(st.size() == k) {
            for(Integer element : st) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        for(int i=idx; i<arr.length; i++) {
            if(!flag[i]) {
                flag[i] = true;
                st.push(arr[i]);
                combination(i, k);
                st.pop();
                flag[i] = false;
            }
        }
    }
}
