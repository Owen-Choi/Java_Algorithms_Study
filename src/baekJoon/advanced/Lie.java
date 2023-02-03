package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 1043, 거짓말, 골드 4
public class Lie {

    static int N;
    static int M;
    static boolean[] watcher;
    static List<Integer>[] meetings;
    static List<Integer>[] parties;
    static int result = 0;
    static boolean[] detectedParty;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        watcher = new boolean[N];
        parties = new ArrayList[M];
        meetings = new ArrayList[N];
        detectedParty = new boolean[N];
        for(int i=0; i<N; i++) {
            meetings[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            parties[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine(), " ");
        int truth = Integer.parseInt(st.nextToken());
        for(int i=0; i<truth; i++) {
            watcher[Integer.parseInt(st.nextToken()) - 1] = true;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            parties[i].add(Integer.parseInt(st.nextToken()) - 1);
        }

        boolean flag = true;
        // 3중 for문...
        while(flag) {
            flag = false;
            for(int i=0; i<M; i++) {
                for(int k=0; k<parties[i].size(); k++) {
                    if(watcher[parties[i].get(k)]) {
                        flag = true;
                        detectedParty[i] = true;
                        makeTrueWatcher(i);
                        break;
                    }
                }
            }
            for(int l=0; l<M; l++) {
                if(!detectedParty[l]) {
                    flag = check(l);
                }
            }
        }

        for(int i=0; i<M; i++) {
            if(!detectedParty[i])
                result++;
        }
        System.out.println(result);
    }

    static void makeTrueWatcher(int i) {
        for(int k=0; k<parties[i].size(); k++) {
            watcher[parties[i].get(k)] = true;
        }
    }

    static boolean check(int i) {
        for(int k=0; k<parties[i].size(); k++) {
            if(watcher[parties[i].get(k)]) {
                detectedParty[k] = true;
                return true;
            }
        }
        return false;
    }

}
