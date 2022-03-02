package study.problems.binarySearch.p7795;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 1; i <= M; i++) {
            B[i] = scan.nextInt();
        }
    }

    static int T, N, M;
    static int[] A, B;

    public static void main(String[] args) {
        T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }
    }

    static void pro() {
        Arrays.sort(B, 1 , M + 1);

        int ans = 0;
        for (int i = 1; i <=N; i++) {
            ans += lower_bound(B, 1, M, A[i]);
        }
        System.out.println(ans);
    }

    // fixme: 다시 작업해줘야됨
    static int lower_bound(int[] B, int L, int R, int X) {
        int res = L - 1;  // 만약 A[L...R] 중 X 이하의 수가 없다면 L - 1 을 return 한다.
        while (L <= R) {
            int mid = (L + R) / 2;
            if (B[mid] < X) {
                res = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return res;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

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
