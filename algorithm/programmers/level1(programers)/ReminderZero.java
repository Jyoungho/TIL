import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer = getReminderZero(arr, divisor);
        Collections.sort(answer);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public ArrayList<Integer> getReminderZero(int[] arr, int divisor){
        ArrayList<Integer> ReminderZero = new ArrayList<>();
        
        for( int arrE : arr ){
            if( arrE % divisor == 0 ){
                ReminderZero.add(arrE);
            }
        }
        
        if( ReminderZero.size() == 0) ReminderZero.add(-1);
        
        return ReminderZero; 
    }
}