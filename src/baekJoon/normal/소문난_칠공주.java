//package baekJoon.normal;
//
//import java.io.*;
//import java.util.*;
//
//public class 소문난_칠공주 {
//
//  static char[][] girl = new char[5][5];
//  static int result = 0;
//  static int[][] move = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
//  static boolean[][] flag = new boolean[5][5];
//  static Set<Girl> set = new HashSet<>();
//
//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    String tempInput;
//    for (int i = 0; i < 5; i++) {
//      tempInput = br.readLine();
//      for (int k = 0; k < 5; k++) {
//        girl[i][k] = tempInput.charAt(k);
//      }
//    }
//
//    for(int i=0; i<5; i++) {
//      for(int k=0; k<5; k++) {
//        dfs(i,k, 0,0, new ArrayList<>());
//      }
//    }
//    System.out.println(set.size());
//  }
//
//  // 백트래킹
//  static void dfs(int x, int y, int yMember, int sMember, List<int[]> l) {
//    if (yMember + sMember == 7) {
//      if (sMember >= 4) {
//        List<int[]> clone = new ArrayList<>();
//        for (int[] ints : l) {
//          clone.add(ints);
//        }
//        set.add(new Girl(clone));
//        return;
//      }
//    }
//    for (int i = 0; i < 4; i++) {
//      int nextX = x + move[0][i];
//      int nextY = y + move[1][i];
//      if (nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5) {
//        continue;
//      }
//      if (!flag[nextX][nextY]) {
//        flag[nextX][nextY] = true;
//        l.add(new int[]{nextX, nextY});
//        dfs(nextX, nextY, girl[nextX][nextY] == 'Y' ? yMember + 1 : yMember,
//            girl[nextX][nextY] == 'S' ? sMember + 1 : sMember, l);
//        l.remove(l.size() - 1);
//        flag[nextX][nextY] = false;
//      }
//    }
//  }
//
//  static class Girl {
//    List<int[]> list;
//
//    public Girl(List<int[]> list) {
//      this.list = list;
//    }
//
//    public List<int[]> getList() {
//      return this.list;
//    }
//
//    @Override
//    public int hashCode() {
//      final int prime = 31;
//      int result = 1;
//      for (int[] array : list) {
//        result = prime * result + array[0] + array[1];
//      }
//      return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//      if(obj == null) {
//        return false;
//      }
//
//      if(this.getClass() != obj.getClass()) {
//        return false;
//      }
//
//      if(this == obj) {
//        return true;
//      }
//
//      List<int[]> list2 = ((Girl) obj).getList();
//      for(int i=0; i<7; i++) {
//        if(list.get(i)[0] != list2.get(i)[0] || list.get(i)[1] != list2.get(i)[1]) {
//          return false;
//        }
//      }
//      return true;
//    }
//
//  }
//
//}

package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 소문난_칠공주 {

    static char[][] girl = new char[5][5];
    static List<Node> list = new ArrayList<>();
    static boolean[][] flag = new boolean[5][5];
    static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tempInput;
        for (int i = 0; i < 5; i++) {
            tempInput = br.readLine();
            for (int k = 0; k < 5; k++) {
                girl[i][k] = tempInput.charAt(k);
            }
        }

        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int depth, int start) {
        // 7개의 좌석을 랜덤하게 pick
        if(depth == 7) {
            bfs();
            return;
        }
        int x, y;
        for(int i=start; i<25; i++) {
            x = i / 5;
            y = i % 5;
            if(!flag[x][y]) {
                flag[x][y] = true;
                list.add(new Node(x,y));
                dfs(depth + 1, i);
                list.remove(list.size() - 1);
                flag[x][y] = false;
            }
        }
    }


    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        for(int i=0; i<5; i++) {
            visited[i] = flag[i].clone();
        }
        // 리스트는 사실상 필요가 없지만, 좌표를 전달해주기 위해서 그대로 두겠다.
        queue.offer(list.get(0));
        int count = 0, sCount = 0;
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for(int i=0; i<4; i++) {
                int nextX = poll.x + move[0][i];
                int nextY = poll.y + move[1][i];

                if(nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5) {
                    continue;
                }
                if(visited[nextX][nextY]) {
                    count++;
                    if(girl[nextX][nextY] == 'S') {
                        sCount++;
                    }
                    queue.offer(new Node(nextX, nextY));
                    // 여기 때문에 틀릴 뻔 했다. 조심하자.
                    visited[nextX][nextY] = false;
                }
            }
        }

        if(count == 7 && sCount >= 4) {
            result++;
        }
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}