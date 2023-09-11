//package programmers_real.level2;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class Parking {
//    public static void main(String[] args) {
//        // 기본시간, 기본 요금, 단위 시간, 단위 요금
//        int[] fees = {180, 5000, 10, 600};
//        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
//                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
//        int[] solution = new ParkingSolution().solution(fees, records);
////        for (int i : solution) {
////            System.out.print(i + " ");
////        }
//    }
//}
//
//class ParkingSolution {
//    public int[] solution(int[] fees, String[] records) {
//        // key : 차량 번호, value : 입차시간
//        Map<String, Integer> map = new HashMap<>();
//        // 차량별로 결과를 담기 위한 hashMap, 순서를 보장하기 위해 LinkedHashMap 사용
//        Map<String, Integer> result = new LinkedHashMap<>();
//        for(int i=0; i<records.length; i++) {
//            String[] tokens = records[i].split(" ");
//            // 시간값 파싱
//            String[] timeToken = tokens[0].split(":");
//            int time = Integer.parseInt(timeToken[0]) * 60 + Integer.parseInt(timeToken[1]);
//            // 차량 번호로 map 조회
//            if(map.containsKey(tokens[1])) {
//                // 기존에 입차했던 차량이 있으면 시간 차이 계산해서 요금 계산 후 출차 처리 (map에서 제거)
//                int parkingTime = time - map.get(tokens[1]);
//                // 기본 요금일 경우
//                if(parkingTime <= fees[0]) {
//                    if(result.containsKey(tokens[1])) {
//                        // 만약 이전에 한번 입차를 했던 차량이라 map에 값이 있다면, 이번 주차 요금을 기존 요금에 추가
//                        result.put(tokens[1], result.get(tokens[1]) + fees[1]);
//                    } else {
//                        // 이전에 주차 기록이 없는 새로운 차라면, map에 추가
//                        result.put(tokens[1], fees[1]);
//                    }
//                    map.remove(tokens[1]);
//                } else {
//                    // 기본 요금을 넘어서는 경우
//                    int price = fees[1] + (int)Math.ceil(((parkingTime - fees[0]) / fees[2])) * fees[3];
//                    if(result.containsKey(tokens[1])) {
//                        // 만약 이전에 한번 입차를 했던 차량이라 map에 값이 있다면, 이번 주차 요금을 기존 요금에 추가
//                        result.put(tokens[1], result.get(tokens[1]) + price);
//                    } else {
//                        // 이전에 주차 기록이 없는 새로운 차라면, map에 추가
//                        result.put(tokens[1], price);
//                    }
//                    map.remove(tokens[1]);
//                }
//            } else map.put(tokens[1], time); // 새로 입차한 차량이기 떄문에 map에 저장해줌
//        }
//        // 반복문이 종료된 이후에 map에 남아있는 차가 있다면 23:59 시에 출차한 것으로 계산
//        for (String s : map.keySet()) {
//            int parkingTime = 1439 - map.get(s);
//            if(parkingTime <= fees[0]) {
//                // 이전에도 왔었던 차라면
//                if(result.containsKey(s)) {
//                    result.put(s, result.get(s) + fees[1]);
//                } else {
//                    result.put(s, fees[1]);
//                }
//            } else {
//                int price = fees[1] + (int)Math.ceil(((parkingTime - fees[0]) / fees[2])) * fees[3];
//                if(result.containsKey(s)) {
//                    result.put(s, result.get(s) + price);
//                } else {
//                    result.put(s, price);
//                }
//            }
//        }
//
//        int[] answer = new int[result.size()];
//        int counter = 0;
//        // result 해쉬맵에 있는 값들을 배열로 변환 후 반환
//        for (String s : result.keySet()) {
//            System.out.print(result.get(s) + " ");
//            answer[counter++] = result.get(s);
//        }
//        return answer;
//    }
//}

// 문제를 제대로 안읽어서 주차시간이 누적으로 적용되는지 몰랐다.
// 그래서 1분씩 주차를 2번 하더라도 5000원이 아니라 10000이 나오게 됐음.

package programmers_real.level2;

import java.util.*;

public class Parking {
    public static void main(String[] args) {
        // 기본시간, 기본 요금, 단위 시간, 단위 요금
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] solution = new ParkingSolution().solution(fees, records);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}

class ParkingSolution {
    public int[] solution(int[] fees, String[] records) {
        // key : 차량 번호, value : 입차시간
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        for(int i=0; i<records.length; i++) {
            String[] tokens = records[i].split(" ");
            // 시간값 파싱
            String[] timeToken = tokens[0].split(":");
            int time = Integer.parseInt(timeToken[0]) * 60 + Integer.parseInt(timeToken[1]);
            // 차량 번호로 map 조회
            if(map.containsKey(tokens[1])) {
                // 기존에 입차했던 차량이 있으면 시간 차이 계산해서 요금 계산 후 출차 처리 (map에서 제거)
                int parkingTime = time - map.get(tokens[1]);
                if(result.containsKey(tokens[1])) {
                    // 이전에 왔었던 차일 경우
                    result.put(tokens[1], result.get(tokens[1]) + parkingTime);
                } else {
                    result.put(tokens[1], parkingTime);
                }
                map.remove(tokens[1]);
            } else map.put(tokens[1], time); // 새로 입차한 차량이기 떄문에 map에 저장해줌
        }
        // 반복문이 종료된 이후에 map에 남아있는 차가 있다면 23:59 시에 출차한 것으로 계산
        for (String s : map.keySet()) {
            int parkingTime = 1439 - map.get(s);
            if(result.containsKey(s)) {
                // 이전에 왔었던 차일 경우
                result.put(s, result.get(s) + parkingTime);
            } else {
                result.put(s, parkingTime);
            }
        }

        int[] answer = new int[result.size()];
        int counter = 0;
        // result 해쉬맵에 있는 값들을 배열로 변환 후 반환
        for (String s : result.keySet()) {
            int price;
            if(fees[0] < result.get(s)) {
                // float으로 형 변환을 안해줘서 피를 봤다. 다음부턴 주의하자.
                price = fees[1] + (int)Math.ceil((float)(result.get(s) - fees[0]) / fees[2]) * fees[3];
            } else price = fees[1];
            result.put(s, price);
        }

        List<String> keyList = new ArrayList<>(result.keySet());
        keyList.sort((s1,s2) -> s1.compareTo(s2));
        for (String s : keyList) {
            answer[counter++] = result.get(s);
        }
        return answer;
    }
}
