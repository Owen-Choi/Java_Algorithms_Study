package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

// 프로그래머스 레벨2, 전화번호 목록
public class Telephone_List {

    public static void main(String[] args) {
        String[] book = new String[5];
//        book[0] = "119";
//        book[1] = "97674223";
//        book[2] = "1195524421";
        book[0] = "12";
        book[1] = "123";
        book[2] = "1235";
        book[3] = "567";
        book[4] = "88";
        System.out.println(solution(book));
    }

    public static boolean solution(String[] phone_book) {
        // 일단 길이순으로 정렬한 다음 이중 for문 한번만 돌리면 되나?
        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for(int i=0; i< phone_book.length; i++) {
            for(int k=0; k<i; k++) {
                // phone_book[k]의 길이만큼 phone_book[i]를 자르고 일치 여부만 보면 되는거 아닌가?
                String temp = phone_book[i].substring(0, phone_book[k].length());
                if(temp.equals(phone_book[k]))
                    return false;
            }
        }
        return true;
    }
}
