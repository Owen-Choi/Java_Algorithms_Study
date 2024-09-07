package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이 클래스 때문에 다른 문제를 풀면서 Stack을 선언할 때마다 고통을 받았다.
// 이름을 StackClass로 변경하겠다.
public class StackClass {
    static int [] arr;
    static int crnt = 0;
    // 10828번
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());
        arr = new int[TestCase];
        String Command;
        int value;
        while(TestCase > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Command = st.nextToken();
            if(Command.equals("push")){
                value = Integer.parseInt(st.nextToken());
                push(value);
            }
            else if(Command.equals("pop"))
                System.out.println(pop());
            else if(Command.equals("size"))
                System.out.println(size());
            else if(Command.equals("empty"))
                System.out.println(empty());
            else if(Command.equals("top"))
                System.out.println(top());

            TestCase--;
        }
    }
    static void push(int value){
        arr[crnt++] = value;
    }

    static int pop(){
        if(crnt == 0)
            return -1;
        else{
            crnt--;
            return arr[crnt];
        }
    }
    static int size(){
        return crnt;
    }

    static int empty(){
        if(crnt == 0)
            return 1;
        else
            return 0;
    }

    static int top(){
        if(crnt == 0)
            return -1;
        else
            return arr[crnt-1];
    }
}
