package study.problems.p14888;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P14888 {
    static StringBuilder sb = new StringBuilder();
    int countNumber;
    List<Integer> numbers;
    List<Integer> operators;

    void input() {
        FastReader scan = new FastReader();
        countNumber = scan.nextInt();
        numbers = scan.nextList();
        operators = scan.nextList();
    }

    public static void main(String[] args) {
        P14888 p14888 = new P14888();
        // input count, numbers, operators
        p14888.input();

        int result = 0;

        // 숫자들의 조합을 모두 반환하는 배열을 구한다.
        List<List<Integer>> numbersCombination = p14888.getAllNumbersCombination(0);

        // 연산자들의 조합을 모두 반환하는 배열을 구한다.
        List<List<Integer>> operatorsCombination = p14888.getAllOperatorsCombination(0);

        // 숫자들을 조합을 기준으로 연산 및 최대값 최소값을 구한다.
        for (List<Integer> numbers : numbersCombination) {
            for (int j = 0; j < numbers.size(); j++) {
                for (List<Integer> operators : operatorsCombination) {
                    if (operators.get(j) == 0) {
                        result = result + numbers.get(j + 1);
                    } else if (operators.get(j) == 1) {
                        result = result - numbers.get(j + 1);
                    } else if (operators.get(j) == 2) {
                        result = result * numbers.get(j + 1);
                    } else {
                        result = result / numbers.get(j + 1);
                    }
                }
            }
        }
    }

    private List<List<Integer>> getAllNumbersCombination(int k) {
        return null;
    }

    private List<List<Integer>> getAllOperatorsCombination(int k) {
        return null;
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
                    st = new StringTokenizer(br.readLine(), "\n");
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

        List<Integer> nextList() {
            return Arrays.stream(next().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
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
