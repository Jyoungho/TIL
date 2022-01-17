import java.util.*;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        answer = sum(a,b);
        
        return answer;
    }
    
    public long sum(int a, int b) {
        long sum = 0;
        
        ArrayList<Integer> startEndNum = new ArrayList<>();
        startEndNum.add(a);
        startEndNum.add(b);
        Collections.sort(startEndNum);
        
        for( int i = startEndNum.get(0); i <= startEndNum.get(1); i++){
            sum += i ;
        }
        
        return sum;
    }
}