package programmers_real.level2;

import java.util.*;
public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] st = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(new SkillTreeSolution().solution(skill, st));
    }
}
class SkillTreeSolution {
    public int solution(String skill, String[] st) {
        Map<Character, Boolean> map = new HashMap<>();
        int answer = 0;
        int counter = 0;
        for(int i=0; i<skill.length(); i++)
            map.put(skill.charAt(i), true);

        boolean flag;
        for(int i=0; i<st.length; i++) {
            counter = 0;
            flag = false;
            for(int k=0; k<st[i].length(); k++) {
                if(counter < skill.length() && st[i].charAt(k) == skill.charAt(counter)) {
                    counter++;
                }
                else {
                    if(map.containsKey(st[i].charAt(k))) {
                        // 이번에 배워야 할 순서의 스킬이 아니면서 map에도 포함된 문자라면
                        // 불가능한 스킬트리를 의미함.
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag)
                answer++;
        }
        return answer;
    }
}
