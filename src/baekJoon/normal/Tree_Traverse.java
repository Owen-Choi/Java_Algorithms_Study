package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree_Traverse {

    static class Node {
        char rootv;
        Node l;
        Node r;
        public Node(char v, Node l, Node r) {
            this.rootv = v;
            this.l = l;
            this.r = r;
        }
    }

    static int N;
    static Node rootNode;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        rootNode = new Node('A', null, null);
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);
            reverse_union_find(rootNode, root, l, r);
        }
        sb = new StringBuilder();
        preorder(rootNode);
        sb.append("\n");
        inorder(rootNode);
        sb.append("\n");
        postorder(rootNode);
        System.out.println(sb.toString());
    }

    public static void reverse_union_find(Node current, char root, char l, char r) {
        if(current.rootv == root) {
            // l,r을 루트로 하는 하위 트리를 생성한다.
            if(l != '.') {
                current.l = new Node(l, null, null);
            }
            if(r != '.') {
                current.r = new Node(r, null, null);
            }
        } else {
            // 루트를 찾을 때까지 역유니온파인드
            if(current.l != null) {
                reverse_union_find(current.l, root, l, r);
            }
            if(current.r != null) {
                reverse_union_find(current.r, root, l, r);
            }
        }
    }

    public static void preorder(Node node) {
        // root -> left -> right
        if(node == null) {
            return;
        }
        sb.append(node.rootv);
        preorder(node.l);
        preorder(node.r);
    }

    public static void inorder(Node node) {
        if(node == null) {
            return;
        }
        inorder(node.l);
        sb.append(node.rootv);
        inorder(node.r);
    }

    public static void postorder(Node node) {
        if(node == null) {
            return;
        }
        postorder(node.l);
        postorder(node.r);
        sb.append(node.rootv);
    }
}
