package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2473, 세 용액, 골드3
public class Three_Liquids {

    static int N;
    static int[] liquids;
    static int sumMin = Integer.MAX_VALUE;
    static int result1, result2, result3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        liquids = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }
        // 트리플? 포인터를 사용하기 위해 정렬하겠음.
        Arrays.sort(liquids);

        int left = 0;
        int right = N - 1;
        int mid = left + right / 2;

        while(left < right || left < mid || right > mid) {
            int sum = liquids[left] + liquids[right] + liquids[mid];
            int sumAbs = Math.abs(sum);
            if(sumAbs < sumMin) {
                sumMin = sumAbs;
                // 아래 순서로 출력하면 자동으로 오름차순
                result1 = liquids[left];
                result2 = liquids[mid];
                result3 = liquids[right];
            }
            /*
                포인터가 3개이므로 작거나 클때는 경우를 나눠야겠다.
                1. 작을때
                    i. mid를 옮긴 결과를 구함
                    ii. left를 옮긴 결과를 구함
                    iii. 결과를 비교해서 더 정답에 가까운 쪽으로 값 이동.

                2. 클때
                    1번과 동일하게 진행
             */
            if(sum > 0) {
                // 값이 작아져야함.
                if(Math.abs(liquids[left] + liquids[mid] + liquids[right - 1]) < Math.abs(liquids[left] + liquids[mid - 1] + liquids[right])) {
                    right--;
                } else {
                    mid--;
                }
            } else if(sum < 0) {
                // 값이 커져야함.
                if(Math.abs(liquids[left + 1] + liquids[mid] + liquids[right]) > Math.abs(liquids[left] + liquids[mid + 1] + liquids[right])) {
                    left++;
                } else {
                    mid++;
                }
            } else {
                // 바로 출력
                result1 = liquids[left];
                result2 = liquids[mid];
                result3 = liquids[right];
                break;
            }
        }


//        for(mid = 0; mid < 5000; mid++) {
//
//        }
        System.out.println(result1 + " " + result2 + " " + result3);

    }
}
