package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 1759번
public class Making_Password {
    static int PwLenght, num;
    static char[] arr;
    static boolean[] flag;          //중복 방지용 배열
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        PwLenght = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        arr = new char[num];
        flag = new boolean[num];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<num; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        //  입력부 종료
        Arrays.sort(arr);       //Sort with Alphabet order
        Find(0, "", false);
        System.out.println(sb);
    }
    static void Find(int index, String sen, boolean checked) {
        if(sen.length() == PwLenght) {
            // 모음을 포함하는지 여부를 check
            if(checked) {
                int tempCount = 0;
                for(int i=0; i<sen.length(); i++) {
                    if(!checkForVowel(sen.charAt(i)))
                        tempCount++;
                }
                if(tempCount >= 2)
                    sb.append(sen).append('\n');
                else
                    return;
            }
            else
                return;
        }
        for(int i=index; i<arr.length; i++) {
           if(!flag[i]) {
               if(sen.length() != 0 && sen.charAt(sen.length() - 1) > arr[i])
                   continue;
               flag[i] = true;
               if(checkForVowel(arr[i]))
                   Find(index+1, sen + arr[i], true);
               else
                   Find(index+1, sen + arr[i], checked);
               flag[i] = false;
           }
        }
    }
    static boolean checkForVowel(char temp) {
        if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u')
            return true;
        else
            return false;
    }
}
