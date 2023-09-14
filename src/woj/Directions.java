package woj;

import java.util.*;

public class Directions {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            ArrayList<Integer> listElement = new ArrayList<>();
            list.add(listElement);
        }

        for(int i=0; i<n; i++) {
            int inputPoint = sc.nextInt();
            int inputColor = sc.nextInt();
            list.get(inputColor - 1).add(inputPoint);
            // 같은 색깔별로 리스트에 묶어서 저장한다.
        }

        long result = 0;
        for(int i=0; i<n; i++) {
            list.get(i).sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            int size = list.get(i).size();
            if(size >= 2) {
                for(int k=0; k<size; k++) {
                    if(k == 0) {
                        result += list.get(i).get(k + 1) - list.get(i).get(k);
                    } else if(k == size - 1) {
                        result += list.get(i).get(k) - list.get(i).get(k - 1);
                    } else {
                        result += Math.min(list.get(i).get(k + 1) - list.get(i).get(k),
                                list.get(i).get(k) - list.get(i).get(k - 1));
                    }
                }
            }
        }
        System.out.println(result);
    }
}
