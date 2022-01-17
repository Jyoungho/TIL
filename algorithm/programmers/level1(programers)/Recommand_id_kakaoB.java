class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        //1단계
        new_id = new_id.toLowerCase();
        
        //2단계
        String match = "[^a-z0-9-_.]";
        new_id = new_id.replaceAll(match, "");
        
        //3단계
        StringBuilder temp_new_id = new StringBuilder(new_id);
        for( int i = 1 ; i < temp_new_id.length() ; i++ ) {
           if( '.' == (temp_new_id.charAt(i)) && '.' == (temp_new_id.charAt(i-1)) ) {
               temp_new_id.delete(i-1, i);
               i--;
           } 
        }
        new_id = temp_new_id.toString();
        
        //4단계
        if( temp_new_id.charAt(0) == '.' ) {
            temp_new_id.deleteCharAt(0);
        }
        if( temp_new_id.length() > 0 ){
            if( temp_new_id.charAt(temp_new_id.length()-1) == '.' ){
                temp_new_id.deleteCharAt(temp_new_id.length()-1);
            }    
        }
        new_id = temp_new_id.toString();
        
        //5단계
        if( "".equals(new_id) ) {
            new_id = "a";
            temp_new_id.append("a");
        }
        
        //6단계
        if( temp_new_id.length() == 16 ){
            temp_new_id.deleteCharAt(15);
            if( '.' ==  temp_new_id.charAt(14) ){
                temp_new_id.deleteCharAt(14);
            }
        }
        if( temp_new_id.length() > 15 ) {
            temp_new_id.delete(15, temp_new_id.length());
            if( '.' ==  temp_new_id.charAt(14) ){
                temp_new_id.deleteCharAt(14);
            }
        }
        new_id = temp_new_id.toString();
        
        //7단계
        if( temp_new_id.length() == 1 ) { 
            temp_new_id.append(temp_new_id.charAt(0));
            temp_new_id.append(temp_new_id.charAt(0));
        }
        if( temp_new_id.length() == 2 ) { 
            temp_new_id.append(temp_new_id.charAt(1));
        }
        new_id = temp_new_id.toString();
        
        answer = new_id;
        return answer;
    }
}