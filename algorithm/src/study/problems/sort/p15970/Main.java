package study.problems.sort.p15970;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] a;

    static void input() {
        N = scan.nextInt();
        a = new ArrayList[N + 1];
        for (int color = 1; color <= N; color++) {
            a[color] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= N; i++) {
            int coord, color;
            coord = scan.nextInt();
            color = scan.nextInt();
            a[color].add(coord);
        }
    }

    public static void main(String[] args) {
        input();

        // 각 색깔별 오름차순 정렬
        // 시간복잡도 O(NlogN) 공간복잡도 O(N) -> Collections sort 는 최대 NlogN 의 시간복잡도를 보장 (Tim sort)
        for (int color = 1; color <= N; color++) {
            Collections.sort(a[color]);
        }

        int result = 0;
        // 각 color 별로 최단거리 계산
        for (int color = 1; color <= N; color++) {
            for (int i = 0; i < a[color].size(); i++) {
                int left = toLeft(color, i);// 왼쪽의 가장 가까운 거리를 구한다.
                int right = toRight(color, i);// 오른쪽의 가장 가까운 거리를 구한다.
                result += Math.min(left, right);
            }
        }

        System.out.println(result);
    }

    static private int toLeft(int color, int index) {
        if (index == 0) return Integer.MAX_VALUE;
        return a[color].get(index) - a[color].get(index - 1);
    }

    static private int toRight(int color, int index) {
        if (index == a[color].size() -1) return Integer.MAX_VALUE;
        return a[color].get(index + 1) - a[color].get(index);
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
