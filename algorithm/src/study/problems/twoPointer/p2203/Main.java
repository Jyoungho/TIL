package study.problems.twoPointer.p2203;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static int N, M, ans;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
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
        int sum = 0;
        for (int L = 1, R = 0; L <= N; L++) {
            while (R + 1 <= N && sum < M) {
                R++;
                sum += A[R];
            }
            if (sum == M) {
                ans++;
            }
            sum -= A[L];
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
