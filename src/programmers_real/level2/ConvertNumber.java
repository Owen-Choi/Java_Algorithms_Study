package programmers_real.level2;

public class ConvertNumber {
    public static void main(String[] args) {
        System.out.println(new ConvertNumberSolution().solution(2, 5, 4));
    }
}

class ConvertNumberSolution {

    int[] dp;
    public int solution(int x, int y, int n) {
        dp = new int[y + 1];
        for(int i=x; i<=y; i++) {
            if(i!=x && dp[i] == 0) {
                dp[i] = -1;
                continue;
            }
            if(i + n <= y) {
                dp[i + n] = dp[i + n] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + n]);
            }
            if(2 * i <= y) {
                dp[2 * i] = dp[2 * i] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[2*i]);
            }
            if(3 * i <= y) {
                dp[3 * i] = dp[3 * i] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[3*i]);
            }
        }
        return dp[y];
    }
}


// 미친 시간초과

//package programmers_real.level2;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class ConvertNumber {
//    public static void main(String[] args) {
//        System.out.println(new ConvertNumberSolution().solution(10, 40, 5));
//    }
//}
//
//class ConvertNumberSolution {
//    public int solution(int x, int y, int n) {
//        Queue<Integer> queue = new LinkedList<>();
//        boolean[] flag = new boolean[y + 1];
//        queue.add(x);
//        int counter = 0;
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            for(int i=0; i<size; i++) {
//                int temp = queue.poll();
//                flag[temp] = true;
//                if(temp == y)  return counter;
//                if(temp + n <= y && !flag[temp + n]) queue.add(temp+n);
//                if(2 * temp <= y && !flag[2 * temp]) queue.add(2 * temp);
//                if(3 * temp <= y && !flag[3 * temp]) queue.add(3 * temp);
//            }
//            counter++;
//        }
//        return -1;
//    }
//}
