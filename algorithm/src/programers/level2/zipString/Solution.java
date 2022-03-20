package programers.level2.zipString;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        // N개의 단위로 짜르는 방법을 N번 확인한고 그 중 최소 값을 반환한다.
        for (int i = 1; i < s.length(); i++) {
            System.out.println(zip(i, s));
        }

        return answer;
    }
    static int curCount;
    static String before;

    static String zip(int length, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            curCount = 1;
            String cur1 = cur(i, s, length);
            before = null;
            System.out.println(cur1);
            if (cur1 != null)  {
                sb.append(cur1);
                i = i + (cur1.length() - 1) * Integer.parseInt(cur1.substring(0, 1)) - 1;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    static String cur(int start, String s, int length) {
        StringBuilder sb = new StringBuilder();
        if (start + length > s.length()){
            return null;
        }
        for (int i = start; i < start + length; i++) {
            sb.append(s.charAt(i));
        }
        String first = sb.toString();
        if (before == null || before.equals(first)){
            curCount++;
            cur(start + length, s, length);
        }

        if (curCount > 1) {
            sb = new StringBuilder();
            sb.append(curCount).append(before);
        } else {
            return null;
        }
        return sb.toString();
    }
}
