import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sumCost = 0;
        Arrays.sort(d);
        for( int i = 0; i < d.length; i++ ){
            budget = budget - d[i];
            if( budget < 0 ) return answer;
            answer++;
        }
        return answer;
    }
}