package woj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectSquareNumber {
    public static void main(String[] args) {
        int m, n, big, small;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        big = Math.max(m,n);
        small = Math.min(m, n);
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=big; i++) {
            if(i*i >= small && i*i <= big) {
                list.add(i*i);
            }
        }

        if(list.isEmpty()) {
            System.out.println(-1);
        } else {
            int sum = list.stream().mapToInt(i -> i).sum();
            // 차례대로 넣었으니, 가장 앞에 있는 값이 가장 작은 값.
            System.out.println(sum);
            System.out.println(list.get(0));
        }
    }
}
