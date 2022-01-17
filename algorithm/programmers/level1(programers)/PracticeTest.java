import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        int[] markMan1Pattern = {1,2,3,4,5};
        int[] markMan2Pattern = {2,1,2,3,2,4,2,5};
        int[] markMan3Pattern = {3,3,1,1,2,2,4,4,5,5};
        
        ArrayList<Integer> markMan1 = new ArrayList<Integer>();
        ArrayList<Integer> markMan2 = new ArrayList<Integer>();
        ArrayList<Integer> markMan3 = new ArrayList<Integer>();
        int markMan1AddNum = answers.length%5; 
        int markMan2AddNum = answers.length%8; 
        int markMan3AddNum = answers.length%10; 
        for(int i = 0; i < answers.length/5; i ++){
            markMan1.add(1);
            markMan1.add(2);
            markMan1.add(3);
            markMan1.add(4);
            markMan1.add(5);
        }
        if( markMan1AddNum != 0 ){
            for(int i = 0; i < markMan1AddNum; i++){
                markMan1.add(markMan1Pattern[i]);
            }
        }
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == markMan1.get(i)){
                score1++;
            }
        }
        
        for(int i = 0; i < answers.length/8; i ++){
            markMan2.add(2);
            markMan2.add(1);
            markMan2.add(2);
            markMan2.add(3);
            markMan2.add(2);
            markMan2.add(4);
            markMan2.add(2);
            markMan2.add(5);
        }
        if( markMan2AddNum != 0 ){
            for(int i = 0; i < markMan2AddNum; i++){
                markMan2.add(markMan2Pattern[i]);
            }
        }
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == markMan2.get(i)){
                score2++;
            }
        }
        
        for(int i = 0; i < answers.length/10; i ++){
            markMan3.add(3);
            markMan3.add(3);
            markMan3.add(1);
            markMan3.add(1);
            markMan3.add(2);
            markMan3.add(2);
            markMan3.add(4);
            markMan3.add(4);
            markMan3.add(5);
            markMan3.add(5);
        }
        if( markMan3AddNum != 0 ){
            for(int i = 0; i < markMan3AddNum; i++){
                markMan3.add(markMan3Pattern[i]);
            }
        }
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == markMan3.get(i)){
                score3++;
            }
        }
        
        Integer[] highScore = {score1, score2, score3};
        Arrays.sort(highScore, (i1, i2) -> i2 - i1);
        ArrayList<Integer> highAnswer = new ArrayList<>();
        
        if( highScore[0] == score1){
            highAnswer.add(1);
        }
        if( highScore[0] == score2){
            highAnswer.add(2);
        }
        if( highScore[0] == score3){
            highAnswer.add(3);
        }
        answer = new int[highAnswer.size()];
        for( int i = 0; i < highAnswer.size(); i++){
            answer[i] = highAnswer.get(i);
        }
        return answer;
    }
}

// import java.util.ArrayList;

// class Solution {
//     public int[] solution(int[] answer){
//         int[] a = {1,2,3,4,5};
//         int[] b = {2,1,2,3,2,4,2,5};
//         int[] c = {3,3,1,1,2,2,4,4,5,5};
//         int[] score = new int[3];
//         for(int i = 0; i < answer.length; i++){
//             if(answer[i] == a[i%a.length]) {score[0]++;}
//             if(answer[i] == b[i%b.length]) {score[1]++;}
//             if(answer[i] == c[i%c.length]) {score[2]++;}
//         }
//         int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
//         ArrayList<Integer> list = new ArrayList<>();
//         if(maxScore == score[0]) {list.add(1);}
//         if(maxScore == score[1]) {list.add(2);}
//         if(maxScore == score[2]) {list.add(3);}
//         return list.stream().mapToInt(i -> i.intValue()).toArray();
//     }
// }