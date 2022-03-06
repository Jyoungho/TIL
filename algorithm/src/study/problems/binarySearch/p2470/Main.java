package study.problems.binarySearch.p2470;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;

    static void input() {
        N = scan.nextInt();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        // 입력 값
        input();

        // 정렬 O(NlogN)
        Arrays.sort(arr, 1, N + 1);

        int v1 = 0;
        int v2 = 0;
        int best_sum = Integer.MAX_VALUE;

        for (int left = 1; left <= N - 1; left++) {
            int candidate = lower_bound(arr, left + 1, N, -arr[left]);

            if (left < candidate - 1 && Math.abs(arr[left] + arr[candidate -1]) < best_sum){
                best_sum = Math.abs(arr[left] + arr[candidate -1]);
                v1 = left;
                v2 = candidate - 1;
            }

            if (left < candidate && candidate <= N && Math.abs(arr[left] + arr[candidate]) < best_sum) {
                best_sum = Math.abs(arr[left] + arr[candidate]);
                v1 = left;
                v2 = candidate;
            }
        }
        sb.append(arr[v1]).append(" ").append(arr[v2]);
        System.out.println(sb);
    }

    static int lower_bound(int[] arr, int L, int R, int X) {
        // A[L...R] 에서 X 이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
        // 그런 게 없다면 R + 1 을 return 한다
        int res = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= X) {
                res = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return res;
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
