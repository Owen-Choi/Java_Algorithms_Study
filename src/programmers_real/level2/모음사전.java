package programmers_real.level2;

public class 모음사전 {
    public static void main(String[] args) {
        String word = "AAAAE";
        System.out.println(new DictionarySolution().solution(word));
    }
}

class DictionarySolution {
    String w;
    int answer;
    char[] arr = new char[] {'A', 'E', 'I', 'O', 'U'};
    int cnt = 0;
    public int solution(String word) {
        w = word;
        dfs(5, "");
        return answer;
    }

    void dfs(int k, String word) {
        if(word.equals(w)) {
            answer = cnt;
            return;
        }
        cnt++;
        if(word.length() < k) {
            for(int i=0; i<5; i++) {
                dfs(k, word + arr[i]);
            }
        }
    }
}