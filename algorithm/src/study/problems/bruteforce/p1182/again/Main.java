package study.problems.bruteforce.p1182.again;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, S, ans, sum;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, 0);
        if (S == 0) {
            ans--;
        }
        System.out.println(ans);
    }

    static void rec_func(int k, int value) {
        if (k == N + 1) {
            if (value == S) ans++;
        } else {
            rec_func(k + 1, value + A[k]);
            rec_func(k + 1, value);
        }
    }
}
