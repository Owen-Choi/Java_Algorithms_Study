package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 드래곤_앤_던전 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n;
        long atk;
        n = Integer.parseInt(st.nextToken());
        atk = Long.parseLong(st.nextToken());
        Node[] arr = new Node[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Node(Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        // 한번의 반복으로 최대 13만번의 반복을 돈다.
        // 따라서 이분탐색으로 최솟값을 빠르게 찾아내야 한다.

        // 예제애서 주어진 최대의 아웃풋이다. 즉, 이 수를 넘을 일은 없다.
        long max = Long.MAX_VALUE - 1;
        long min = 0;
        long mid = 0;
        while (min <= max) {
            mid = (min + max) / 2;
            if (simulate(arr, atk, mid, n)) {
                // 게임을 클리어할 수 있는 경우 최솟값을 찾기 위해 max를 줄여준다.
                max = mid - 1;
            } else {
                // 게임을 클리어할 수 없는 경우 min을 늘려준다.
                min = mid + 1;
            }
        }
        System.out.println(min);
    }

    static boolean simulate(Node[] arr, long atk, long maxHp, int n) {
        long curHp = maxHp;
        for (int i = 0; i < n; i++) {
            if (arr[i].type == 1) {
                // 플레이어가 때려야 하는 수
                long a = arr[i].hp / atk;
                // 몬스터가 플레이어를 때려야 하는 수
                long b = curHp / arr[i].atk;

                // TODO 얘가 있으면 오답처리됨
                if (a > b) return false;

                // 나누어 떨어질 경우 상대의 턴 없이 게임이 종료된다.
                if (arr[i].hp % atk == 0) {
                    curHp -= arr[i].atk * (a - 1);
                } else {
                    curHp -= arr[i].atk * a;
                }
            } else {
                atk += arr[i].atk;
                curHp += arr[i].hp;
                if (curHp > maxHp) curHp = maxHp;
            }
            if(curHp <= 0) return false;
        }
        return true;
    }

    static class Node {
        int type;
        long atk;
        long hp;

        public Node(int type, long atk, long hp) {
            this.type = type;
            this.atk = atk;
            this.hp = hp;
        }
    }
}
