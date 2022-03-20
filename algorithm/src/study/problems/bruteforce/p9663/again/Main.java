package study.problems.bruteforce.p9663.again;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, ans;
    static int[] column;

    static void input() {
        N = scan.nextInt();
        column = new int[N + 1];
    }

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        return false;
    }

    static void rec_func(int row) {
        if (row == N + 1){
            ans++;
        } else {
            for (int col = 1; col <= N; col++) {
                boolean possible = true;
                for (int i = 1; i <= row - 1; i++) {
                    if (attackable(row, col, i, column[i])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    column[row] = col;
                    rec_func(row + 1);
                    column[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(ans);
    }

}