import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        ArrayList<Integer> reserveList = new ArrayList<Integer>();
        ArrayList<Integer> lostList = new ArrayList<Integer>();
        
        for( int i = 0; i < reserve.length; i++){
            reserveList.add(reserve[i]);
        }
        for( int i = 0; i < lost.length; i++){
            lostList.add(lost[i]);
        }
        
        for( int j = 0; j < lost.length; j++){
            if(reserveList.contains(lost[j])){
                reserveList.remove((Integer)lost[j]);
                lostList.remove((Integer)lost[j]);
            }
        }
        answer = n - lostList.size();

        for(int i =0; i < lostList.size(); i++){
            for( int j = 0; j < reserveList.size(); j++){
                if( lostList.get(i) == reserveList.get(j)-1){
                    answer++;
                    reserveList.remove(j);
                    j--;
                    break;
                }else if ( lostList.get(i) == reserveList.get(j) + 1){
                    answer++;
                    reserveList.remove(j);
                    j--;
                    break;
                }       
            }
        }
            
        return answer;
    }
}