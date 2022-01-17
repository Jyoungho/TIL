import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Double> array = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            array.add(Math.ceil((100 - progresses[i]) / (double)speeds[i]));
        }
        for(int i = 0; i < array.size(); i++){
            if(i == array.size() -1){
                answer.add(1);
            }
            for(int j = i + 1; j < array.size(); j++) {
                if(array.get(i) < array.get(j)) {
                    answer.add(j-i);
                    i = j-1;
                    break;
                }else if( j == array.size() - 1){
                    answer.add(array.size() - i);
                    i = j;
                    break;
                }
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
        
        
        

//         list set 을 활용해서 끝 변수만 변경 가능하다.
        
//         ArrayList<Integer> list = new ArrayList<>();
//         int temp = 0;
//         for (int i = 0; i < progresses.length; i++) {
//             int current = (100 - progresses[i]) / speeds[i];
//             if (temp < current) {
//                 temp = current;
//                 list.add(1);
//             } else list.set(list.size() - 1, list.get(list.size() - 1) + 1);
//         }

//         return list.stream().mapToInt(Integer::intValue).toArray();
    }
}