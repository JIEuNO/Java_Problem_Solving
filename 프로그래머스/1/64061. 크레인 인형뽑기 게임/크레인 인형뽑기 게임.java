class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0, n = board.length, len = moves.length;
        int pick;
        
        Stack s = new Stack(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n; j++) {
                pick = board[j][moves[i] - 1];
                if (pick != 0) {
                    board[j][moves[i] - 1] = 0;
                    if (!s.isEmpty() && s.peek() == pick) {
                        s.pop();
                        answer += 2;
                    }
                    else
                        s.insert(pick);
                    break;
                }
            }
        }
        
        return answer;
    }
}
class Stack {
    int[] s;
    int top;
    
    Stack(int len) {
        s = new int[len + 1];
        top = -1;
    }
    
    public int peek() {
        return s[top];
    }
    
    public void pop() {
        top -= 1;
    }
    
    public void insert(int a) {
        s[++top] = a;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
}