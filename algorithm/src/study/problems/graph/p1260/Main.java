package study.problems.graph.p1260;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        adj = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x][y] = adj[y][x] = 1;
        }
    }

    static void dfs(int start) {
        // x 를 방문했다.
        visit[start] = true;
        sb.append(start).append(' ');
        for (int y = 1; y <= N; y++) {
            if (adj[start][y] == 0) continue;
            if (visit[y]) continue;
            dfs(y);
        }
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        // start는 방문 가능한 점이므로 que에 넣어준다.
        que.add(start);
        visit[start] = true;  // start를 갈 수 있다고 표시하기 (중요!!!)

        while (!que.isEmpty()) {  // 더 확인할 점이 없다면 정지
            int x = que.poll();

            sb.append(x).append(' ');
            for (int y = 1; y <= N; y++) {
                if (adj[x][y] == 0) continue;
                if (visit[y]) continue;  // x 에서 y 를 갈 수는 있지만, 이미 탐색한 점이면 무시

                // y를 갈 수 있으니까 que에 추가하고, visit 처리 하기!
                que.add(y);
                visit[y] = true;
            }
        }
    }

    public static void main(String[] args) {
        //input
        input();

        pro();
    }

    static void pro() {
        visit = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        for (int i = 1; i <= N; i++) visit[i] = false;
        bfs(V);
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
