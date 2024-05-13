package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 틱택토 {
    static final String v = "valid";
    static final String iv = "invalid";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        while(!input.equals("end")) {
            // X가 선공이다.
            // 불가능한 경우가 뭐가 있을까.
            // 일단 O와 X의 수가 선공/후공에 맞지 않은 경우
            // 그리고 O와 X의 수가 맞다면, 한쪽이 2개 이상의 일직선을 만들지는 않았는지 (동시에 만드는건 제외, 즉 두 일직선이 서로 접촉을 했다면 ㄱㅊ)
                // 이건 개수로 볼 수 있을 것 같은데, 애초에 게임지를 다 채워도 돌의 수가 6을 넘지 못하다.
            // 또 한쪽이 이미 승리했는데, 다른 쪽의 돌 수가 맞지 않은 경우. 이거랑 위 조건이랑 겹치나?
                // 조금 더 자세하게 얘기해보면, .XXX.XOOO 가 불가능한 이유는 O가 이미 이겼음에도, X가 하나를 더 뒀기 때문이다.
                // 즉, O가 이겼다면 반드시 X와 O의 돌 수는 일치해야 하는 듯 하다.
                // 또 X가 이겼다면 O의 돌 수가 하나 더 적어야 한다.

            // 일단 일직선을 먼저 찾아야 하지 않을까?
            char[][] arr = new char[3][3];
            int o = 0, x = 0;
            for(int i=0; i<3; i++) {
                for(int k=0; k<3; k++) {
                    arr[i][k] = input.charAt(i*3 + k);
                    if(arr[i][k] == 'O') o++;
                    else if(arr[i][k] == 'X') x++;
                }
            }

            // 행, 열, 대각선 순으로 찾아보자.
            int oCount = 0, xCount = 0;
            for(int i=0; i<3; i++) {
                // 행
                if(arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                    if(arr[i][0] == 'O') {
                        oCount++;
                    } else if(arr[i][0] == 'X') {
                        xCount++;
                    }
                }
                // 열
                if(arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
                    if(arr[0][i] == 'O') {
                        oCount++;
                    } else if(arr[0][i] == 'X') {
                        xCount++;
                    }
                }
            }
            // 대각선은 따로 봐준다.
            if(arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
                if(arr[1][1] == 'O') {
                    oCount++;
                } else if(arr[1][1] == 'X') {
                    xCount++;
                }
            }
            if(arr[2][0] == arr[1][1] && arr[1][1] == arr[0][2]) {
                if(arr[1][1] == 'O') {
                    oCount++;
                } else if(arr[1][1] == 'X') {
                    xCount++;
                }
            }
            // 에바네,,, 코드가 너무 길다.
            // 아무튼 이제 o와 x가 만든 일직선의 수와 돌의 수를 알고 있다.
            if(oCount > 0 && xCount == 0) {
                if(x == o) sb.append(v);
                else sb.append(iv);
            } else if(oCount == 0 && xCount > 0) {
                if(x == o + 1) sb.append(v);
                else sb.append(iv);
            } else if(oCount > 0 && xCount > 0) {
                // 애초에 둘 다 0인 경우는 말이 안된다.
                // 한쪽이 이긴 시점에서 게임이 끝났어야 함. iv.
                sb.append(iv);
            } else {
                // 둘 다 0인 경우 :: 반드시 x가 o보다 1개가 커야함
                if(x == 5 && o == 4) sb.append(v);
                else sb.append(iv);
            }
            sb.append("\n");
            input = br.readLine();
        }
        System.out.println(sb.toString());
    }
}
