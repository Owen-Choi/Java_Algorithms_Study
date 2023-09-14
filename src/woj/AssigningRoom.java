package woj;

import java.util.Scanner;

public class AssigningRoom {
    public static void main(String[] args) {
        Child child = new Child();
        child.calc();
    }


}

class Parent{
    protected int [][] room;
    protected int k = 0; //최대 인원수
    Parent(){
        Scanner in = new Scanner(System.in);
        int st = 0;
        room = new int[7][2];
        st = in.nextInt();
        k = in.nextInt();
        for(int i=0;i<st;i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            room[b][a]++;
        }
    }
}

class Child extends Parent{
    public Child() {
        super();
    }
    public void calc() {
        int answer = 0;
        for(int i=1; i<7; i++) {
            for(int j=0; j<2; j++) {
                answer += room[i][j] / k;
                if(room[i][j] % k != 0) answer++;
            }
        }
        System.out.println(answer);
    }

}
