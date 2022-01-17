import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> plusItems = new HashSet<>();
        for( int i = 0 ; i < numbers.length; i++ ){
            for( int j = i + 1; j < numbers.length; j++ ){
                plusItems.add(numbers[i] + numbers[j]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(plusItems);
        Collections.sort(list);
        answer = new int[list.size()];
        for( int i = 0 ; i < list.size(); i++ ){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
// 1. set to array
// return plusItems.stream().sorted().mapToInt(Integer::intValue).toArray();
        
// 2. use Iterator
// ArrayList<Integer> answer = new ArrayList<>();
// HashSet<Integer> set = new HashSet<>();

// for (int i = 0; i < numbers.length - 1; i++) {
//     for (int j = i + 1; j < numbers.length; j++) {
//         set.add(numbers[i] + numbers[j]);
//     }
// }

// Iterator<Integer> iter = set.iterator();
// while(iter.hasNext()) {
//     answer.add(iter.next());
// }

// Collections.sort(answer);
// return answer;
