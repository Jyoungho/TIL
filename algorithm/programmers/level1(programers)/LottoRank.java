class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int variable = 0;
        int correct = 0;
        int rank = 0;
        for( int i = 0; i < lottos.length; i++ ){
            if( lottos[i] == 0 ) variable ++;
            for ( int j = 0; j < win_nums.length; j++ ){
                if( lottos[i] == win_nums[j] ){
                    correct++;
                }                
            }
        }
        
        answer[0] = getGrade(correct + variable);
        answer[1] = getGrade(correct);
        
        return answer;
    }
    
    public int getGrade(int n) {
        switch(n) {
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default :
                return 6;
        }
    }
}