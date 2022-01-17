class Solution {
    public String solution(int num) {
        String answer = "";
        
        if(num % 2 == 0) return answer =  "Even";
        if(num % 2 == 1) return answer = "Odd";
        if(num % 2 == -1) return answer = "Odd";
        return answer;
    }
}