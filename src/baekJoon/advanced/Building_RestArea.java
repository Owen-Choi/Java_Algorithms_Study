package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Building_RestArea {
    static int N, M, L;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N + 2];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N] = 0;
        arr[N + 1] = L;
        Arrays.sort(arr);
        System.out.println(binarySearch());
    }

    static int binarySearch() {
        int left = 0;
        int right = L;
        while(left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for(int i=1; i<arr.length; i++) {
                count += (arr[i] - arr[i - 1] - 1) / mid;
            }
            if(count > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}



//package baekJoon.advanced;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.StringTokenizer;
//
//public class Building_RestArea {
//    static int N, M, L;
//    static ArrayList<Integer> list = new ArrayList<>();
//    static Comparator<Integer> comp = new Comparator<Integer>() {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return o1 - o2;
//        }
//    };
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        L = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine()," ");
//        // 이분탐색을 M번 하면서 휴게소가 없는 구간이 가장 긴 구간을 찾아 업데이트 한다.
//        for(int i=0; i<N; i++) {
//            list.add(Integer.parseInt(st.nextToken()));
//        }
//        list.add(0);
//        list.add(L);
//        list.sort(comp);
//        int max = Integer.MIN_VALUE;
//        int previous = 0;
//        int post = 0;
//        int newVal = 0;
//        while(M --> 0) {
//            // 투포인터 시작, 가장 휴게소 없는 구간이 긴 곳을 찾은 뒤 그 중간 지점에 휴게소를 세워준다.
//            int left = 0, right = list.size() - 2;
//            max = Integer.MIN_VALUE;
//            newVal = 0;
//            while(left < right) {
//                int firstVal = list.get(left + 1) - list.get(left);
//                int secondVal = list.get(right + 1) - list.get(right);
//                // 첫 값이 뒤에 있는 값 보다 크다면, 그 값이 최대값을 갱신하는지 확인함
//                if(firstVal > secondVal) {
//                    if(max < firstVal) {
//                        max = firstVal;
//                        previous = list.get(left);
//                        post = list.get(left + 1);
//                    }
//                    right--;
//                } else {
//                    if(max < secondVal) {
//                        max = secondVal;
//                        previous = list.get(right);
//                        post = list.get(right + 1);
//                    }
//                    left++;
//                }
//            }
//            // 찾은 최댓값과 인덱스를 통해 다음 휴게소 위치를 업데이트
//            newVal = previous + (max / 2);
//            list.add(newVal);
//            list.sort(comp);
////            for(int i=0; i<list.size(); i++) {
////                System.out.print(list.get(i) + " ");
////            }
////            System.out.println();
//        }
//        max = Integer.MIN_VALUE;
//        for(int i=0; i<list.size() - 1; i++) {
//            max = Math.max(list.get(i + 1) - list.get(i), max);
//        }
//        System.out.println(max);
//    }
//}
