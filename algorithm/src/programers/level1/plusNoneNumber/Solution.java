package programers.level1.plusNoneNumber;

public class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] cnt = new int[10];

        for (int i = 0; i < numbers.length; i++) cnt[numbers[i]] = 1;
        for (int i = 0; i < 10; i++) {
            if (cnt[i] == 0) answer += i;
        }

        return answer;
    }
}
