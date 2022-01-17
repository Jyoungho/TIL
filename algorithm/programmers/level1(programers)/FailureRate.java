import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        HashMap<Integer, Double> stageFailureRate = stageFailureRate(N, stages);
		List<Integer> keySetList = new ArrayList<>(stageFailureRate.keySet());
		Collections.sort(keySetList, (o1, o2) -> (stageFailureRate.get(o2).compareTo(stageFailureRate.get(o1))));
        answer = keySetList.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
    
    public HashMap<Integer, Double> stageFailureRate(int N, int[] stages){
        
        int stageSurvivor = stages.length;
        HashMap<Integer, Double> stageFailureRate = new HashMap<Integer, Double>();
        
        for( int i = 1; i <= N; i++ ){
            int stageFailCount = 0;
            
            for( int j = 0; j < stages.length; j++ ){
                if(stages[j] == i ){
                    stageFailCount++;
                }
            }
            if(stageSurvivor == 0) stageFailureRate.put( i, 0.0);
            else stageFailureRate.put( i, (double)stageFailCount/stageSurvivor);
            stageSurvivor = stageSurvivor - stageFailCount;    
        }
        
        return stageFailureRate;
    }
}