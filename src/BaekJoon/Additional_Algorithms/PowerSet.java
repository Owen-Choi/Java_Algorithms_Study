package BaekJoon.Additional_Algorithms;

public class PowerSet {
    static int[] arr = {1,2,3,4};
    static boolean[] flag = new boolean[4];
    public static void main(String[] args) {
        powerset(0);
    }
    static void powerset(int depth){
        if(depth == 4){
            for(int i=0; i<4; i++) {
                if(flag[i])
                    System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

            flag[depth] = true;
            powerset(depth + 1);
            flag[depth] = false;
            powerset(depth + 1);
    }
}
