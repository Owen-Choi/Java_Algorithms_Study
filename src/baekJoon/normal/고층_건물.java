package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 고층_건물 {
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 각 빌딩의 높이는 10억 이하
        int[] buildings = new int[n];
        for(int i=0; i<n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++) {
            if(i == 0 || i == n-1) {
                singleCalc(i, buildings);
            } else {
                biCalc(i, buildings);
            }
        }

        // 문제를 잘못 이해해서 잘못 풀었다.
        System.out.println(answer);
    }

    // 한쪽만 조사. (양끝 빌딩에 대해서 조사할 때 사용됨)
    static void singleCalc(int index, int[] buildings) {
        int iter = index, counter = 0;
        while(true) {
            iter = index == 0 ? iter+1 : iter-1;
            if(iter < 0 || iter >= buildings.length) {
                // 만약 왼쪽 끝 혹은 오른쪽 끝에 도달했다면
                answer = Math.max(answer, counter);
                return;
            }
            if(buildings[iter] < buildings[index]) {
                // 새로 조사하는 빌딩이 처음 빌딩보다 작다면
                counter++;
            } else {
                answer = Math.max(answer, counter);
                return;
            }
        }
    }

    // 왼쪽 오른쪽을 동시에 조사
    static void biCalc(int index, int[] buildings) {
        int leftPointer = index, rightPointer = index, leftCounter = 0, rightCounter = 0;
        while(true) {
            leftPointer--;
            if(leftPointer < 0)
                // 왼쪽 포인터는 여기서 종료. 오른쪽 포인터 연산 후 합산하여 결과 반환
                break;
            if(buildings[leftPointer] < buildings[index]) {
                leftCounter++;
            } else
                break;
        }

        while(true) {
            rightPointer++;
            if(rightPointer >= buildings.length)
                break;
            if(buildings[rightPointer] < buildings[index]) {
                rightCounter++;
            } else
                break;
        }

        answer = Math.max(answer, leftCounter + rightCounter);
    }
}
