package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Clean_Campus_Jarvis {
    static int testCase;
    static int Fresh_num;
    static Fresh[] freshes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        testCase = Integer.parseInt(br.readLine());
        double tempX, tempY;
        // blank
        while(testCase --> 0) {
            Fresh_num = Integer.parseInt(br.readLine());
            freshes = new Fresh[Fresh_num + 1];
            freshes[0] = new Fresh(0.0f, 0.0f);
            for(int i=1; i<=Fresh_num; i++) {
                st = new StringTokenizer(br.readLine()," ");
                tempX = Double.parseDouble(st.nextToken());
                tempY = Double.parseDouble(st.nextToken());
                freshes[i] = new Fresh(tempY, tempX);
            }
            convex_hull();
        }
    }
    public static int Find_Direction(Fresh a, Fresh b, Fresh c) {
        double value = (b.x - a.x) * (c.y - b.y) - (b.y - a.y) * (c.x - b.x);
        if(value == 0)
            return 0;       //linear case ::
        return (value > 0) ? 1 : 2;
    }

    public static void convex_hull() {
        Queue<Fresh> queue = new LinkedList<>();
        //our start point is (0,0)
        int index = 0, q;
        do {
            queue.offer(freshes[index]);
            q = (index + 1) % freshes.length;
            for(int i=0; i< freshes.length; i++) {
                if(Find_Direction(freshes[index], freshes[i], freshes[q]) == 2) {
                    q = i;
                }
            }
            index = q;
            /*if(queue.size() >= freshes.length)
                break;*/
        }while(freshes[index].y != 0 || freshes[index].x != 0);

        System.out.println(calc_value(queue));
    }

    static float calc_value(Queue<Fresh> queue) {
        Fresh prior = null, temp = null;
        int size = queue.size();
        float value = 0.0f;
        for(int i=0; i<size; i++) {
            if(i == 0) {
                prior = queue.poll();
                continue;
            }
            else {
                temp = queue.poll();
                System.out.println(temp.x + " " + temp.y);
                value += Math.sqrt(Math.pow(prior.x - temp.x, 2) + Math.pow(prior.y - temp.y, 2));
                prior = temp;
            }
        }
        //value += Math.sqrt(Math.pow(temp.x - 0, 2) + Math.pow(temp.y - 0, 2));
        return value + 2f;
    }

    static class Fresh {
        double x, y;
        boolean visited;
        Fresh(double x, double y) {
            this.x = x;
            this.y = y;
            this.visited = false;
        }
    }
}
