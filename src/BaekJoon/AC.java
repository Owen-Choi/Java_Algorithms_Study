package BaekJoon;

import java.io.*;
import java.util.LinkedList;

// 5430번
public class AC {
    static int TestCase;
    static boolean reverse = false, Error = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String Sen, temp, Iterator = null;
        String[] Sarr;
        TestCase = Integer.parseInt(br.readLine());
        int Num, k = 0;
        int[] arr;
        LinkedList<Integer> deque;
        while(TestCase --> 0) {
            deque = new LinkedList<>();

            // 수행할 명령을 받음
            Sen = br.readLine();
            Num = Integer.parseInt(br.readLine());
            arr = new int[Num];
            temp = br.readLine();
            temp = temp.substring(1, temp.length() - 1);
            Sarr = temp.split(",");
            for(int i=0; i<Num; i++) {
                arr[i] = Integer.parseInt(Sarr[i]);
                deque.offer(arr[i]);
            }
            // 입력부
            //연산부
            reverse = false;
            sb.append("[");
            for(int i=0; i<Sen.length(); i++) {
                if(Sen.charAt(i) == 'R')
                    reverse = !reverse;
                if(Sen.charAt(i) == 'D') {
                    if(deque.isEmpty()) {

                        sb.append("error").append('\n');
                        Error = true;
                        break;
                    }
                }
            }
            if(Error) {
                Error = false;
                continue;
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("]").append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
