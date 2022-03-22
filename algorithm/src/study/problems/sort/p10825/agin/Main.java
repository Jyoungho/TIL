package study.problems.sort.p10825.agin;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Student implements Comparable<Student> {
        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Student o) {
            if (korean != o.korean) return o.korean - korean;
            if (english != o.english) return english - o.english;
            if (math != o.math) return o.math - math;
            return name.compareTo(o.name);
        }
    }

    static int N;
    static Student[] A;

    static void input() {
        N = scan.nextInt();
        A = new Student[N];
        for (int i = 0; i < N; i++) {
            A[i] = new Student();
            A[i].name = scan.next();
            A[i].korean = scan.nextInt();
            A[i].english = scan.nextInt();
            A[i].math = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        Arrays.sort(A);
        for (int i = 0; i < N; i++) {
            sb.append(A[i].name).append('\n');
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
