package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 게리멘더링 {

  static int n, result = Integer.MAX_VALUE;
  static int[] population;
  static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    population = new int[n];
    for(int i=0; i<n; i++) {
      population[i] = Integer.parseInt(st.nextToken());
      list.add(new ArrayList<>());
    }

    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      int temp = Integer.parseInt(st.nextToken());
      for(int k=0; k<temp; k++) {
        int tempInput = Integer.parseInt(st.nextToken()) - 1;
        list.get(i).add(tempInput);
      }
    }

    for(int i=1; i<=n / 2; i++) {
      combination(0, 0, i, new ArrayList<>());
    }

    System.out.println(result == Integer.MAX_VALUE ? -1 : result);
  }


  static void combination(int start, int depth, int max, List<Integer> combinationList) {
    if(depth == max) {
      // 나눈 구역이 가능한지 확인
      // 가능하다면 인구의 최솟값인지 확인
      getMinimalPopulation(combinationList);
      return;
    }
    for(int i=start; i<n; i++) {
        combinationList.add(i);
        combination(i,depth + 1, max, combinationList);
        combinationList.remove(combinationList.size() - 1);
    }
  }

  static void getMinimalPopulation(List<Integer> combinationList) {
    // BFS를 활용해서 풀이할 수 있다. 시간초과가 안나나보다.
    Queue<Integer> queue = new LinkedList<>();
    boolean[] flag = new boolean[n];
    queue.offer(combinationList.get(0));
    flag[combinationList.get(0)] = true;
    // 이미 하나의 지역을 꺼냈기 때문에 count는 1이 되어야 한다.
    int count = 1;
    while(!queue.isEmpty()) {
      int poll = queue.poll();
      for(int next : list.get(poll)) {
        if(!flag[next] && combinationList.contains(next)) {
          count++;
          flag[next] = true;
          queue.offer(next);
        }
      }
    }

    int bCount = 1;
    List<Integer> restList = new ArrayList<>();
    for(int i=0; i<n; i++) {
      if(!combinationList.contains(i))
        restList.add(i);
    }
    flag = new boolean[n];
    flag[restList.get(0)] = true;
    queue.offer(restList.get(0));
    while(!queue.isEmpty()) {
      int poll = queue.poll();
      for(int next : list.get(poll)) {
        if(!flag[next] && restList.contains(next)) {
          bCount++;
          flag[next] = true;
          queue.offer(next);
        }
      }
    }

    if(count == combinationList.size() && bCount == restList.size()) {
      int popa = 0, popb = 0;
      for(int i=0; i<n; i++) {
        if(combinationList.contains(i)) {
          popb += population[i];
        } else {
          popa += population[i];
        }
      }
      result = Math.min(result, Math.abs(popa - popb));
    }
  }


}
