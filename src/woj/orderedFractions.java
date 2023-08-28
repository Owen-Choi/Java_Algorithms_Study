package woj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class orderedFractions {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<FractionSolution.Node> list = new FractionSolution().simplifiedFractions(n);
        System.out.println("1/0");
        for (FractionSolution.Node node : list) {
            System.out.println(node.fraction);
        }
        System.out.println("1/1");
    }

}
class FractionSolution {
    public List<Node> simplifiedFractions(int n) {
//        List<String> result = new ArrayList<>();
        List<Node> result = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            for (int k = 1; k < i; k++) {
                if (gcd(k, i) == 1) {
                    result.add(new Node(k + "/" + i, (double)k/i));
                }
            }
        }
        result.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Double.compare(o1.value, o2.value);
            }
        });
        return result;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    class Node {
        String fraction;
        double value;

        public Node(String fraction, double value) {
            this.fraction = fraction;
            this.value = value;
        }
    }
}

