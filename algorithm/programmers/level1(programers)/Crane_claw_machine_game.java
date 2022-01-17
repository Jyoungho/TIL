// import java.util.Stack;

// class Solution {
//     public int solution(int[][] board, int[] moves) {
//         int answer = 0;
//         Stack<Integer> bascket = new Stack<>();
//         bascket.push(0);
//         for( int i = 0; i < moves.length; i++ ){
//             for( int j = board[moves[i] - 1 ].length - 1 ; j >= 0 ; j-- ){
//                 if( board[moves[i] - 1 ][j] != 0 ){
//                     if(bascket.peek() == board[moves[i] - 1 ][j]){
//                         answer = answer + 2;
//                         bascket.pop();
//                     }else{
//                         bascket.push(board[moves[i] - 1 ][j]);
//                     }
//                     board[moves[i] - 1 ][j] = 0;
//                     break;
//                 }
//             }
//         }
//         return answer;
//     }
// }




import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                    if (board[j][move - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else
                        stack.push(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}