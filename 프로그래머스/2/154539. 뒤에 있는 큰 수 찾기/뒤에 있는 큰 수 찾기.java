class Solution {
    
    public static int[] stack;
    public static int top = -1;
    public static int[] answer;
    
    public int[] solution(int[] numbers) {
        
        int len = numbers.length;
        answer = new int[len];
        stack = new int[len + 1];
        
        for (int i = len - 1; i >= 0; i--) {
            if (isEmpty())
                answer[i] = -1;
 
            else {
                if (numbers[i] < peek()) {
                    fillAnswer(i);
                }
                else {
                    while (!isEmpty() && numbers[i] >= peek()) {
                        poll();
                    }
                    fillAnswer(i);
                }
            }
            
            insert(numbers[i]);
            
        }
        
        return answer;
    }
    
    public static void fillAnswer(int idx) {
        if (isEmpty())
            answer[idx] = -1;
        else
            answer[idx] = peek();
    }
    
    public static void insert(int a) {
        stack[++top] = a;
    }
    
    public static int peek() {
        return stack[top];
    }
    
    public static int poll() {
        return stack[top--];
    }
    
    public static boolean isEmpty() {
        return top == -1;
    }
}
