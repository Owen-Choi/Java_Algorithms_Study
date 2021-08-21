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
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            if(arr[stack.peek()] > arr[i]) {
                stack.push(i);
            }
            else if(arr[stack.peek()] < arr[i]) {
                int temp = i;
                while(!stack.isEmpty()) {
                    if(arr[stack.peek()] < arr[temp]) {
                        result[stack.peek()] = arr[temp];
                    }
                    else if(arr[stack.peek()] < arr[i]) {
                        result[stack.peek()] = arr[i];
                    }
                    else{
                        result[stack.peek()] = -1;
                    }
                    temp = stack.pop();
                }
                stack.push(i);
            }
        }
        if(!stack.isEmpty()) {
            while(!stack.isEmpty()) {
                result[stack.pop()] = -1;
            }
        }
        for(int temp : result) {
            bw.write(temp + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
