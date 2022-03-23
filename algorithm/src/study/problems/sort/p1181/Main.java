package study.problems.sort.p1181;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {

        int size;
        String text;

        @Override
        public int compareTo(Elem o) {
            if (size == o.size) return text.compareTo(o.text);
            return size - o.size;
        }
    }

    static int N;
    static Elem[] A;

    static void input() {
        N = scan.nextInt();
        A = new Elem[N];
        for (int i = 0; i < N; i++){
            String word = scan.nextLine();
            A[i] = new Elem();
            A[i].size = word.length();
            A[i].text = word;
        }
    }

    public static void main(String[] args) {
        input();

        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            if (i < N - 1 && A[i].text.equals(A[i + 1].text)) continue;
            sb.append(A[i].text).append('\n');

        }
        System.out.println(sb);
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
