package programmers_real.level3;

import java.util.*;

public class TravelRoute {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[] solution = new TravelRouteSolution().solution(tickets);
        for (String s : solution) {
            System.out.print(s + " ");
        }
    }
}

class TravelRouteSolution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        ArrayList<Node>[] list = new ArrayList[tickets.length];
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i=0; i< tickets.length; i++) {
            list[i] = new ArrayList<>();
        }
        int indexCounter = 0;
        for(int i=0; i<tickets.length; i++) {
            String firstString = tickets[i][0];
            String secondString = tickets[i][1];
            if(!indexMap.containsKey(firstString)) indexMap.put(firstString, indexCounter++);
            if(!indexMap.containsKey(secondString)) indexMap.put(secondString, indexCounter++);
            Integer firstIndex = indexMap.get(firstString);
            Integer secondIndex = indexMap.get(secondString);
            list[firstIndex].add(new Node(secondString, secondIndex));
            // 양방향이 아니므로 역방향은 넣어줘선 안된다.
        }
        boolean[] flag = new boolean[indexMap.size()];
        for (ArrayList<Node> nodes : list) {
            for (Node node : nodes) {
                System.out.print(node.name + " ");
            }
            System.out.println();
        }
        PriorityQueue<QueueNode> pq = new PriorityQueue<>();
        int startIndex = indexMap.get("ICN");
        String[] result = new String[indexMap.size()];
        for(int i=0; i<list[startIndex].size(); i++) {
            pq.offer(new QueueNode(list[startIndex].get(i).name, list[startIndex].get(i).dest, result));
        }

        int counter = -1;
        while(!pq.isEmpty()) {
            QueueNode poll = pq.poll();
            if(!flag[indexMap.get(poll.name)]) {
                flag[indexMap.get(poll.name)] = true;
                counter++;
            }
            if(counter == indexMap.size() - 2) {
                return poll.result;
            }
            for(int i=0; i<list[poll.dest].size(); i++) {
                Node node = list[poll.dest].get(i);
                String[] tempResult = poll.result;
                tempResult[counter] = node.name;
                System.out.println(node.name);
                pq.offer(new QueueNode(node.name, node.dest, tempResult));
            }
        }
        return answer;
    }

    class Node {
        String name;
        int dest;

        public Node(String name, int dest) {
            this.name = name;
            this.dest = dest;
        }
    }

    class QueueNode implements Comparable<QueueNode>{

        String name;
        int dest;
        String[] result;

        public QueueNode(String name, int index, String[] result) {
            this.name = name;
            this.dest = index;
            this.result = result.clone();
        }

        @Override
        public int compareTo(QueueNode o) {
            return this.name.compareTo(o.name);
        }
    }
}
