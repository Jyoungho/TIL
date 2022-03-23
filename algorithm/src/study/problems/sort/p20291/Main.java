package study.problems.sort.p20291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Elem[] A;

    static class Elem implements Comparable<Elem> {

        String extension;

        @Override
        public int compareTo(Elem o) {
            return extension.compareTo(o.extension);
        }
    }

    static void input() {
        N = scan.nextInt();
        A = new Elem[N + 1];
        for (int i = 1; i <= N; i++) {
            String fileInfo = scan.nextLine();
            String[] split = fileInfo.split("\\.");
            A[i] = new Elem();
            A[i].extension = split[1];
        }
    }

    public static void main(String[] args) {
        input();

        Arrays.sort(A, 1, N +1);

        pro();
    }

    static void pro() {
        int count = 1;
        for (int i = 1; i <= N; i++) {
            if (i != N && A[i].extension.equals(A[i + 1].extension)) {
                count += 1;
            } else {
                sb.append(A[i].extension).append(' ').append(count).append('\n');
                count = 1;
            }
        }
        System.out.println(sb);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine(){
            return next();
        }
    }
}
