package programmers_real.level3;

import java.util.*;
public class ParsingWord {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        new ParsingWordSolution().solution(begin, target, words);
    }
}

class ParsingWordSolution {
    String[] w;
    boolean[] flag;
    String t;
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        w = words;
        t = target;
        flag = new boolean[words.length];
        dfs(begin, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    void dfs(String current, int count) {
        if(current.equals(t)) {
            answer = Math.min(answer, count);
            return;
        }
        for(int i=0; i<w.length; i++) {
            if(!flag[i] && check(current, w[i])) {
                flag[i] = true;
                dfs(w[i], count+1);
                flag[i] = false;
            }
        }
    }

    boolean check(String s1, String s2) {
        int counter = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(i))
                counter++;
        }
        return counter == s1.length() - 1;
    }
}
