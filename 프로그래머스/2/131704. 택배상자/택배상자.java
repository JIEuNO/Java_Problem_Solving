class Solution {
    public int solution(int[] order) {
        int answer = 0, len = order.length;
        int[] num = new int[len];
        Stack stack = new Stack(len + 1);
        
        for (int i = 0; i < len; i++) {
            num[order[i] - 1] = i;
        }
        
        for (int i = 0; i < len; i++) {
            if (num[i] == answer) {
                answer += 1;
            }
            else {
                while (!stack.isEmpty() && stack.peek() == answer) {
                    stack.pop();
                    answer += 1;
                }
                stack.insert(num[i]);
            }
        }
        
        while (!stack.isEmpty()) {
            if (stack.pop() == answer) 
                answer += 1;
            else
                break;
        }
        
        return answer;
    }
}

class Stack {
    int top;
    int[] s;
    
    Stack(int size) {
        top = -1;
        s = new int[size];
    }
    
    public void insert(int data) {
        s[++top] = data;
    }
    
    public int peek() {
        return s[top];
    }

    public int pop() {
        return s[top--];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
}