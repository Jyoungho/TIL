package study.problems.bruteforce.p15650;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] select;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        select = new int[M + 1];
    }

    public static void main(String[] args) {
        input();
        rec_fuc(1);
        System.out.println(sb);
    }

    static void rec_fuc(int k) {
        if (k == M + 1){
            for (int i = 1; i <= M; i++) sb.append(select[i]).append(' ');
            sb.append('\n');
        } else {
            for (int cand = select[k - 1] + 1; cand <= N; cand++) {
                select[k] = cand;
                rec_fuc(k + 1);
                select[k] = 0;
            }
        }
    }
}
