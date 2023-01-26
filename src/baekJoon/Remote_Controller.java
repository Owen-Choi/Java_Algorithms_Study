package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Remote_Controller {
    static int N, brokenNum;
    static boolean[] brokens;
    static final int MaxValue = 0x7a120;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        brokenNum = Integer.parseInt(br.readLine());
        brokens = new boolean[10];
        // 여기서 Nullpointer가 뜰 수도 있다. 고장난 버튼이 없는 경우. 따라서 조건문을 통해 확인해주고
        // 코드를 실행하도록 한다.
        StringTokenizer st;
        if(brokenNum != 0) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < brokenNum; i++) {
                brokens[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int temp, Nogada = Math.abs(N - 100), remain = 0;
        for(int i=0; i<=MaxValue * 2; i++) {
            temp = checker(i);
            // temp가 0이 아니라는 것은 남아있는 숫자 중에서 고장난 버튼에 걸리지 않고 반환이 되었다는 것.
            if(temp > 0) {
                remain = Math.abs(N - i);
                Nogada = Math.min(Nogada, remain + temp);
            }
        }
        System.out.println(Nogada);
    }
    static int checker(int num) {
        if(num == 0) {
            if(brokens[num])
                return 0;
            else
                return 1;
        }
        int count = 0;
        while(num > 0) {
            if(brokens[num % 10])
                return 0;
            num /= 10;
            count++;
        }
        return count;
    }
}
