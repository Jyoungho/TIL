package study.problems.twoPointer.p13144.again;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, ans;
    static int[] A, cnt;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        cnt = new int[100_000 + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        long ans = 0;

        for (int L = 1, R = 0; L <= N; L++){

            while (R + 1 <= N && cnt[A[R + 1]] == 0) {
                R++;
                cnt[A[R]]++;
            }

            ans += R - L + 1;

            cnt[A[L]]--;
        }

        System.out.println(ans);
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
