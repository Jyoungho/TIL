import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> tempPart = new HashMap<>();
        
        for(String part : participant){
            if(tempPart.get(part) == null){
                tempPart.put(part,1);
            }else{
                tempPart.put(part, tempPart.get(part) + 1);
            }
        }
        
        for(String comp : completion){
            tempPart.put(comp,tempPart.get(comp) - 1);
        }
        
        for(String key : tempPart.keySet()){
            if(tempPart.get(key) == 1) answer = key;
        }
        
        return answer;
    }
}