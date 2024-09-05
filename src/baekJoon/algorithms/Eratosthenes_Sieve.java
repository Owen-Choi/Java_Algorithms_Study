package baekJoon.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 부가 알고리즘 : 에라토스테네스의 체  ::
// 소수를 빠르게 구하는 알고리즘이다.

// 쓰도코드는 다음과 같다.
// 2부터 목표하는 숫자까지 배수를 모두 다 지우고 남은 수만 출력
// 배수를 지우고 남은 수를 사용하는 등의 과정은 boolean 배열을 통해 이루어진다.
public class Eratosthenes_Sieve {
    static int Num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter range of prime number : ");
        Num = Integer.parseInt(br.readLine());
        boolean[] flag = new boolean[Num + 1];
        flag[0] = flag[1] = false;
        for(int i=2; i<=Num; i++)
            flag[i] = true;
        // 2부터 숫자를 키워가며 배수들을 제외(false 할당)
        for(int i=2; i*i <= Num; i++) {
            for(int k = i*i; k<=Num; k+=i) {
                flag[k] = false;            // ex: 2를 제외한 2의 배수 false
            }
        }
        // convert done ::
        System.out.println("Prime number list from 2 to " + Num + "is : ");
        for(int i=0; i<=Num; i++) {
            if(flag[i])
                System.out.println(i + " ");
        }
    }
}
