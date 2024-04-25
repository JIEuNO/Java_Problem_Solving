class Solution {
    public int[] solution(int k, int[] score) {
        int len = score.length;
        int[] answer = new int[len];
        Heap minHeap = new Heap(k + 2);
        
        for (int i = 0; i < len; i++) {
            if (minHeap.idx == k) {
                minHeap.insert(score[i]);
                minHeap.pop();
            }
            else
                minHeap.insert(score[i]);
            
            answer[i] = minHeap.peek();
        }
        
        return answer;
    }
}

class Heap {
    public int size, idx;
    public int[] heap;
    
    Heap (int size) {
        this.size = size;
        this.idx = 0;
        this.heap = new int[size];
    }
    
    public void insert(int score) {
        heap[++idx] = score;
        heapify_up();
    }
    
    public int peek() {
        return heap[1];
    }
    
    public int pop() {
        int res = heap[1];
        heap[1] = heap[idx--];
        heapify_down();
        
        return res;
    }
    
    public void heapify_up() {
        int tmp, pos = this.idx;
        while (pos > 1 && heap[pos >> 1] > heap[pos]) { // parent > child
            tmp = heap[pos];
            heap[pos] = heap[pos >> 1];
            heap[pos >> 1] = tmp;
            pos >>= 1;
        }
    }
    
    public void heapify_down() {
        int pos = 1, left, right, min, tmp;
        
        while ((pos << 1) < this.size) {
            left = pos << 1;
            right = left + 1;
            
            if (right < this.size) { // right child exists
                if (heap[left] < heap[right])
                    min = left;
                else 
                    min = right;
            }
            else
                min = left;
            
            if (heap[min] < heap[pos]) { // child < parent
                tmp = heap[pos];
                heap[pos] = heap[min];
                heap[min] = tmp;
                pos = min;
            }
            else
                break;
        }
    }
}