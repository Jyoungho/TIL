package programers.level1.StringNumberEnglish;

class Solution {
    public int solution(String s) {
        int parseInt, englishLength;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            StringBuilder sbTemp = new StringBuilder();
            if (c - 'a' > 0) {
                parseInt = 0;
                englishLength = 0;
                switch (s.charAt(i)) {
                    // 0일 경우
                    case 'z':
                        sb.append('0');
                        englishLength = 4;
                        break;
                    // 1일 경우
                    case 'o':
                        sb.append('1');
                        englishLength = 3;
                        break;
                    // 2, 3 일 경우
                    case 't':
                        if(s.charAt(i+1)=='w'){
                            sb.append('2');
                            englishLength = 3;
                            break;
                        }
                        else {
                            sb.append('3');
                            englishLength = 5;
                            break;
                        }
                        // 4, 5 일 경우
                    case 'f':
                        if(s.charAt(i+1)=='o'){
                            sb.append('4');
                            englishLength = 4;
                            break;
                        }
                        else{
                            sb.append('5');
                            englishLength = 4;
                            break;
                        }
                        // 6, 7 일 경우
                    case 's':
                        if(s.charAt(i+1)=='i'){
                            sb.append('6');
                            englishLength = 3;
                            break;
                        }
                        else{
                            sb.append('7');
                            englishLength = 5;
                            break;
                        }
                        // 8 일 경우
                    case 'e':
                        sb.append('8');
                        englishLength = 5;
                        break;
                    //9 일경우
                    case 'n':
                        sb.append('9');
                        englishLength = 4;
                        break;
                }
                i = i + englishLength - 1;
            } else {
                sb.append(c);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}