package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 17143, 낚시왕, 골드1, 구현, 타인 풀이 참고 (주석이 기존에 내가 짰던 코드)
public class King_Of_Fishing {

    public static int R, C, M;
    public static Shark[][] map;
    public static int result = 0;
    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, -1, 0, 1};


    static class Shark {
        int r;
        int c;
        int velocity;
        int direction;
        int size;

        public Shark(int r, int c, int velocity, int direction, int size) {
            this.r = r;
            this.c = c;
            this.velocity = velocity;
            this.direction = direction;
            this.size = size;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];
        // 상어 수 만큼
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if(d == 1)
                d = 0;
            else if(d == 4)
                d = 1;
            map[r-1][c-1] = new Shark(r-1, c-1, s,d,z);
        }

        // 로직 시작
        for(int y=0; y<C; y++) {

            // 어부가 움직인 뒤 가장 가까운 물고기를 잡는다.
            for(int x=0; x<R; x++) {
                if(map[x][y] != null) {
                    result += map[x][y].size;
                    map[x][y] = null;
                    break;
                }
            }

            // 상어를 이동시킨다.
            // 현재 맵에 있는 큐에 추가한다.
            Queue<Shark> queue = new LinkedList<>();
            for(int i=0; i < R; i++) {
                for(int k=0; k<C; k++) {
                    if(map[i][k] != null) {
                        queue.add(new Shark(i, k, map[i][k].velocity, map[i][k].direction, map[i][k].size));
                    }
                }
            }

            map = new Shark[R][C];
            while(!queue.isEmpty()) {
                Shark shark = queue.poll();

                int minimumMove = shark.velocity;
                if(shark.direction == 0 || shark.direction == 2)
                    minimumMove %= (R-1) * 2;
                else if(shark.direction == 1 || shark.direction == 3) {
                    minimumMove %= (C-1) * 2;
                }

                for(int s = 0; s < minimumMove; s++) {
                    int tempR = shark.r + dx[shark.direction];
                    int tempC = shark.c + dy[shark.direction];

                    if(tempR < 0 || tempR >= R || tempC < 0 || tempC >= C) {
                        shark.r -= dx[shark.direction];
                        shark.c -= dy[shark.direction];
                        shark.direction = (shark.direction + 2) % 4;
                        continue;
                    }
                    shark.r = tempR;
                    shark.c = tempC;
                }

                //
                if(map[shark.r][shark.c] != null) {
                    if(map[shark.r][shark.c].size < shark.size) {
                        map[shark.r][shark.c] = new Shark(shark.r, shark.c, shark.velocity, shark.direction, shark.size);
                    }
                } else {
                    map[shark.r][shark.c] = new Shark(shark.r, shark.c, shark.velocity, shark.direction, shark.size);
                }
            }
        }
        System.out.println(result);
    }
}
//    static int X, Y, M;
//    static List<Shark> list;
//    static int result = 0;
//    static class Shark {
//        int x;
//        int y;
//        int size;
//        int vel;
//        int direction;
//
//        public Shark(int x, int y, int v, int d, int s) {
//            this.x = x;
//            this.y = y;
//            this.size = s;
//            this.vel = v;
//            this.direction = d;
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        X = Integer.parseInt(st.nextToken());
//        Y = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        list = new ArrayList<>();
//        for(int i=0; i<M; i++) {
//            st = new StringTokenizer(br.readLine()," ");
//            int x = Integer.parseInt(st.nextToken()) - 1;
//            int y = Integer.parseInt(st.nextToken()) - 1;
//            int v = Integer.parseInt(st.nextToken());
//            int d = Integer.parseInt(st.nextToken());
//            int s = Integer.parseInt(st.nextToken());
//            Shark shark = new Shark(x,y,v,d,s);
//            list.add(shark);
//        }
//        for(int i=0; i<Y; i++) {
//            // 1. 먼저 상어 잡고
//            catchUp(i);
//
//            // 2. 상어들 이동시킴
//            oneSecOps();
//
//            // 3. 잡아먹히는 상어가 있는지 체크
//            eatingCheck();
//        }
//
//        System.out.println(result);
//    }
//
//    static void catchUp(int y) {
//        int minIndex = 0;
//        int minValue = Integer.MAX_VALUE;
//        boolean flag = false;
//        for(int i=0; i<list.size(); i++) {
//            if(list.get(i).y == y) {
//                if(minValue > list.get(i).x) {
//                    minIndex = i;
//                    minValue = list.get(i).x;
//                    flag = true;
//                }
//            }
//        }
//        if(flag) {
//            result += list.get(minIndex).size;
//            list.remove(minIndex);
//        }
//    }
//
//    static void oneSecOps() {
//        for(int i=0; i<list.size(); i++) {
//            calc(list.get(i));
//        }
//    }
//
//    static void calc(Shark shark) {
//        int value = 0;
//        int tempDir = 0;
//        if(shark.direction == 1) {
////            if(shark.x == 0) {
////                shark.direction = 2;
////            }
//            if(shark.vel > shark.x) {
//                value = shark.vel;
//                value -= shark.x;
//                tempDir = value/(X - 1);
//                if(tempDir % 2 == 0) {
//                    shark.direction = 2;
//                }
//                if(shark.direction == 1) {
//                    shark.x = (X - 1) - (value - ((X-1) * tempDir));
//                } else {
//                    shark.x = value - ((X-1) * tempDir);
//                }
//            } else {
//                // 현재 x 좌표보다 속도가 작을 경우
//                // 그냥 뺀 값이 좌표가 된다. 방향전환 없음
//                shark.x -= shark.vel;
//            }
//
//        } else if(shark.direction == 2) {
////            if(shark.x == X - 1) {
////                shark.direction = 1;
////            }
//            if(shark.vel <= (X-1) - shark.x) {
//                shark.x += shark.vel;
//            } else {
//                value = shark.vel;
//                value += shark.x;
//                tempDir = value/(X-1);
//                if(tempDir % 2 == 1) {
//                    shark.direction = 1;
//                }
//                if(shark.direction == 1) {
//                    shark.x = (X - 1) - (value - ((X-1) * tempDir));
//                } else {
//                    shark.x = (value - ((X-1) * tempDir));
//                }
//            }
//        } else if(shark.direction == 3) {
////            if(shark.y == Y-1) {
////                shark.direction = 4;
////            }
//            // 남은 y좌표보다 속도가 작을 경우
//            // 그냥 더한 값이 좌표가 된다. 방향전환 없음
//            if(shark.vel <= (Y-1) - shark.y) {
//                shark.y += shark.vel;
//            } else {
//                value = shark.vel;
//                value += shark.y;
//                tempDir = value/(Y - 1);
//                if(tempDir % 2 == 1) {
//                    shark.direction = 4;
//                }
//                if(shark.direction == 4) {
//                    shark.y = (Y - 1) - (value - ((Y-1) * tempDir));
//                } else {
//                    shark.y = (value - ((Y-1) * tempDir));
//                }
//            }
//        } else {
//            // 디펜시브로 일단 걸어두겠다.
////            if(shark.y == 0) {
////                shark.direction = 3;
////            }
//            if(shark.vel > shark.y) {
//                value = shark.vel;
//                value -= shark.y;
//                tempDir = value/(Y - 1);
//                if(tempDir % 2 == 0) {
//                    shark.direction = 3;
//                }
//                // 홀수인 경우는 왼쪽에서부터 세어야하고, 짝수인 경우는 오른쪽에서부터 세어야 한다.
//                if(shark.direction == 3) {
//                    shark.y = value - ((Y-1) * tempDir);
//                } else {
//                    shark.y = (Y-1) - (value - ((Y-1) * tempDir));
//                }
//            } else {
//                // 현재 y 좌표보다 속도가 작을 경우
//                // 그냥 뺀 값이 좌표가 된다. 방향전환 없음
//                shark.y -= shark.vel;
//            }
//        }
//    }
//
//    static class SharkAndIndex {
//        Shark shark;
//        int index;
//
//        public SharkAndIndex(Shark s, int i) {
//            this.shark = s;
//            this.index = i;
//        }
//    }
//
//    static void eatingCheck() {
//
//        List<SharkAndIndex> lsa = new ArrayList<>();
//        boolean flag = false;
//        for(int i=0; i<list.size(); i++) {
//            for(int k=0; k<list.size(); k++) {
//                if(i == k)
//                    continue;
//                if(list.get(i).x == list.get(k).x && list.get(i).y == list.get(k).y) {
//                    flag = true;
//                    if(list.get(i).size > list.get(k).size) {
//                        SharkAndIndex sai = new SharkAndIndex(list.get(i), i);
//                        lsa.add(sai);
//                    } else if(list.get(i).size < list.get(k).size) {
//                        SharkAndIndex sai = new SharkAndIndex(list.get(k), k);
//                        lsa.add(sai);
//                    }
//                }
//            }
//        }
//
//        if(flag) {
//            int tempx, tempy;
//            tempx = lsa.get(0).shark.x;
//            tempy = lsa.get(0).shark.y;
//            lsa.sort(new Comparator<SharkAndIndex>() {
//                @Override
//                public int compare(SharkAndIndex o1, SharkAndIndex o2) {
//                    if(o1.shark.x == o2.shark.x && o1.shark.y == o2.shark.y)
//                        return o1.shark.size - o2.shark.size;
//                    if(o1.shark.x == o2.shark.x)
//                        return o1.shark.y - o2.shark.y;
//                    return o1.shark.x - o2.shark.x;
//                }
//            });
//            for(int i=1; i<lsa.size(); i++) {
//                if(lsa.get(i).shark.x != tempx && lsa.get(i).shark.y != tempy) {
//                    // 좌표가 달라지는 부분에서 이전 리스트의 값을 없애면 된다.
//                    list.remove(lsa.get(i-1).index);
//                }
//            }
//        }
//    }
