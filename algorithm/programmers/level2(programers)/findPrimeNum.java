import java.util.*;

class Solution {
    
    private int count;
    private HashSet<String> set = new HashSet<>();
    
    public int solution(String numbers) {
        
        int size = numbers.length();
        
        List<Character> arr = new ArrayList<>();
        for (int i =0; i < size; i++) {
            arr.add(numbers.charAt(i));
        }
        
        List<Character> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            permutation(arr, result, size, i + 1);
        }
        
        return count;
    }
    
    public void permutation(List<Character> arr, List<Character> result, int size, int select) {
        
        if (select == 0) {
            if (result.get(0) != '0') {
                String str = "";
                int resultSize = result.size();
                
                for(int i = 0; i < resultSize; i++) {
                    str += result.get(i);
                }
                
                int num = 0;
                
                if (!set.contains(str)) {
                    num = Integer.parseInt(str);
                    set.add(str);
                    
                    if (isPrime(num)) {
                        count++;
                    }
                }
            }
            return ;
        }
        
        for (int i = 0; i < size; i++) {
            
            result.add(arr.remove(i));
            permutation(arr, result, size - 1, select - 1);
            arr.add(i, result.remove(result.size() - 1));
        }
    }
    
    private boolean isPrime(int num) {
        
        int sqrt = (int) Math.sqrt(num);
        
        if( num == 2) return true;
        else if (num % 2 == 0 || num == 1) return false;
        for (int i = 3; i <= sqrt; i += 2) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
}