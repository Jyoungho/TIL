package programers.level2.openChat;

import java.util.*;

public class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> userInfo = new HashMap<>();

        for (String s : record) {
            String[] record_split = s.split(" ");
            if (record_split[0].equals("Enter")) {
                if (userInfo.get(record_split[1]) != null &&
                        userInfo.get(record_split[1]).equals(record_split[2])) continue;
                userInfo.put(record_split[1], record_split[2]);
            } else if (record_split[0].equals("Change")) {
                userInfo.put(record_split[1], record_split[2]);
            }
        }

        for (String s : record) {
            String[] record_split = s.split(" ");
            StringBuilder sb = new StringBuilder();

            if (record_split[0].equals("Enter")) {
                sb.append(userInfo.get(record_split[1])).append("님이 들어왔습니다.");
            } else if (record_split[0].equals("Leave")) {
                sb.append(userInfo.get(record_split[1])).append("님이 나갔습니다.");
            }
            if (!sb.toString().isEmpty())
                answer.add(sb.toString());
        }

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] input = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] input2 = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234"};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(input)));
        System.out.println(Arrays.toString(s.solution(input2)));
    }
}
