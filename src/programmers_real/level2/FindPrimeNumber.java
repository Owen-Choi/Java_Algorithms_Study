package programmers_real.level2;
import java.util.*;
public class FindPrimeNumber {
    public static void main(String[] args) {
        System.out.println(new FindPrimeNumberSolution().solution("17"));
    }
}

class FindPrimeNumberSolution {
    Set<Integer> set = new HashSet<>();
    boolean[] flag;
    char[] arr;
    public int solution(String numbers) {
        int answer = 0;
        flag = new boolean[numbers.length()];
        arr = numbers.toCharArray();
        for(int i=0; i<arr.length; i++) {
            permutation(i+1, "");
        }
        for(Integer element : set) {
            if(checkPrime(element))
                answer++;
        }
        return answer;
    }

    void permutation(int k, String builder) {
        if(builder.length() == k && !set.contains(builder)) {
            set.add(Integer.parseInt(builder));
            return;
        }
        for(int i=0; i<arr.length; i++) {
            if(!flag[i]) {
                flag[i] = true;
                permutation(k, builder + arr[i]);
                flag[i] = false;
            }
        }
    }

    boolean checkPrime(int num) {
        if(num == 0 || num == 1)
            return false;
        for(int i=2; i*i<=num; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
