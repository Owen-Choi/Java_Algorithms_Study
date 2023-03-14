package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1197번
// Kruskal MST ::
public class Minimum_Spanning_Tree {
    static int EdgeNum, VertexNum;
    static int[] parent;
    static LinkedList<Node> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        VertexNum = Integer.parseInt(st.nextToken());
        EdgeNum = Integer.parseInt(st.nextToken());
        parent = new int[VertexNum + 1];
        for(int i=0; i<EdgeNum; i++) {
            st = new StringTokenizer(br.readLine()," ");
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for(int i = 1; i<= VertexNum; i++)
            parent[i] = i;
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.Distance - o2.Distance;
            }
        });
        int sum = 0;
        Node tempNode;
        while(!list.isEmpty()){
            tempNode = list.poll();
            if(!CycleCheck(tempNode.Start, tempNode.Dest)) {
                sum += tempNode.Distance;
                Merge(tempNode.Start, tempNode.Dest);
            }
        }
        System.out.println(sum);
    }
    static class Node {
        int Start, Dest, Distance;
        public Node(int s, int d, int distance) {
            Start = s;
            Dest = d;
            Distance = distance;
        }
    }

    static int getParent(int index) {
        // parent 배열이 자기 자신을 가리키고 있다면(아직 연결이 안됐다면)
        if(parent[index] == index) return index;
        return parent[index] = getParent(parent[index]);   //자기 자신을 가리키지 않는다면 연결된 노드를 타고 타고 들어가 값 업데이트 해주기
    }
    static void Merge(int First, int Second) {
        First = getParent(First);
        Second = getParent(Second);
        if(First < Second)
            parent[Second] = First;
        else
            parent[First] = Second;
    }
    static boolean CycleCheck(int First, int Second) {
        return getParent(First) == getParent(Second);
    }
}
