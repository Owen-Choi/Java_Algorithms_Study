package programmers_real.level2;

public class MagicElevator {
    public static void main(String[] args) {
        System.out.println(new MagicElevatorSolution().solution(15));
    }
}

class MagicElevatorSolution {
    public int solution(int storey) {
        int counter = 0;
        boolean flag;
        while(storey > 0) {
            flag = false;
            int last = storey % 10;
            if(last < 5) {
                counter += last;
            } else if(last > 5) {
                counter += 10 - last;
                flag = true;
            } else {
                // 145 일때는 아래층으로 5칸 가서 140으로 만드는게 이득이다.
                // 155일때는 위층으로 5칸 가서 160으로 만드는게 이득이다.
                if(storey > 10) {
                    if((storey / 10) % 10 >= 5) {
                         flag = true;
                    }
                }
                counter += 5;
            }
            storey /= 10;
            if(flag) {
                storey++;
            }
        }
        return counter;
    }
}
