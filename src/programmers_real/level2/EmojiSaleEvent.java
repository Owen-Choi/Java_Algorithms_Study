package programmers_real.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/150368
public class EmojiSaleEvent {
    public static void main(String[] args) {
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emojis = {1300, 1500, 1600, 4900};
        int[] solution = new EmojiSaleEventSolution().solution(users, emojis);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}

class EmojiSaleEventSolution {
    int plusMax = 0;
    int priceMax = 0;

    List<int[]> result = new ArrayList<>();
    int[][] u;
    int[] e;
    public int[] solution(int[][] users, int[] emoticons) {
        // 재귀를 통해서 모든 이모티콘에 대한 모든 할인율을 조사해보자.
        e = emoticons;
        u = users;

        for(int i=10; i<=40; i+=10) {
            recur(new int[users.length], i, 0);
        }

        // 재귀를 돌면서 업데이트된 result를 통해서 정답을 도출
        List<Node> list = new ArrayList<>();
        for (int[] ints : result) {
            int member, price;
            member = price = 0;
            for(int i=0; i<ints.length; i++) {
                if(ints[i] >= users[i][1]) {
                    member++;
                } else {
                    price += ints[i];
                }
            }
            Node node = new Node(member, price);
            list.add(node);
        }

        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.plusMember == o2.plusMember)
                    return o2.totalPrice - o1.totalPrice;
                return o2.plusMember - o1.plusMember;
            }
        });

        return new int[] {list.get(0).plusMember, list.get(0).totalPrice};
    }

    void recur(int[] price, int discount, int depth) {

        if(depth == e.length) {
            result.add(price);
            return;
        }

        int[] newPrice = new int[price.length];
        for(int i=0; i<newPrice.length; i++) {
            newPrice[i] = price[i];
        }

        for(int i=0; i<u.length; i++) {
            if(u[i][0] <= discount) {
                // 사용자가 원하는 할인율을 넘었을 경우 구매
                newPrice[i] += e[depth] * (100 - discount) / 100;
            }
        }

        for(int i=10; i<=40; i+= 10) {
            recur(newPrice, i, depth + 1);
        }

    }

    class Node{
        int plusMember;
        int totalPrice;

        public Node(int plusMember, int totalPrice) {
            this.plusMember = plusMember;
            this.totalPrice = totalPrice;
        }
    }
}
