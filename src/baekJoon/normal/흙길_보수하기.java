package baekJoon.normal;

import java.util.*;
import java.io.*;

/*
    TODO 반례
    4 3
    1 3
    3 5
    5 7
    8 11
    ans : 3
    output : 4
 */
public class 흙길_보수하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[0] - p2[0]);
        int start, end;
        // 판자의 길이가 1이고, 길이가 10억인 웅덩이가 여러 개 나온다면 금방 정수의 범위를 넘어서게 된다.
        long result = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{start, end});
        }
        // 웅덩이의 각 길이가 너무 길다. 나눗셈을 적절히 활용해보자.
        // 1 6 이라면 길이가 5이다. 5 / 3 은 1이고, 나머지가 있으니 1을 더해준다.
        // 그리고 뒷 웅덩이가 남은 널빤지 길이로 영향을 받을 정도로 가까이 있다면, 값을 더해준다.
        int[] peek, temp;
        int len, remainder;
        for(int i=0; i<n && !pq.isEmpty(); i++) {
            peek = pq.peek();
            len = peek[1] - peek[0];
            // 나눈 값이 0이라면 판자랑 길이가 딱 맞는 웅덩이. 몫만 더해준다.
            if(len % l == 0) {
                result += len / l;
                pq.poll();
            } else {
                // 아닐 때가 중요한데, 바로 뒷 웅덩이가 남은 판자로 덮을 수 있을 정도로 가까이 있다면 값을 업데이트 해준다.
                // 웅덩이가 더 짧을 수도 있다. 그럴 때는 1을 더해준다.
                if(len <= l) {
                    result += 1;
                    remainder = l - len;
                } else {
                    result += (len / l) + 1;
                    remainder = l * ((len / l) + 1) - len;
                }
                pq.poll();
                if(pq.isEmpty()) break;
                // if l == 6, pool == (3 4 5) (7 8 9)
                // (1 2 3 4 5) 6 7 (8 9 10)
                if(peek[1] + remainder - 1 >= pq.peek()[0]) {
                    // 남은 판자가 웅덩이를 커버할 때 까지 반복문을 돌려준다.
                    while(!pq.isEmpty() && peek[1] + remainder >= pq.peek()[1]) {
                        pq.poll();
                    }
                    // 반복문을 나왔다면 기존 큐의 값을 지우고, 새로운 시작점을 가진 큐를 다시 넣어준다.
                    if(pq.isEmpty()) {
                        // 남은 판자가 남은 웅덩이를 다 커버한 상황. 여기서 종료한다.
                        break;
                    }
                    // 반례가 없을까
                    if(pq.peek()[0] <= peek[1] + remainder) {
                        temp = pq.poll();
                        temp[0] = peek[1] + remainder;
                        pq.offer(temp);
                    }
                }
            }
        }

        System.out.println(result);
    }

}





// 아래는 정답을 맞춘 후 참고한 타인의 풀이. 다음에는 아래처럼 깔끔하게 짜보자.
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    static class puddle implements Comparable<puddle>{
//        int from, to;
//        puddle(int a, int b){
//            from=a;
//            to=b;
//        }
//
//        @Override
//        public int compareTo(puddle o) {
//            return this.from-o.from;
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(br.readLine());
//        int N= Integer.parseInt(st.nextToken());
//        int L= Integer.parseInt(st.nextToken());
//        PriorityQueue<puddle> pq=new PriorityQueue<>();
//        for(int i=0; i<N; i++){
//            st=new StringTokenizer(br.readLine());
//            pq.add(new puddle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
//        }
//        int pointer=0;
//        int answer=0;
//        while(!pq.isEmpty()){
//            // 가장 가까운 웅덩이를 가져와서
//            puddle temp=pq.poll();
//            // 가져온 웅덩이의 시작점과 pointer를 비교함. pointer는 판자가 커버하는 제일 끝 위치.
//            // 아 진짜 잘짰다,,
//            pointer=Math.max(temp.from,pointer);
//            // 포인터가 다응 웅덩이의 끝나는 지점보다 더 크다면 ( == 판자가 웅덩이를 커버할 수 있다면) continue
//            if(pointer>=temp.to) continue;
//            int tp = (int) Math.ceil((double)(temp.to-pointer)/(double)L);
//            answer+=tp;
//            // 마지막으로 판자가 커버하는 위치를 포인터에 저장해 줌.
//            pointer+=tp*L;
//        }
//        System.out.println(answer);
//    }
//}
