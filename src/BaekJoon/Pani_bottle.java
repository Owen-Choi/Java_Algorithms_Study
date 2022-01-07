package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1052번
public class Pani_bottle {
    static int total, target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        total = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        System.out.println(Solve());
    }
    static int Solve() {
        int result = 0;
        // 목표가 1일 경우
        if(target == 1) {
            // 현재 물병의 총량을 2의 제곱수로 만들어야 한다.
            while(total % 4 != 0) {
                total++;
                result++;
            }
            return result;
        }
        // 1 이상일 경우
        else {
            int store = 0, temp;
            // 이 조건문은 N = 50, K = 10인 경우로 생각해볼 수 있다.
            // 5로 딱 나누어 떨어지지만 같은 양의 물만 섞을 수 있는 특성상 10은 나올 수가 없는 수치이므로
            // 각 물병당 물 양을 16으로 맞추어야 한다.
            if(total % target == 0) {
                temp = total / target;
                while(temp % 4 != 0) {
                    temp++;
                    store++;
                }
                return store * target;
            }
            else {

            }
        }
    }
}
