package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

// 프로그래머스 레벨2, 전화번호 목록
public class Telephone_List {

    public static void main(String[] args) {
        String[] book = new String[3];
        book[0] = "123";
        book[1] = "456";
        book[2] = "789";
        System.out.println(solution(book));
    }

    public static boolean solution(String[] phone_book) {
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i=0; i< phone_book.length; i++) {
            hash.put(phone_book[i], i);
        }

        for(int k=0; k< phone_book.length; k++) {
            for(int v = 0; v< phone_book[k].length(); v++) {
                String tempString = phone_book[k].substring(0, v);
                if(hash.containsKey(tempString)) {
                    return false;
                }
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        String[] book = new String[5];
//        book[0] = "12";
//        book[1] = "123";
//        book[2] = "1235";
//        book[3] = "567";
//        book[4] = "88";
//        System.out.println(solution(book));
//    }
//
//    public static boolean solution(String[] phone_book) {
//        Arrays.sort(phone_book, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//        for(int i=0; i< phone_book.length; i++) {
//            for(int k=0; k<i; k++) {
//                String temp = phone_book[i].substring(0, phone_book[k].length());
//                if(temp.equals(phone_book[k]))
//                    return false;
//            }
//        }
//        return true;
//    }
}
