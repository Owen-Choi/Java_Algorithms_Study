package programmers.level2;

public class Predicted_table {

    public static void main(String[] args) {
        System.out.println(solution(8,2,4));
    }

    public static int solution(int n, int a, int b)
    {
        int round = 1;
        int half = n;
        while(true) {
            half /= 2;
            if(half == 1)
                break;
            if(Math.abs(a - b) == 1) {
                if(!((a > half && b <= half) || (a <= half && b > half))) {
                    break;
                }
            }
            a = a % 2 == 0 ? (a / 2) : (a + 1) / 2;
            b = b % 2 == 0 ? (b / 2) : (b + 1) / 2;
            round++;
        }
        return round;
    }
}