import java.util.Map;
import java.util.HashMap;

class Solution {
    
    Stack stack;
    Map<Character, Character> map = Map.of(
        ']', '[',
        '}', '{',
        ')', '('
    );
    
    public int solution(String s) {
        int answer = 0, len = s.length();
        stack = new Stack(len);
        
        for (int i = 0; i < len; i++) {
            stack.init();
            if (isValid(s.substring(i, len) + s.substring(0, i)))
                answer += 1;
        }
        
        return answer;
    }
    
    public boolean isValid(String s) {
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(')
                stack.insert(c);
            else {
                if (stack.isEmpty() || stack.peek() != map.get(c))
                    return false;
                else
                    stack.pop();
            }
        }
        
        if (!stack.isEmpty())
            return false;
        
        return true;
    }
}

class Stack {
    char[] s;
    int top;
    
    Stack(int size) {
        s = new char[size + 1];
        init();
    }
    
    void insert(char c) {
        top += 1;
        s[top] = c;
    }
    
    char peek() {
        return s[top];
    }
    
    void pop() {
        top -= 1;
    }
    
    boolean isEmpty() {
        return top == -1;
    }
    
    void init() {
        top = -1;
    }
}