package study.test.t1.p20167;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, K, sum, ans;
    static int[] A;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
        sc.close();
    }


    public static void main(String[] args) {
        input();
        pro();
//        System.out.println(ans);
    }

    static void pro() {
        for (int L = 1, R = 0; L <= N; L++) {
            int cum1, cum2;
            sum = 0;

            while (R + 1 <= N) {
                R++;
                sum += A[R];
                if (R == N) {
                    if (sum - K > 0)  {
                        ans += sum - K;
                    }
                    break;
                } else if (sum >= K && R + 1 <= N) {
                    cum1 = sum - K;
                    cum2 = sum - A[L] + A[R + 1] - K;
                    if (cum2 < 0 && R + 2 <= N) {
                        cum2 = sum - A[L] + A[R + 1] + A[R + 2] - K;
                        if (cum1 < cum2) {
                            ans += cum2;
                            R++;
                            R++;
                            break;
                        }
                    }
                    if (cum1 < cum2) {
                        ans += cum2;
                        R++;
                    }else {
                        ans += cum1;
                    }
                    break;
                }
            }
//            System.out.println("L : " + L);
//            System.out.println("R : " + R);
            L = R;
//            System.out.println("ans : " + ans);
        }
    }
}
