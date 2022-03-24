package study.problems.binarySearch.p2110.again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static int N, C;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(A, 1, N + 1);
        pro();
    }

    static void pro() {
        int ans = 0;
        int L = 1, R = 1_000_000_000;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (possible(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean possible(int distance) {
        int last = A[1];
        int count = 1;
        for (int i = 2; i <= N; i++) {
            if (A[i] - last < distance) continue;
            last = A[i];
            count++;
        }
        return count >= C;
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
