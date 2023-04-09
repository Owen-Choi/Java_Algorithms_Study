package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Complete_Binary_Tree {

    static class Node {
        int rootv;
        Node l;
        Node r;
        public Node (int rootv, Node l, Node r) {
            this.rootv = rootv;
            this.l = l;
            this.r = r;
        }
    }

    static int K;
    static int[] buildings;
    static List<Integer>[] lists;
    static Node root;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static int c = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        lists = new List[K];
        for(int i=0; i<K; i++) {
            lists[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = st.countTokens();
        buildings = new int[size];
        root = new Node(1, null, null);

        for(int i=0; i<size; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=buildings.length / 2; i++) {
            reverse_union_find(root, i, i*2, (i*2) + 1);
        }
        inorder(root, 0);

        for(int i=0; i<K; i++) {
            for(int k=0; k<lists[i].size(); k++) {
//                System.out.print(lists[i].get(k) + " ");
                // 어우 복잡해. 대충 <새로 만든 트리> : <인덱스> 로 구성된 hashMap에서 인덱스를 가져와서 원래 리스트에 넣어주는 작업.
                sb.append(buildings[hashMap.get(lists[i].get(k))]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void reverse_union_find(Node current, int root, int l, int r) {

        if(current.rootv == root) {
            current.l = new Node(l, null, null);
            current.r = new Node(r, null, null);
        } else {
            if(current.l != null)
                reverse_union_find(current.l, root, l, r);
            if(current.r != null)
                reverse_union_find(current.r, root, l, r);
        }
    }

    static void inorder(Node node, int level) {
        if(node == null) {
            return;
        }
        inorder(node.l, level + 1);
        hashMap.put(node.rootv, c++);
        lists[level].add(node.rootv);
        inorder(node.r, level + 1);
    }


}
