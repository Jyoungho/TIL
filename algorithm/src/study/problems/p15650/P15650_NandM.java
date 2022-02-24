package study.problems.p15650;

import java.io.*;
import java.util.StringTokenizer;

public class P15650_NandM {
    public static void main(String[] args) {
        P15650_NandM p15650_nandM = new P15650_NandM();

        p15650_nandM.input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞는 모든 방법을 찾아줘
        p15650_nandM.rec_func(1);
        System.out.println(sb.toString());
    }

    static StringBuilder sb = new StringBuilder();

    void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M];
    }

    int N, M;
    int[] selected;
    // Recurrence Function (재귀 함수)
    // M 개를 전부 고름 -> 탐색 종료
    // M 개를 고르지 않음 -> k 번째부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
    void rec_func(int k){
        if (k == M + 1) {
            for (int i = 0; i < M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= N; cand++) {
                // k 번째에 cand 가 올 수 있으면,
                selected[k - 1] = cand;
                rec_func(k + 1);
                selected[k - 1] = 0;
            }
        }
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
