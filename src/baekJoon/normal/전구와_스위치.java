package baekJoon.normal;

import java.util.*;
import java.io.*;

// 문제 좋다.
// TODO 메모리 초과
public class 전구와_스위치 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = new char[n];
        String input = br.readLine();
        for(int i=0; i<n; i++) {
            arr[i] = input.charAt(i);
        }
        String target = br.readLine();
        char[] targetCompare = target.toCharArray();

        char[] a = Arrays.copyOf(arr, arr.length);
        char[] b = Arrays.copyOf(arr, arr.length);
        // a : 첫 스위치 on
        a[0] = arr[0] == '1' ? '0' : '1';
        a[1] = arr[1] == '1' ? '0' : '1';
        // b : 첫 스위치 off

        int aConvert = 1, bConvert = 0;
        for(int i=1; i<n; i++) {
            // 두 번재 전구부터 바꿔가기 시작.
            // target과 다를 때에만 바꿔주어야 한다?
            /*
                3
                000
                010
                위 예시에서는 a가 조건문에 들어가지도 않는다.
             */
            // 조건이 잘못됐다. 전구가 결정되는 최종 상태를 보아야 한다.
            // 이전 전구의 최종 상태는 현재 스위치를 누르는 것에 의해 결정되기 때문에, 이전 상태를 봐야 한다.
            if(a[i - 1] != target.charAt(i - 1)) {
                convert(a, i);
                aConvert++;
            }
            if(b[i - 1] != target.charAt(i - 1)) {
                convert(b, i);
                bConvert++;
            }
            /* TODO
                스트링 비교하면서 자꾸 만들어서 메모리가 초과된 것 같다.
                Arrays.equals() 라는 함수가 있었네. 이걸로 바꿔보자.
             */
            if(Arrays.equals(a, targetCompare)) {
                if(Arrays.equals(a,b)) {
                    System.out.println(Math.min(aConvert, bConvert));
                } else {
                    System.out.println(aConvert);
                }
                return;
            } else if(Arrays.equals(b, targetCompare)){
                System.out.println(bConvert);
                return;
            }
        }

        System.out.println(-1);
    }

    static void convert(char[] a, int i) {
        a[i-1] = a[i-1] == '1' ? '0' : '1';
        a[i] = a[i] == '1' ? '0' : '1';
        if(i + 1 < a.length) {
            a[i+1] = a[i+1] == '1' ? '0' : '1';
        }
    }
}
