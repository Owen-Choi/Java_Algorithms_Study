package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Clean_Campus_Jarvis {
    static int testCase;
    static int Fresh_num;
    static Fresh[] freshes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        testCase = Integer.parseInt(br.readLine());
        // blank
        while(testCase --> 0) {
            Fresh_num = Integer.parseInt(br.readLine());
            freshes = new Fresh[Fresh_num];
            for(int i=0; i<Fresh_num; i++) {
                st = new StringTokenizer(br.readLine()," ");
                freshes[i] = new Fresh(Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken()));
            }
        }
    }
    public static int Find_Direction(Fresh a, Fresh b, Fresh c) {
        float value = (b.y - a.y) * (c.x - b.x) - (b.x - a.x) * (c.y - b.y);
        if(value == 0)
            return 0;       //linear case ::
        return (value > 0) ? 1 : 2;
    }

    public static void 
    static class Fresh {
        float x, y;
        Fresh(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
}
