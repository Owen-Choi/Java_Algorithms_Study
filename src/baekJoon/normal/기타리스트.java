package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 기타리스트 {
    public static void main(String[] args) throws IOException {
        // dp[i] = i번째 곡을 연주할때의 최대 볼륨?
        // 정답에서는 dp[i] = k 를 k곡을 연주할때 i볼륨이라고 해석한다... 아니 대체 왜..???
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, s, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] dp = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -1);
        // 볼륨이 s일때 첫번째 곡.

        dp[s] = 0;
        for(int i=1; i<=n; i++) {
            List<Integer> list = new ArrayList<>();
            for(int k=0; k<=m; k++) {
                if(dp[k] == i - 1) {
                    if(k + arr[i] <= m) {
                        list.add(k + arr[i]);
                    }
                    if(k - arr[i] >= 0) {
                        list.add(k - arr[i]);
                    }
                }
            }

            for (Integer integer : list) {
                dp[integer] = i;

            }
        }

        int result = -1;
        for(int i=0; i<=m; i++) {
            if(dp[i] == n) {
                result = Math.max(result, i);
            }
        }
        System.out.println(result);

    }
}
