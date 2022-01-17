import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                answer =lcm(answer,arr[j]);
            }
        }

        return answer;
    }   
    
    int gcd(int a, int b) {
        while(b!=0) {
            int r=a%b;
            a=b;
            b=r;
        }
    return a;
    }
        
    int lcm(int a,int b) {
        return a*b/gcd(a,b);
    }
}