import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow;
        
        ArrayList<Integer> divisor = new ArrayList<>();
        
        divisor = divisor(area);
        answer = calBrownYellow(divisor, brown, yellow);
        
        return answer;
    }
    
    public ArrayList<Integer> divisor(int area){
        ArrayList<Integer> divisor = new ArrayList<>();
        
        for( int i = 1; i <= area; i++ ){
            if(area % i == 0){
                divisor.add(i);
            }
        }
        
        return divisor;
    }
    
    public int[] calBrownYellow(ArrayList<Integer> divisor, int brown, int yellow){
        int[] answer = new int[2];
        int width = 0;
        int height = 0;
        int divisorSizeHalf = 0;
        
        if(divisor.size() % 2 == 0) divisorSizeHalf = divisor.size()/2;
        else if(divisor.size() % 2 ==1 ) divisorSizeHalf = divisor.size()/2+1;
            
        for(int j = 0; j < divisorSizeHalf; j++){
            width = divisor.get(divisor.size()-1-j);
            height = divisor.get(j);
            if(height == 1){
                if(brown == width && yellow == 0){
                    answer[0] = width;
                    answer[1] = height;
                }
            }
            if(height == 2){
                if(brown == width*2 && yellow ==0){
                    answer[0] = width;
                    answer[1] = height;
                }
            }
            if(height >= 3){
                if(brown == 2*(width-2) + 2*(height) && yellow == width*height - brown){
                    answer[0] = width;
                    answer[1] = height;
                }
            }
        }
        
        return answer;
    }
}