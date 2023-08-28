package programmers_real.level2;

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
    int[][] u;
    int[] e;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        // 재귀를 통해서 모든 이모티콘에 대한 모든 할인율을 조사해보자.
        e = emoticons;
        u = users;
        return answer;
    }

    public void recur() {
        // 종료 컨디션

        for(int i=0; i<e.length; i++) {
            
        }
    }
}
