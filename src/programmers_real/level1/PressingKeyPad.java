package programmers_real.level1;

import java.util.*;
public class PressingKeyPad {
    public static void main(String[] args) {
//        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
//        String hand = "right";
        String hand = "left";
        System.out.println(new PressingKeyPadSolution().solution(numbers, hand));
    }
}


class PressingKeyPadSolution {
    int cl = 0, cr = 0;
    int[][] map = {{1,2,3}, {4,5,6}, {7,8,9}, {-1,0,-1}};
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                cl = numbers[i];
                sb.append("L");
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                cr = numbers[i];
                sb.append("R");
            } else {
                sb.append(findDist(numbers[i], hand));
            }
        }
        return sb.toString();
    }

    String findDist(int target, String hand) {
        int lDist = 0, rDist = 0;
        int x,y;
        if(cl == 0) {
            x = 3;
            y = 1;
            while(map[x][y] != target) {
                x--;
                lDist++;
            }
        } else {
            if(cl == 1 || cl == 4 || cl == 7) {
                lDist++;
                y = 1;
                if(cl == 1) x = 0;
                else if(cl == 4) x = 1;
                else x = 2;
            } else {
                y = 1;
                if(cl == 2) x = 0;
                else if(cl == 5) x = 1;
                else x = 2;
            }
            if(map[x][y] > target && target != 0) {
                // 위로 올라가야 한다.
                while(map[x][y] != target) {
                    x--;
                    lDist++;
                }
            } else if(map[x][y] < target || target == 0) {
                // 아래로 내려가야 한다.
                while(map[x][y] != target) {
                    x++;
                    lDist++;
                }
            }
        }


        if(cr == 0) {
            x = 3;
            y = 1;
            while(map[x][y] != target) {
                x--;
                rDist++;
            }
        } else {
            if(cr == 3 || cr == 6 || cr == 9) {
                rDist++;
                y = 1;
                if(cr == 1) x = 0;
                else if(cr == 4) x = 1;
                else x = 2;
            } else {
                y = 1;
                if(cr == 2) x = 0;
                else if(cr == 5) x = 1;
                else x = 2;
            }
            if(map[x][y] > target && target != 0) {
                // 위로 올라가야 한다.
                while(map[x][y] != target) {
                    x--;
                    rDist++;
                }
            } else if(map[x][y] < target || target == 0) {
                // 아래로 내려가야 한다.
                while(map[x][y] != target) {
                    x++;
                    rDist++;
                }
            }
        }
        if(lDist > rDist){
            cl = target;
            return "L";
        }
        else if(rDist > lDist) {
            cr = target;
            return "R";
        } else {
            if(hand.equals("right")) {
                cr = target;
                return "R";
            } else {
                cl = target;
                return "L";
            }
        }
    }
}