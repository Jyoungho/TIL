package programers.java.level1.report;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 초기화 작업
        HashMap<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> idMap = new LinkedHashMap<>();
        int[] answer = new int[id_list.length];
        for (String id : id_list){
            idMap.put(id, 0);
        }

        // 신고되는 사람을 key로 HashMap 구성
        for (String reportCase: report) {
            String[] reportCaseList = reportCase.split(" ");
            Set<String> stringList = map.getOrDefault(reportCaseList[1], new HashSet<>());
            stringList.add(reportCaseList[0]);
            map.put(reportCaseList[1], stringList);
        }

        // 알람을 받는 숫자를 idMap 에 저장
        for (String strKey : map.keySet()) {
            Set<String> reporter_list = map.get(strKey);
            if (reporter_list.size() >= k) {
                for (String reporter : reporter_list) {
                    idMap.put(reporter, idMap.get(reporter) + 1);
                }
            }
        }

        return idMap.values().stream().mapToInt(Integer::intValue).toArray();
    }
}