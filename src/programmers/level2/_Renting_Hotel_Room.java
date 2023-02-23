package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _Renting_Hotel_Room {

    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
//        String[][] book_time = {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};
        System.out.println(solution(book_time));
    }

    public static int solution(String[][] book_time) {
        List<Integer> rooms = new ArrayList<>();
        int[][] numberTime = new int[book_time.length][2];
        for(int i=0; i< book_time.length; i++) {
            // 여기서 분 단위로 환산한 뒤 저장하도록 한다.
            int startHourWithMin = Integer.parseInt(book_time[i][0].substring(0,2));
            int startMinuteWithMin = Integer.parseInt(book_time[i][0].substring(3,5));
            numberTime[i][0] = (startHourWithMin * 60) + startMinuteWithMin;

            int endHourWithMin = Integer.parseInt(book_time[i][1].substring(0,2));
            int endMinuteWithMin = Integer.parseInt(book_time[i][1].substring(3,5));
            numberTime[i][1] = (endHourWithMin * 60) + endMinuteWithMin + 10;   // 청소시간을 포함한 10분을 여기서 미리 더해준다.
        }

        Arrays.sort(numberTime, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        rooms.add(numberTime[0][1]);
        int min;
        int minIndex = 0;
        boolean flag;
        for(int i=1; i< book_time.length; i++) {
            flag = false;
            min  = Integer.MAX_VALUE;
            for(int k=0; k<rooms.size(); k++) {
                 if(rooms.get(k) <= numberTime[i][0]) {
                    // 제일 끝나는 시간이 이른 곳과 바꿔줌.
                     flag = true;
                    if(min >= rooms.get(k)) {
                        min = rooms.get(k);
                        minIndex = k;
                    }
                }
            }
            if(flag) {
                rooms.set(minIndex, numberTime[i][1]);
            } else {
                rooms.add(numberTime[i][1]);
            }
        }

        return rooms.size();
    }
}
