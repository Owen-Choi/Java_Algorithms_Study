package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
// 1946번
public class Fresh_Salaryman {
    static int testCase;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        int pn;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int pass;
        while(testCase --> 0) {
            pn = Integer.parseInt(br.readLine());
            pass = 1;
            arr = new int[pn][2];
            for(int i=0; i<pn; i++) {
                st = new StringTokenizer(br.readLine()," ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            // 입력부 끝
            Arrays.sort(arr, new myComp());
            int last = arr[0][1];
            for(int i=1; i<pn; i++){
                if(arr[i][1] < last){
                    pass++;
                    last = arr[i][1];
                }
            }
            sb.append(pass).append('\n');
        }
        System.out.println(sb);
    }
    static class myComp implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] < o2[0])
                return -1;
            else if(o1[0] > o2[0])
                return 1;
            else
                return 0;
        }
    }
}
