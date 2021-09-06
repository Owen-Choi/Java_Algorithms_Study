package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1339번
public class Mathmatics_of_Words {
    static int WordNum;
    static int giveNum = 9;
    static String[] arr;
    static Integer[] Alphabets = new Integer[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        WordNum = Integer.parseInt(br.readLine());
        PriorityQueue<String> queue = new PriorityQueue<>(new myComp());
        arr = new String[WordNum];
        for(int i=0; i<WordNum; i++) {
            arr[i] = br.readLine();
            queue.offer(arr[i]);
        }
        // 입력부 종료
        // 길이가 긴 순으로 정렬
        // 연산부
        String temp;
        temp = queue.poll();
        while(!queue.isEmpty()) {
            if(temp.length() >= queue.peek().length()) {
                if(temp.length() == 0) {
                    temp = queue.remove();
                    continue;
                }
                // 이미 할당이 된 알파벳이라면 넘어간다.
                if(Alphabets[temp.charAt(0) - 'A'] == null){
                    Alphabets[temp.charAt(0) - 'A'] = giveNum--;
                }
                if(temp.length() > 0)
                    temp = temp.substring(1);  //앞글자 제거
            }
            else{
                queue.add(temp);            //다시 queue에 넣어주고 순서를 기다린다.
                temp = queue.remove();
            }
        }

    Print();

    }
    static class myComp implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() > o2.length())
                return -1;
            else if(o1.length() < o2.length())
                return 1;
            else
                return 0;
        }
    }
    static void Print() {
        char[] temp;
        int sum = 0;
        StringBuilder sb;
        // 단어가 하나라면
        if(WordNum == 1) {
            sb = new StringBuilder();
            temp = arr[0].toCharArray();
            for (char c : temp) {
                if(Alphabets[c - 'A'] == null)
                    Alphabets[c - 'A'] = giveNum--;
                sb.append(Alphabets[c - 'A']);
            }
            System.out.println(sb);
            System.exit(0);
        }
        else {
            for (int i = 0; i < WordNum; i++) {
                temp = arr[i].toCharArray();
                sb = new StringBuilder();
                for (int k = 0; k < temp.length; k++) {
                    sb.append(Alphabets[temp[k] - 'A']);
                }
                sum += Integer.parseInt(sb.toString());
            }
            System.out.println(sum);
        }
    }
}
