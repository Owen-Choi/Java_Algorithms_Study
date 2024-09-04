package programmers.level2;

import java.util.*;
import java.io.*;

public class 숫자_카드_나누기 {
    public static void main(String[] args) throws IOException {
        int[] arrayA = {10, 20};
        int[] arrayB = {5, 17};
        System.out.println(new Solution().solution(arrayA, arrayB));
    }

    static class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            // 1. 철수의 모든 카드를 나눌 수 있어야 하고, 영희의 카드는 모두 나눌 수 없어야 함 (배수가 없어야 함)
            // 2. 반대
            // 위 두 조건을 만족하는 수 중 가장 큰 수를 구하는 문제.
            // arrayA => 철수 , arrayB => 영희
            // 당연히 브루트포스라고 생각했는데, 배열의 길이가 너무 길다. 어떻게 풀지? 유클리드 호제법?
            // A 배열의 최대공약수를 구한 뒤, B 배열에서 이 최대공약수 및 약수들이 나누어떨어지는지 확인?
            int answer = Math.max(caseA(arrayA, arrayB), caseB(arrayA, arrayB));
            return answer == -1 ? 0 : answer;
        }

        int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        int caseA(int[] arrayA, int[] arrayB) {
            int result = 0;
            int gcdValue = arrayA[0];
            for (int i = 1; i < arrayA.length; i++) {
                gcdValue = gcd(gcdValue, arrayA[i]);
                if (gcdValue == 1)
                    return -1;
            }
            // 종료되지 않았다면 arrayA를 나눌 수 있는 최대공약수가 존재한다는 뜻.
            // 이제 이 최대공약수와, 최대공약수의 약수들로 arrayB를 모두 나눌 수 없는지 확인한다.
            // List<Integer> list = new ArrayList<>();
            // for(int i=1; i<=gcdValue / 2; i++) {
            //     if(gcdValue % i == 0)
            //         list.add(i);
            // }
            // list.add(gcdValue);
            // boolean flag;
            // for(Integer element : list) {
            //     flag = false;
            //     for(int i=0; i<arrayB.length; i++) {
            //         if(arrayB[i] % element == 0) {
            //             flag = true;
            //             break;
            //         }
            //     }
            //     if(!flag) {
            //         result = Math.max(result, element);
            //     }
            for (int i = 0; i < arrayB.length; i++) {
                if (arrayB[i] % gcdValue == 0) {
                    return -1;
                }
            }

            return gcdValue;
            // return result == 0 ? -1 : result;
        }

        int caseB(int[] arrayA, int[] arrayB) {
            int gcdValue = arrayB[0];
            int result = 0;
            /* TODO
                왜 최대공약수만 고려해도 정답이 되는거지?
                왜냐하면, 최대공약수로 나누어 떨어진다면 그 약수로도 나누어 떨어지기 때문이라고 한다.
                근데 내가 이런 생각을 했던 건,최대공약수로 안나누어 떨어지는데 그 약수로는 나누어 떨어질 수 있기 때문이었다.
                그래서 찾아봤는데, 어차피 나누어 떨어지지 않는 것을 찾기 때문에 상관이 없다고 한다.
                솔직히 나도 어쩌다 짠 코드지만 다 이해가 되지는 않는다.
             */
            for (int i = 1; i < arrayB.length; i++) {
                gcdValue = gcd(gcdValue, arrayB[i]);
                if (gcdValue == 1)
                    return -1;
            }
            // List<Integer> list = new ArrayList<>();
            // for(int i=1; i<=gcdValue / 2; i++) {
            //     if(gcdValue % i == 0)
            //         list.add(i);
            // }
            // list.add(gcdValue);
            // boolean flag;
            for (int i = 0; i < arrayA.length; i++) {
                if (arrayA[i] % gcdValue == 0) {
                    return -1;
                }
            }
            return gcdValue;
            // for(Integer element : list) {
            //     flag = false;
            //     for(int i=0; i<arrayA.length; i++) {
            //         if(arrayA[i] % element == 0) {
            //             flag = true;
            //             break;
            //         }
            //     }
            //     if(!flag) {
            //         result = Math.max(result, element);
            //     }
            // }

            // return result == 0 ? -1 : result;
        }
    }
}
