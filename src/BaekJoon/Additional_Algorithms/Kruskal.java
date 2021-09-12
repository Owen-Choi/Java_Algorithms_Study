package BaekJoon.Additional_Algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
    static int N = 7, M = 11;
    static int[][] arr = new int[M][3];
    public static void main(String[] args) {
        arr[0][0] = 1;  arr[0][1] = 7; arr[0][2] = 12;
        arr[1][0] = 1;  arr[1][1] = 4; arr[1][2] = 28;
        arr[2][0] = 1;  arr[2][1] = 2; arr[2][2] = 67;
        arr[3][0] = 1;  arr[3][1] = 5; arr[3][2] = 17;
        arr[4][0] = 2;  arr[4][1] = 4; arr[4][2] = 24;
        arr[5][0] = 2;  arr[5][1] = 5; arr[5][2] = 62;
        arr[6][0] = 3;  arr[6][1] = 5; arr[6][2] = 20;
        arr[7][0] = 3;  arr[7][1] = 6; arr[7][2] = 37;
        arr[8][0] = 4;  arr[8][1] = 7; arr[8][2] = 13;
        arr[9][0] = 5;  arr[9][1] = 6; arr[9][2] = 45;
        arr[10][0] = 5;  arr[10][1] = 7; arr[10][2] = 73;
        // this gonna be used as flag array ::
        int [] parent = new int[N];
        for(int i=0; i<N; i++)
            parent[i] = i;
        int result = 0;
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for(int i=0; i<arr.length; i++) {
            //Check for Cycles ::
            if(!CycleCheck(parent, arr[i][0] - 1, arr[i][1] - 1)){
                result += arr[i][2];
                MergeParent(parent, arr[i][0] - 1, arr[i][1] - 1);
            }
        }
        System.out.println(result);
    }
    static boolean CycleCheck(int[] parent, int FirstIndex, int SecondIndex) {
        // Assign the return value to FIrstIndex, that is the index of its parent ::
        FirstIndex = WhoIsYourParent(parent, FirstIndex);
        // Assign the return value to SecondIndex, that is the index of its parent also ::
        SecondIndex = WhoIsYourParent(parent, SecondIndex);
        // now if they have same parent, then it will return true ::
        // and that means there is cycle, and we don't have to add that link ::
        return FirstIndex == SecondIndex;
    }

    static int WhoIsYourParent(int[] parent, int index) {
        // if it doesn't have parent :: return itself
        if(parent[index] == index) return index;
        // else find who is its parent by recursion ::
        else
            return parent[index] = WhoIsYourParent(parent, parent[index]);
        // now if there is inter-connected edge, then they have the same index of parent ::
    }

    static void MergeParent(int[] parent, int FirstIndex, int SecondIndex) {
        // In this method, if the two nodes have same parent, then the parent array will be updated
        // as same index ::
        FirstIndex = WhoIsYourParent(parent, FirstIndex);
        SecondIndex = WhoIsYourParent(parent, SecondIndex);
        if(FirstIndex < SecondIndex) parent[SecondIndex] = FirstIndex;
        else parent[FirstIndex] = SecondIndex;
    }
}

