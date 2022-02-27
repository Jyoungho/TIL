package study.problems.bruteforce.p9663;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        selected = new int[N + 1];
    }

    static int N;
    static int ans;
    static int[] selected;

    public static void main(String[] args) {
        input();
        // 백트래킹 함수
        rec_func(1);
        System.out.println(ans);
    }

    static void rec_func(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int col = 1; col <= N; col++) {
                boolean possible = true;
                for (int row2 = 1; row2 <= row - 1; row2++){
                    if (attackable(row, col, row2, selected[row2])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    selected[row] = col;
                    rec_func(row + 1);
                    selected[row] = 0;
                }
            }
        }
    }

    static boolean attackable(int row1, int col1, int row2, int col2) {
        if (col1 == col2) return true;
        if (row1 + col1 == row2 + col2) return true;
        if (row1 - col1 == row2 - col2) return true;
        return false;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
