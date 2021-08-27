package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1629번
public class DC_Multiple {
    static int A,B,C;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(pow(A,B));
    }
    static long pow(int num, int MN) {
        if(MN == 1)
            return num;

        long temp = pow(num, MN/2);

        if(MN % 2 == 1)
            // 이 연산의 경우는 temp의 제곱에 num까지 곱해주기 때문에 long 형의 최대값을 넘길 수 있으므로 합동 공식으로 분할해서
            // 적용할 필요가 있음
            return ((temp*temp % C) * num) % C;
        else
            // 이 연산의 경우는 temp가 모두 최대값이라 할 지라도 long형의 최대범위를 넘기지 않으니 바로 연산 가능
            return temp*temp % C;
    }

}
