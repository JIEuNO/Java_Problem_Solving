class Solution {
    boolean solution(String s) {
        int len = s.length();
        boolean answer = true;
        char tmp;
        
        Stack stack = new Stack(len);
        
        for (int i = 0; i < len; i++) {
            tmp = s.charAt(i);
            if (stack.isEmpty() || tmp == '(')
                stack.insert(tmp);
            else {
                if (stack.peek() == '(')
                    stack.pop();
                else {
                    answer = false;
                    break;
                }
            }
        }
        
        if (!stack.isEmpty())
            answer = false;

        return answer;
    }
}
class Stack {
    char[] s;
    int top;
    
    Stack(int n) {
        s = new char[n];
        top = -1;
    }
    
    public void insert(char c) {
        top += 1;
        s[top] = c;
    }
    
    public char peek() {
        return s[top];
    }
    
    public void pop() {
        top -= 1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
}