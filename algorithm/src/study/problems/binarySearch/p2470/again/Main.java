package study.problems.binarySearch.p2470.again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, abs0;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        abs0 = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        int a1 = 0, a2 = 0;
        Arrays.sort(A, 1, N + 1);
        for (int L = 1, R = N; L < R; L++) {
            int mixFluid = A[L] + A[R];
            if ( abs0 > Math.abs(mixFluid)) {
                abs0 = Math.abs(mixFluid);
                a1 = A[L];
                a2 = A[R];
                if (abs0 == 0) break;
            }

            if (mixFluid > 0) {
                R--;
                L--;
            }
        }
        sb.append(a1).append(' ').append(a2);
        System.out.println(sb);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
