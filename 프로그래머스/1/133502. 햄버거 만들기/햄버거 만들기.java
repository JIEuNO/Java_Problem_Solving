class Solution {
    public static int num = 4;
    
    public int solution(int[] ingredient) {
        int answer = 0, len = ingredient.length;
        Stack s = new Stack(len);
        
        // hamburger = 1231
        for (int i = 0; i < len; i++) {
            if (s.checkLast4()) {
                for (int j = 0; j < num; j++)
                    s.pop();
                answer += 1;
            }
            s.insert(ingredient[i]);      
        }
        
        if (s.checkLast4())
            answer += 1;
        
        return answer;
    }
}
class Stack {
    int[] stack;
    int top;
    
    Stack(int size) {
        stack = new int[size];
        this.top = -1;
    }
    
    public void insert(int ing) {
        stack[++top] = ing;
    }
    
    public void pop() {
        top -= 1;
    }
    
    public boolean checkLast4() {
        if (top - 3 < 0)
            return false;
            
        return stack[top - 3] == 1 && stack[top - 2] == 2 
            && stack[top - 1] == 3 && stack[top] == 1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
}