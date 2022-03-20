package study.problems.bruteforce.p14888.replay;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, max, min;
    static int[] A, calculator;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        calculator = new int[5];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 1; i <= 4; i++) {
            calculator[i] = scan.nextInt();
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        input();
//        pro();
        rec_func(1, A[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }

    static void rec_func(int k, int value) {
        if (k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int cand = 1; cand <= 4; cand++) {
                if (calculator[cand] >= 1){
                    calculator[cand]--;
                    rec_func(k + 1, calculator(value, cand, A[k + 1]));
                    calculator[cand]++;
                }
            }
        }
    }

    static int calculator(int operand1, int operator, int operand2){
        // value, order[i], num[i+1]
        if (operator == 1) // +
            return operand1 + operand2;
        else if (operator == 2) // -
            return operand1 - operand2;
        else if (operator == 3) // *
            return operand1 * operand2;
        else // /
            return operand1 / operand2;
    }


}
