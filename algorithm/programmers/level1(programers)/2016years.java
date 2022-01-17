import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] DAY = new String[] {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2016);
        cal.set(Calendar.MONTH, a-1);
        cal.set(Calendar.DATE, b);
        
        for(int i = 1; i < DAY.length+1; i++ ){
            if(cal.get(Calendar.DAY_OF_WEEK) == i){
                answer = DAY[i-1];
            }
        }
    
        return answer;
    }
}