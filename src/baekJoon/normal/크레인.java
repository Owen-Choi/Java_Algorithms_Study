package baekJoon.normal;

import java.io.*;
import java.util.*;
public class 크레인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> box = new ArrayList<>();
        for(int i=0; i<m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        // 시간 초과 우려됨
        box.sort(Comparator.reverseOrder());
        list.sort(Comparator.reverseOrder());

        if(list.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }
        // 각 크레인은 본인이 처리할 수 있는 가장 큰 박스를 처리해야함.
        // 그렇지 않고 그냥 가능한 박스를 계속해서 처리할 경우 뒤에서 큰 박스만 남아 몇몇 크레인은 놀 수도 있음
        int minute = 0;
        while(!box.isEmpty()) {
            int listIndex = 0, boxIndex = 0;
            while(listIndex < n) {
                if(boxIndex == box.size()) {
                    break;
                }
                if(list.get(listIndex) >= box.get(boxIndex)) {
                    box.remove(boxIndex);
                    listIndex++;
                } else {
                    boxIndex++;
                }
            }
            minute++;
        }
        System.out.println(minute);
    }

}
