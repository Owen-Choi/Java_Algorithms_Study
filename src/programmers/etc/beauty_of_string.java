package programmers.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class beauty_of_string {
    static String ss;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(solution(input));
    }

    public static long solution(String s) {
        ss = s;
        int result = 0;
        int[] tree;
        double treeHeight = Math.ceil(Math.log(s.length()) / Math.log(2)) + 1;
        long treeNodeCount = Math.round(Math.pow(2, treeHeight));
        tree = new int[Math.toIntExact(treeNodeCount)];
        init(tree, 1,1,s.length());
        result = sum(tree, 1, 1, s.length(), 1, s.length());
        return result;
    }

    static int calc(int start, int end) {
        HashSet<Character> hashSet = new HashSet<>();
        for(int i=start; i<=end; i++) {
            hashSet.add(ss.charAt(i));
        }
        return hashSet.size();
    }

    static int init(int[] tree, int node, int start, int end) {
        if (start == end) {
            return tree[node] = calc(start, end);
        } else {
            return tree[node] = init(tree, node * 2, start, (start + end) / 2)
                    + init(tree,node * 2 + 1, (start + end) / 2 + 1, end);
        }
    }

    static int sum(int[] tree, int node, int start, int end, int left, int right) {
        if (end < left || right < start) {
            return 0;
        } else if (left <= start && end <= right) {
            return tree[node];
        } else {
            return sum(tree, node * 2, start, (start + end) / 2, left, right)
                    + sum(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }
    }

}
