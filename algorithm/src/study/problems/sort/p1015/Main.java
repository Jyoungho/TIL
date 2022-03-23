package study.problems.sort.p1015;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {

        public int idx, value;

        @Override
        public int compareTo(Elem o) {
            return value - o.value;
        }
    }

    static int N;
    static int[] P;
    static Elem[] A;

    static void input() {
        N = scan.nextInt();
        A = new Elem[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = new Elem();
            A[i].value = scan.nextInt();
            A[i].idx = i;
        }
    }

    public static void main(String[] args) {
        input();

        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            P[A[i].idx] = i;
        }

        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(' ');
        }
        sb.append('\n');
        System.out.println(sb);
    }
}
