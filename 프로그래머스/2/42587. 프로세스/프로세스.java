import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0, len = priorities.length;
        Queue queue = new Queue(len + 1);
        Heap maxHeap = new Heap();
        int res = -1, max;
        
        for (int i = 0; i < priorities.length; i++) {
            queue.enQueue(i);
            maxHeap.push(priorities[i]);
        }
        
        while (true) {
            res = queue.deQueue();
            max = maxHeap.peek();
            if (priorities[res] == max) {
                answer += 1;
                maxHeap.pop();
                if (res == location)
                    break;
            }  
            else
                queue.enQueue(res);
        }
        
        return answer;
    }
}

class Heap {
    List<Integer> heap;
    
    Heap() {
        heap = new ArrayList<>();
        heap.add(-1);
    }
    
    public void push(int data) {
        heap.add(data);
        int idx = heap.size() - 1, tmp;
        
        while(idx > 1 && heap.get(idx) > heap.get(idx >> 1)) {
            tmp = heap.get(idx);
            heap.set(idx, heap.get(idx >> 1));
            heap.set(idx >> 1, tmp);
            idx >>= 1;
        }
    }
    
    public int peek() {
        return heap.get(1);
    }
    
    public int pop() {
        int res = heap.get(1), tmp;
        int idx, left, right, maxIdx, maxVal;
        
        idx = heap.size() - 1;
        heap.set(1, heap.get(idx));
        heap.remove(idx);

        idx = 1;
        while ((idx << 1) < heap.size()) {
            left = idx << 1;
            right = left + 1;
            
            if (right < heap.size() 
                && heap.get(right) > heap.get(left)) {
                maxIdx = right;
                maxVal = heap.get(right);
            }
            else {
                maxIdx = left;
                maxVal = heap.get(left);
            }
            
            if (heap.get(idx) > heap.get(maxIdx))
                break;
            
            tmp = heap.get(idx);
            heap.set(idx, heap.get(maxIdx));
            heap.set(maxIdx, tmp);
            
            idx = maxIdx;
        }
        
        return res;
    }    
}

class Queue {
    int front, rear, size;
    int[] queue;
    
    Queue(int size) {
        queue = new int[size];
        this.front = 0;
        this.rear = 0;
        this.size = size;
    }
    
    public void enQueue(int data) {
        queue[rear] = data;
        rear = (rear + 1) % size;
    }
    
    public int deQueue() {
        int idx = front;
        front = (front + 1) % size;
        return queue[idx];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
}