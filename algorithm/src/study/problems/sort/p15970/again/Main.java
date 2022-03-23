package study.problems.sort.p15970.again;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static int N, distance;
    static ArrayList<Integer>[] A;

    static void input() {
        N = scan.nextInt();
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) A[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int x = scan.nextInt();
            int color = scan.nextInt();
            A[color].add(x);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static int toLeft(ArrayList<Integer> arr, int idx) {
        if (idx == 0) return Integer.MAX_VALUE;
        return arr.get(idx) - arr.get(idx - 1);
    }

    static int toRight(ArrayList<Integer> arr, int idx) {
        if (idx == arr.size() - 1) return Integer.MAX_VALUE;
        return arr.get(idx + 1) - arr.get(idx);
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
            for (int j = 0; j < A[i].size(); j++) {
                int left = toLeft(A[i], j);
                int right = toRight(A[i], j);

                distance += Math.min(right, left);
                }
            }
        System.out.println(distance);
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
