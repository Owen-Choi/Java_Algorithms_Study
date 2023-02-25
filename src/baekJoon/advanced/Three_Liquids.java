package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 2473, 세 용액, 골드3
public class Three_Liquids {

    static int N;
    static long[] liquids;
    static long sumMin = 3000000001L;
    static long result1, result2, result3;
    static long[] result = new long[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        liquids = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) {
            liquids[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(liquids);


//        while(left < right || left < mid || right > mid) {
//            int sum = liquids[left] + liquids[right] + liquids[mid];
//            int sumAbs = Math.abs(sum);
//            if(sumAbs < sumMin) {
//                sumMin = sumAbs;
//                // 아래 순서로 출력하면 자동으로 오름차순
//                result1 = liquids[left];
//                result2 = liquids[mid];
//                result3 = liquids[right];
//            }
//            /*
//                포인터가 3개이므로 작거나 클때는 경우를 나눠야겠다.
//                1. 작을때
//                    i. mid를 옮긴 결과를 구함
//                    ii. left를 옮긴 결과를 구함
//                    iii. 결과를 비교해서 더 정답에 가까운 쪽으로 값 이동.
//
//                2. 클때
//                    1번과 동일하게 진행
//             */
//            if(sum > 0) {
//                // 값이 작아져야함.
//                if(Math.abs(liquids[left] + liquids[mid] + liquids[right - 1]) < Math.abs(liquids[left] + liquids[mid - 1] + liquids[right])) {
//                    right--;
//                } else {
//                    mid--;
//                }
//            } else if(sum < 0) {
//                // 값이 커져야함.
//                if(Math.abs(liquids[left + 1] + liquids[mid] + liquids[right]) > Math.abs(liquids[left] + liquids[mid + 1] + liquids[right])) {
//                    left++;
//                } else {
//                    mid++;
//                }
//            } else {
//                // 바로 출력
//                result1 = liquids[left];
//                result2 = liquids[mid];
//                result3 = liquids[right];
//                break;
//            }
//        }

        int left = 0;
        int right = N - 1;
        boolean flag = false;
        for(int mid = 0; mid < N - 2; mid++) {
            left = mid + 1;
            right = N - 1;
            while(left < right) {
                long sum = liquids[left] + liquids[right] + liquids[mid];
                long sumAbs = Math.abs(sum);
                if(sumAbs < sumMin) {
                    sumMin = sumAbs;
                    result1 = liquids[left];
                    result2 = liquids[mid];
                    result3 = liquids[right];
                }

                if(sum > 0) {
                    right--;
                } else if(sum < 0) {
                    left++;
                } else {
                    result1 = liquids[left];
                    result2 = liquids[mid];
                    result3 = liquids[right];
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }

        result[0] = result1;
        result[1] = result2;
        result[2] = result3;

        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);

    }
}
