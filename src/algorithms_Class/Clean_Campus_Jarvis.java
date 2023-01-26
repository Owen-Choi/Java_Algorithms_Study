package algorithms_Class;

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
            freshes[0] = new Fresh(0.0, 0.0);
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
        int l = 0;
        for (int i = 1; i < freshes.length; i++)
            if (freshes[i].x < freshes[l].x)
                l = i;
        int index = l, q;
        do {
            queue.offer(freshes[index]);
            q = (index + 1) % freshes.length;
            for(int i=0; i< freshes.length; i++) {
                if(Find_Direction(freshes[index], freshes[i], freshes[q]) == 2) {
                    q = i;
                }
            }
            index = q;
            //queue.offer(freshes[index]);
            freshes[index].visited = true;

        }while(index != l);
        System.out.println(calc_value(queue));
    }

    static double calc_value(Queue<Fresh> queue) {
        // Find two closest fresh man
        /////////////////////////////////////

        Fresh min1 = null,min2 = null;
        double min = 1000000, tempDist;
        for(int i=1; i< freshes.length; i++) {
            tempDist = getDist(freshes[i], freshes[0]);
            if(tempDist < min && freshes[i].visited) {
                min = tempDist;
                min1 = freshes[i];
            }
        }
        System.out.println(min1.x + " " + min1.y);
        min = 1000000;
        for(int i=1; i< freshes.length; i++) {
            if(freshes[i] == min1)
                continue;
            tempDist = getDist(freshes[i], freshes[0]);
            if(tempDist < min && freshes[i].visited && typeCheck(min1, freshes[i])) {
                min = tempDist;
                min2 = freshes[i];
            }
        }
        System.out.println(min2.x + " " + min2.y);
        //now we know m1 and m2, which is closest point from start point ::
        Fresh prior = null, temp = null, Init = null;
        int size = queue.size();
        double value = 0.0;

        /*for(Fresh tf : queue)
            System.out.println(tf.x + " " + tf.y);*/

        for(int i=0; i<size; i++) {
            if(i == 0) {
                Init = queue.peek();
                prior = queue.poll();
            }
            else {
                temp = queue.poll();
                value += Math.sqrt(Math.pow(prior.x - temp.x, 2) + Math.pow(prior.y - temp.y, 2));
                prior = temp;
            }
        }
        // at the last, we have to draw line to init point and last point
        value += getDist(temp, Init);
        value += 2;
        // now we have convex hull's length.
        value -= getDist(min1, min2);
        // get rid of distance min1 and min2
        value += getDist(min1, freshes[0]) + getDist(min2, freshes[0]);
        return value;
    }

    static double getDist(Fresh tempFresh, Fresh tempFresh2) {
        return Math.sqrt((Math.pow(tempFresh.x - tempFresh2.x, 2)) + (Math.pow(tempFresh.y - tempFresh2.y,2)));
    }

    static boolean typeCheck(Fresh pivot, Fresh fresh) {
        // 아래와 같이 처리하면 첫번째 데이터 셋이 동작하지 않는다.
        /*if(Math.abs(pivot.x) == Math.abs(fresh.x) && Math.abs(pivot.y) == Math.abs(fresh.y))
            return false;
        else
            return true;*/
        if(pivot.x >= 0 && fresh.x <= 0 && pivot.y == 0 && fresh.y == 0)
            return false;
        else if(pivot.x <= 0 && fresh.x >= 0 && pivot.y == 0 && fresh.y == 0)
            return false;
        else if(pivot.y >= 0 && fresh.y <= 0 && pivot.x == 0 && fresh.x == 0)
            return false;
        else if(pivot.y <= 0 && fresh.y >= 0 && pivot.x == 0 && fresh.x == 0)
            return false;
        else
            return true;
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
