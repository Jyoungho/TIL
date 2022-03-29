package programers.level2.rotateMatrix;

import java.util.Arrays;

public class Solution {
    static int[][] matrix;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        matrix = new int[rows + 1][columns + 1];
        for (int i = 1; i <= rows; i++)
            for (int j = 1; j <= columns; j++)
                matrix[i][j] = j + (i - 1) * columns;

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }
        return answer;
    }

    public int rotate(int[] query) {
        System.out.println(Arrays.toString(query));
        int raw1 = query[0], col1 = query[1], raw2 = query[2], col2 = query[3];
        int temp = matrix[raw1][col1];
        int min = temp;
        for (int i = raw1; i < raw2; i++) {
            matrix[i][col1] = matrix[i + 1][col1];
            if (min > matrix[i][col1]) min = matrix[i][col1];
        }
        for (int i = col1; i < col2; i++) {
            matrix[raw2][i] = matrix[raw2][i + 1];
            if (min > matrix[raw2][i]) min = matrix[raw2][i];
        }
        for (int i = raw2; i > raw1; i--) {
            matrix[i][col2] = matrix[i - 1][col2];
            if (min > matrix[i][col2]) min = matrix[i][col2];
        }
        for (int i = col2; i > col1; i--) {
            matrix[raw1][i] = matrix[raw1][i - 1];
            if (min > matrix[raw1][i]) min = matrix[raw1][i];
        }
        matrix[raw1][col1 + 1] = temp;
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
    }

}
