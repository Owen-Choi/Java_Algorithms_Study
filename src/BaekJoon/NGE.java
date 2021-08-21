package BaekJoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
// 17298번
public class NGE {
    static int N;
    static int [] arr;
    static int [] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        if(!stack.isEmpty()) {
            while(!stack.isEmpty()) {
                arr[stack.pop()] = -1;
            }
        }
        for(int temp : arr) {
            bw.write(temp + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
