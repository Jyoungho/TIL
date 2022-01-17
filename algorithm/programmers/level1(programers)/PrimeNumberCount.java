class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int plusThreeItems = 0;
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        for( int i = 0 ; i < nums.length; i++ ){
            for( int j = i + 1 ; j < nums.length; j++ ){
                for( int z = j + 1; z < nums.length; z++){
                    int division = 2;
                    plusThreeItems = nums[z] + nums[j] + nums[i];
                    while(true){
                        if(plusThreeItems%division == 0){
                            break;
                        }else{
                            division++;
                            if( division == plusThreeItems ){
                                answer++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}