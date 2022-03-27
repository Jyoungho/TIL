package study.problems.graph.p2178.again;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static int N, M;
    static String[] A;
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static boolean[][] visit;
    static int[][] dis;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        visit = new boolean[N][M];
        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextLine();
        }
        dis = new int[N][M];
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        bfs(0, 0);
        System.out.println(dis[N - 1][M - 1]);
    }

    static void bfs(int startX, int startY) {
        Queue<Integer> que = new LinkedList<>();

        // dist 배열 초기화
        // dist[i][j] == -1 -> 아직 가보지 않는 곳이라 정의
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dis[i][j] = -1;
            }
        }

        que.add(startX);
        que.add(startY);

        visit[startX][startY] = true;
        dis[startX][startY] = 1;

        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (A[nx].charAt(ny) == '0') continue;

                que.add(nx);
                que.add(ny);
                visit[nx][ny] = true;
                dis[nx][ny] = dis[x][y] + 1;
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
