package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RSA_Problem {
    // public key values ::
    static int n, e;
    // cipher text C ::
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the public key values :: ");
        System.out.print("Please enter n : ");
        n = Integer.parseInt(br.readLine());
        System.out.print("Please enter e : ");
        e = Integer.parseInt(br.readLine());
        System.out.println("Please enter the cipher value :: ");
        System.out.print("Please enter C : ");
        C = Integer.parseInt(br.readLine());
        Solve();
    }
    static void Solve() {
        int i = 1;
        while(true) {
            if(Math.pow(i, e) % n == C)
                break;
            else
                i++;
        }
        System.out.println("M is " + i);
    }
}
