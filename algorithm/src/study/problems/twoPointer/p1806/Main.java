package study.problems.twoPointer.p1806;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        int R = 0, sum = 0, ans = N + 1;
        for (int L = 1; L <=N; L++) {
            // L - 1 구간을 제외해 준다.
            sum -= A[L - 1];

            while (R + 1 <= N && sum < S) {
                sum += A[++R];
            }

            if (sum >= S) {
                ans = Math.min(ans, R - L + 1);
            }
        }
        if (ans == N + 1) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
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
