package study.problems.p1182;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
        selectedNumber = new int[N + 1];
    }

    static int N, S, result;
    static int[] nums;
    static int[] selectedNumber;


    public static void main(String[] args) {
        input();

        // 완전 탐색함수
        rec_func(1, 0);
        if (S == 0) {
            result--;
        }
        System.out.println(result);
    }

    static void rec_func(int k, int value) {
        if (k == N + 1) {
            if (value == S) result++;
        } else {
            rec_func(k + 1, value + nums[k]);
            rec_func(k + 1, value);
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
