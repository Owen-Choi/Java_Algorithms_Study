package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class who_didnt_submit_assignment {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] submitter = new boolean[30];
        for(int i=0; i<28; i++) {
            submitter[Integer.parseInt(br.readLine()) - 1] = true;
        }
        for(int i=0; i<submitter.length; i++) {
            if(!submitter[i]) {
                System.out.println(i + 1);
            }
        }
    }
}
