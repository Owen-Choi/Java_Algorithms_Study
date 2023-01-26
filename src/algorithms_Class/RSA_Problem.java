package algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RSA_Problem {
    // public key values ::
    static int n, e;
    // cipher text C ::
    static int C;
    // Euler's Totient ::
    static int ET;
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
        int d = Find_D();
        System.out.println(squaring(d));
    }
    static int Euclid(int a, int b) {
        if(b == 0)
            return a;
        else
            return Euclid(b, a%b);
    }
    static int Find_D () {
        int prime_count = 0;
        int d = -1;
        for(int i=1; i<n; i++) {
            if(Euclid(i, n) == 1)
                prime_count++;
        }
        ET = prime_count;
        for(int i=0; i<ET; i++) {
            if((e * i) % ET == 1) {
                d = i;
                break;
            }
        }
        return d;
    }
    static long squaring(int d) {
        long Original = 1;
        int iter = d;
        long tempC = C;
        while(iter > 0) {
            while(iter % 2 == 0) {
                iter /= 2;
                tempC = ((tempC % n) * tempC ) % n;
            }
            iter--;
            Original = ((Original % n) * tempC) % n;
        }
        return Original;
    }
}
