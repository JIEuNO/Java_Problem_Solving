class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length, idx = 0;
        int[] answer = new int[len];
        Node res;
        
        Stack s = new Stack(len + 1);
        s.add(new Node(idx, numbers[idx]));
        idx += 1;
        
        while(idx < len) {
            while(!s.isEmpty() && numbers[idx] > s.peek().number) {
                res = s.pop();
                answer[res.idx] = numbers[idx];
            }
            s.add(new Node(idx, numbers[idx]));
            idx += 1;
        }
        
        while (!s.isEmpty()) {
            res = s.pop();
            answer[res.idx] = -1;
        }
        
        return answer;
    }
}

class Stack {
    Node[] stack;
    int top;
    
    Stack(int size) {
        this.stack = new Node[size];
        this.top = -1;
    }
    
    public void add(Node data) {
        stack[++top] = data;
    }
    
    public Node pop() {
        return stack[top--];
    }
    
    public Node peek() {
        return stack[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
}

class Node {
    int idx, number;
    
    Node(int idx, int number) {
        this.idx = idx;
        this.number = number;
    }
}