package study.problems.binarySearch.p1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
        B = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            B[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        input();

        Arrays.sort(A, 1, N + 1);

        pro();

        System.out.println(sb);
    }

    static void pro() {
        for (int i = 1; i <= M; i++) {
            boolean isExist = false;
            int L = 1, R = N;
            while (L <= R) {
                int mid = (L + R) / 2;
                if (A[mid] == B[i]) {
                    isExist = true;
                    sb.append(1).append('\n');
                    break;
                }
                if (A[mid] < B[i]) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }

            if (!isExist) {
                sb.append(0).append('\n');
            }
        }
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

        int nextInt() { return Integer.parseInt(next()); }
    }
}
