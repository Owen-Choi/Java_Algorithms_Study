package woj;

import java.util.Scanner;

public class Submarine {
    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.next();
        String pattern = "(100+1+|01)+";
        System.out.println(input.matches(pattern) ? "SUBMARINE" : "NOISE");
    }
}
