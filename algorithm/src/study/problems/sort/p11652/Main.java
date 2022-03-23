package study.problems.sort.p11652;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long max;
    static long number;
    static Map<Long, Long> A;

    static void input() {
        N = scan.nextInt();
        A = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long cardNumber = scan.nextLong();
            A.merge(cardNumber, 1L, Long::sum);
        }
        max = Long.MIN_VALUE;
    }

    public static void main(String[] args) {
        input();

        pro();

    }

    static void pro() {
        for (Long key : A.keySet()) {
            if (A.get(key) > max) {
                max = A.get(key);
                number = key;
            } else if (A.get(key) == max) {
                max = A.get(key);
                if (key < number) {
                    number = key;
                }
            }
        }
        System.out.println(number);
    }
}
