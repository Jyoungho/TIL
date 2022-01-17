import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> hashMap = new HashMap<>();
        String standard = "";
        
        for(int i = 0; i < phone_book.length; i++){
            hashMap.put(phone_book[i], "prefix");
        }
        
        for(String phone : phone_book){
            // idx = phone.length();
            
            for(int idx = 0; idx < phone.length(); idx++) {
                System.out.println(phone.substring(0, idx));
                if(hashMap.containsKey(phone.substring(0, idx)))
                    System.out.println("q");
                    answer = false;
            }
        }
        
        return answer;
    }
}