import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> tempList =  new ArrayList<>();
        
        for( int i = 0; i < arr.length; i++ ){
            if(i == 0){
                tempList.add(arr[i]);
            }else if( i != 0 ){
                if(arr[i] == arr[i-1]){
                    continue;
                }else{
                    tempList.add(arr[i]);
                }
            }
        }
        answer = tempList.stream().mapToInt(i->i).toArray();

        return answer;
    }
}