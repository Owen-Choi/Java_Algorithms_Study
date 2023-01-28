package programmers.level1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Personal_information_validity {
    public static void main(String[] args) throws IOException {
//        String today = "2022.05.19";
//        String[] terms = {"A 6", "B 12", "C 3"};
//        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2020.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        int[] termInfo = new int[26];
        StringTokenizer st;
        st = new StringTokenizer(today, ".");
        int ty = Integer.parseInt(st.nextToken());
        int tm = Integer.parseInt(st.nextToken());
        int td = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<terms.length; i++) {
            st = new StringTokenizer(terms[i], " ");
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            termInfo[(int)s1.charAt(0) - 65] = Integer.parseInt(s2);
        }
        for(int i=0; i<privacies.length; i++) {
            st = new StringTokenizer(privacies[i], " ");
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            int todayTotalDate = 0;
            int totalDate = 0;
            st = new StringTokenizer(s1, ".");
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            // 연도를 같은 연도로 맞추고 총 일수로 비교한다.
            if(ty > y) {
                int proxyTy = ty;
                while(proxyTy != y) {
                    proxyTy--;
                    todayTotalDate += 336;
                }
            }
            todayTotalDate += (tm - 1)*28;
            todayTotalDate += td;
            totalDate += (m - 1)*28;
            totalDate += d - 1;
            if(totalDate + (termInfo[(int)s2.charAt(0) - 65] * 28) < todayTotalDate) {
                sb.append(i + 1).append(",");
            }
        }
        System.out.println(sb.toString().substring(0, sb.toString().length() - 1));
    }
}
