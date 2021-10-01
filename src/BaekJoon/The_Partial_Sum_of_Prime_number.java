package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 1644 ::
public class The_Partial_Sum_of_Prime_number {
    static int Num, Result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Num = Integer.parseInt(br.readLine());
        Solve();
        System.out.println(Result);
    }
    static void Solve() {
        int left, right, sum = 0;
        left = right = 0;

        do {
            if(sum > Num) {
                sum -= left;
                left++;
                while(!PrimeCheck(left))
                    left++;
            }
            else if(sum < Num) {
                right++;
                while(!PrimeCheck(right))
                    right++;
                sum += right;
            }
            else {
                Result++;
                right++;
                while(!PrimeCheck(right))
                    right++;
                sum += right;
            }
        }while(right <= Num);
    }
    static boolean PrimeCheck(int number) {
        if(number < 2)
            return false;
        for(int i=2; i*i <= number; i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}
