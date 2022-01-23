package study.dynamic;

public class DynamicProgramming {
    public int fibonacci (int index) {
        int[] cache = new int[index + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i < index + 1; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[index];
    }

    public static void main(String[] args) {
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        int result = dynamicProgramming.fibonacci(10);
        System.out.println(result);
    }
}
