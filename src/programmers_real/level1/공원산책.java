package programmers_real.level1;

import java.util.*;
public class 공원산책 {
    public static void main(String[] args) {
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        int[] solution = new ParkWalkingSolution().solution(park, routes);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}


class ParkWalkingSolution {
    public int[] solution(String[] park, String[] routes) {
        int startX = 0, startY = 0, i, k;
        for(i=0; i<park.length; i++) {
            for(k=0; k<park[0].length(); k++) {
                if(park[i].charAt(k) == 'S') {
                    startX = i;
                    startY = k;
                    break;
                }
            }
        }

        int currentX = startX, currentY = startY;
        boolean flag = false, tempFlag = false;
        for(i=0; i<routes.length; i++) {
            flag = tempFlag = false;
            char direction = routes[i].charAt(0);
            int value = routes[i].charAt(2) - '0';
            if(direction == 'N') {
                if(currentX - value >= 0) {
                    tempFlag = true;
                    for(k=1; k<=value; k++) {
                        if(park[currentX - k].charAt(currentY) != 'O') {
                            flag = true;
                            break;
                        }
                    }
                    if(!flag && tempFlag) {
                        currentX -= --k;
                    }
                }
            } else if(direction == 'S') {
                if(currentX + value < park.length) {
                    tempFlag = true;
                    for(k=1; k<=value; k++) {
                        if(park[currentX + k].charAt(currentY) != 'O') {
                            flag = true;
                            break;
                        }
                    }
                    if(!flag && tempFlag) {
                        currentX += --k;
                    }
                }
            } else if(direction == 'W') {
                if(currentY - value >= 0) {
                    tempFlag = true;
                    for(k=1; k<=value; k++) {
                        if(park[currentX].charAt(currentY - k) != 'O') {
                            flag = true;
                            break;
                        }
                    }
                    if(!flag && tempFlag) {
                        currentY -= --k;
                    }
                }
            } else {
                if(currentY + value < park[0].length()) {
                    tempFlag = true;
                    for(k=1; k<=value; k++) {
                        if(park[currentX].charAt(currentY + k) != 'O') {
                            flag = true;
                            break;
                        }
                    }
                    if(!flag && tempFlag) {
                        currentY += --k;
                    }
                }
            }

        }
        return new int[]{currentX, currentY};
    }
}
