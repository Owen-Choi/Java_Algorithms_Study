package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 17143, 낚시왕, 골드1, 구현
public class King_Of_Fishing {

    static int X, Y, M;
    static List<Shark> list;
    static int result = 0;
    static class Shark {
        int x;
        int y;
        int size;
        int vel;
        int direction;

        public Shark(int x, int y, int v, int d, int s) {
            this.x = x;
            this.y = y;
            this.size = s;
            this.vel = v;
            this.direction = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(x,y,v,d,s);
            list.add(shark);
        }
        for(int i=0; i<Y; i++) {
            // 1. 먼저 상어 잡고
            catchUp(i);

            // 2. 상어들 이동시킴
            oneSecOps();

            // 3. 잡아먹히는 상어가 있는지 체크
            eatingCheck();
        }

        System.out.println(result);
    }

    static void catchUp(int y) {
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;
        boolean flag = false;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).y == y) {
                if(minValue > list.get(i).x) {
                    minIndex = i;
                    minValue = list.get(i).x;
                    flag = true;
                }
            }
        }
        if(flag) {
            result += list.get(minIndex).size;
            list.remove(minIndex);
        }
    }

    static void oneSecOps() {
        for(int i=0; i<list.size(); i++) {
            calc(list.get(i));
        }
    }

    static void calc(Shark shark) {
        // 열 또는 행을 한번 왔다갔다 하는데 1씩 누락된다. 즉 길이가 6인 행을 왔다갔다 왕복하는데는 10이 든다. 12 - 2로 나타낼 수 있음
        int value = 0;
        int tempDir = 0;
        if(shark.direction == 1) {
            if(shark.x == 0) {
                shark.direction = 2;
            }
            if(shark.vel > shark.x) {
                value = shark.vel;
                value -= shark.x;
                tempDir = value/(X - 1);
                if(tempDir % 2 == 0) {
                    shark.direction = 2;
                }
                if(shark.direction == 1) {
                    shark.x = (X - 1) - (value - ((X-1) * tempDir));
                } else {
                    shark.x = value - ((X-1) * tempDir);
                }
            } else {
                // 현재 x 좌표보다 속도가 작을 경우
                // 그냥 뺀 값이 좌표가 된다. 방향전환 없음
                shark.x -= shark.vel;
            }

        } else if(shark.direction == 2) {
            if(shark.x == X - 1) {
                shark.direction = 1;
            }
            if(shark.vel <= (X-1) - shark.x) {
                shark.x += shark.vel;
            } else {
                value = shark.vel;
                value += shark.x;
                tempDir = value/(X-1);
                if(tempDir % 2 == 1) {
                    shark.direction = 1;
                }
                if(shark.direction == 1) {
                    shark.x = (X - 1) - (value - ((X-1) * tempDir));
                } else {
                    shark.x = (value - ((X-1) * tempDir));
                }
            }
        } else if(shark.direction == 3) {
            if(shark.y == Y-1) {
                shark.direction = 4;
            }
            // 남은 y좌표보다 속도가 작을 경우
            // 그냥 더한 값이 좌표가 된다. 방향전환 없음
            if(shark.vel <= (Y-1) - shark.y) {
                shark.y += shark.vel;
            } else {
                value = shark.vel;
                value += shark.y;
                tempDir = value/(Y - 1);
                if(tempDir % 2 == 1) {
                    shark.direction = 4;
                }
                if(shark.direction == 4) {
                    shark.y = (Y - 1) - (value - ((Y-1) * tempDir));
                } else {
                    shark.y = (value - ((Y-1) * tempDir));
                }
            }
        } else {
            // 디펜시브로 일단 걸어두겠다.
            if(shark.y == 0) {
                shark.direction = 3;
            }
            if(shark.vel > shark.y) {
                value = shark.vel;
                value -= shark.y;
                tempDir = value/(Y - 1);
                if(tempDir % 2 == 0) {
                    shark.direction = 3;
                }
                // 홀수인 경우는 왼쪽에서부터 세어야하고, 짝수인 경우는 오른쪽에서부터 세어야 한다.
                if(shark.direction == 3) {
                    shark.y = value - ((Y-1) * tempDir);
                } else {
                    shark.y = (Y-1) - (value - ((Y-1) * tempDir));
                }
            } else {
                // 현재 y 좌표보다 속도가 작을 경우
                // 그냥 뺀 값이 좌표가 된다. 방향전환 없음
                shark.y -= shark.vel;
            }
        }
    }

    static void eatingCheck() {
        for(int i=0; i<list.size(); i++) {
            for(int k=0; k<list.size(); k++) {
                if(i == k)
                    continue;
                if(list.get(i).x == list.get(k).x && list.get(i).y == list.get(k).y) {
                    if(list.get(i).size > list.get(k).size) {
                        list.remove(k);
                    } else if(list.get(i).size < list.get(k).size) {
                        list.remove(i);
                    }
                }
            }
        }
    }

}
