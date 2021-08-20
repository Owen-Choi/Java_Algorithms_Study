package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
// 9375번
public class Fasion_Leader_Shin {
    static int testCase;
    static int result = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        testCase = Integer.parseInt(br.readLine());
        while(testCase --> 0) {
            HashMap<String, Integer> hash = new HashMap<>();
            int DressNum = Integer.parseInt(br.readLine());
            while( DressNum --> 0) {
                st = new StringTokenizer(br.readLine()," ");
                st.nextToken();     //옷의 이름은 연산에 쓰이지 않으므로 필요 없음
                String temp = st.nextToken();
                if(hash.containsKey(temp)) {
                    hash.put(temp, hash.get(temp) + 1);
                }
                else
                    hash.put(temp, 1);
            }
            for(int value : hash.values()){
                result *= (value + 1);
            }
            sb.append(result - 1).append('\n');
            result = 1;
        }
        System.out.println(sb);
    }
}
