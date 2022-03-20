package study.problems.bruteforce.p15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
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
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(select[i]).append(' ');
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= N; cand++) {
                boolean isUsed = false;
                for (int j = 1; j <= M; j++) {
                    if (cand == select[j]) {
                        isUsed = true;
                        break;
                    }
                }
                if (!isUsed) {
                    select[k] = cand;
                    rec_fuc(k + 1);
                    select[k] = 0;
                }
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

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

    }
}
