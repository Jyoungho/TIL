package study.problems.twoPointer.p1253;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, ans;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        //input
        input();

        //process
        pro();
    }

    static void pro() {
        // O(NlogN)
        Arrays.sort(A, 1, N + 1);

        for (int i = 1; i <= N; i++) {
            if (func(i)) ans++;
        }

        System.out.println(ans);
    }

    static boolean func(int index) {
        int L = 1, R = N;
        while (L < R) {
            if (L == index) L++;
            else if (R == index) R--;
            else {
                if (A[L] + A[R] > A[index]) R--;
                else if (A[L] + A[R] < A[index]) L++;
                else return true;
            }
        }
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
