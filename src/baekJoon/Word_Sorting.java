package baekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class Word_Sorting {
    static int WordNum;
    static String[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        WordNum = Integer.parseInt(br.readLine());
        arr = new String[WordNum];
        for(int i=0; i<WordNum; i++)
            arr[i] = br.readLine();
        Arrays.sort(arr, new MyComparator());
        // LinkedHashSet : Set의 형태로 중복을 제거하지만 순서는 지킨다.
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(Arrays.asList(arr));
        String[] result = hashSet.toArray(new String[0]);
        for (String s : result) {
            System.out.println(s);
        }
    }
    static class MyComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() < o2.length())
                return -1;
            else if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }
            return 1;
        }
    }
}
