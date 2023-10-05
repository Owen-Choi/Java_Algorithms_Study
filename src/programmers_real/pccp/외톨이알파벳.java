package programmers_real.pccp;

import java.util.*;
public class 외톨이알파벳 {
    public static void main(String[] args) {
        String input = "edeaaabbccd";
        System.out.println(new LonelyAlphabetSolution().solution(input));
    }
}

class LonelyAlphabetSolution {
    public String solution(String input) {
        String result = "";
        boolean[] flag = new boolean[10000];
        char prev = input.charAt(0);
        // 이전 문자를 확인하면서 현재 문자와 비교. 그래서 반복문은 1부터 시작
        // 반복문 종료 이후 확인하지 못한 마지막 문자 한개도 추가적으로 확인해주기
        int i;
        for(i=1; i<input.length(); i++) {
            char temp = input.charAt(i);
            if(prev != temp) {
                if(!flag[prev - 'a']) flag[prev - 'a'] = true;
                else {
                    result += Character.toString(prev);
                }
            }
            prev = temp;
        }
        if(flag[input.charAt(i - 1) - 'a']) {
            result += Character.toString(input.charAt(i-1));
        }
        char[] resultArr = result.toCharArray();
        Arrays.sort(resultArr);
        result = "";
        prev = 0;
        for(i=0; i<resultArr.length; i++) {
            if(prev != resultArr[i])
                result += resultArr[i];
            prev = resultArr[i];
        }
        if(result.equals("")) return "N";
        return result;
    }
}