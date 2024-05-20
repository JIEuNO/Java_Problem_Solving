class Solution
{
    public int solution(String s)
    {
        int answer = 1, len = s.length();
        Stack st = new Stack(len + 1);
        char tmp;
        
        for (int i = 0; i < len; i++) {
            tmp = s.charAt(i);
            if (st.isEmpty())
                st.insert(tmp);
            else if (st.peek() == tmp)
                st.pop();
            else
                st.insert(tmp);
        }
        
        if (!st.isEmpty())
            answer = 0;
        
        return answer;
    }
}

class Stack {
    char[] stack;
    int top;
    
    Stack (int size) {
        stack = new char[size];
        top = -1;
    }
    
    public void insert(char c) {
        top += 1;
        stack[top] = c;
    }
    
    public char peek() {
        return stack[top];
    }
    
    public void pop() {
        top -= 1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
}