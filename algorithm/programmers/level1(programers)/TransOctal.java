class Solution {
    public int solution(int n) {
        int answer = 0;
        String ternaryScale = "";
        String reverseTernaryScale = "";
        while ( n > 0 ){
            ternaryScale = n%3 + ternaryScale;
            n = n/3;
        }

        reverseTernaryScale = new StringBuffer(ternaryScale).reverse().toString();
        
        for(int i = 0 ; i < reverseTernaryScale.length(); i++){
            if( i == 0){
                answer = Character.getNumericValue(reverseTernaryScale.charAt(reverseTernaryScale.length()-1));
            } else{
                answer = answer + Character.getNumericValue(reverseTernaryScale.charAt(reverseTernaryScale.length()-i-1)) * (int)Math.pow(3, i);
            }
        }
        return answer;
    }
}