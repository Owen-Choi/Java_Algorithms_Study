package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HCI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int q;
        q = Integer.parseInt(br.readLine());
        // 알파벳 별로 누적합 배열을 따로 둬도 메모리초과가 발생하지 않을 것이라 생각된다.
        int[][] arr = new int[26][input.length()];
        int[][] sum = new int[26][input.length()];
        for(int i=0; i<input.length(); i++) {
            arr[input.charAt(i) - 'a'][i]++;
        }
        for(int i=0; i<26; i++) {
            sum[i][0] = arr[i][0];
            for(int k=1; k<input.length(); k++) {
                sum[i][k] = sum[i][k-1] + arr[i][k];
            }
        }
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int index = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            sb.append(sum[index][dest] - sum[index][start] + arr[index][start]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
