class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        Node res;
        int[] answer = new int[len];
        Stack s = new Stack(len + 1);
        
        for (int i = 0; i < len; i++) {
            if (!s.isEmpty()) {
                while (!s.isEmpty() && s.peek().price > prices[i]) {
                    res = s.pop();
                    answer[res.idx] = i - res.idx;
                }
            }
            s.insert(new Node(i, prices[i]));
        }
        
        while (!s.isEmpty()) {
            res = s.pop();
            answer[res.idx] = len - res.idx - 1;
        }
        
        return answer;
    }
}

class Stack {
    int top;
    Node[] node;
    
    Stack(int size) {
        this.top = -1;
        node = new Node[size];
    }
    
    public void insert(Node n) {
        node[++top] = n;
    }
    
    public Node peek() {
        return node[top];
    }
    
    public Node pop() {
        return node[top--];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
}

class Node {
    int idx, price;
    
    Node (int idx, int price) {
        this.idx = idx;
        this.price = price;
    }
}
    