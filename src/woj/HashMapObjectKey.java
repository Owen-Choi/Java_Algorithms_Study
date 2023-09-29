package woj;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapObjectKey {
    public static void main(String[] args) {
        Map<Node, Integer> map = new HashMap<>();
        Node node1 = new Node(1,2);
        Node node2 = new Node(1,2);
        map.put(node1, 0);
        map.put(node2 , 1);
        System.out.println(map.size());
        System.out.println(map.get(node1));
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || this.getClass() != o.getClass()) return false;
            Node N = (Node)o;
            if(this.x == N.x && this.y == N.y)
                return true;
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
