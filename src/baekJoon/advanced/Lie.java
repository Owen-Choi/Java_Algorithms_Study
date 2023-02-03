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
        detectedParty = new boolean[M];
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
            int come = Integer.parseInt(st.nextToken());
            for(int k=0; k<come; k++) {
                parties[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        int cnt = 0;
        // 3중 for문...
        while(cnt != M) {
            for(int i=0; i<M; i++) {
                for(int k=0; k<parties[i].size(); k++) {
                    if(watcher[parties[i].get(k)]) {
                        detectedParty[i] = true;
                        makeTrueWatcher(i);
                        break;
                    }
                }
            }
            for(int l=0; l<M; l++) {
                if(!detectedParty[l]) {
                    check(l);
                }
            }
            cnt++;
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

    static void check(int i) {
        for(int k=0; k<parties[i].size(); k++) {
            // 한명이라도 해당 파티 내에서 진실을 알고 있다면 flag를 true로 바꿈
            if(watcher[parties[i].get(k)]) {
                detectedParty[k] = true;
                return;
            }
        }
    }

}
