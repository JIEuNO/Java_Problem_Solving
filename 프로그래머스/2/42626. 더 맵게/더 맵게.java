import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0, len = scoville.length, mix;
        Heap heap = new Heap();
        
        for (int i = 0; i < len; i++)
            heap.insert(scoville[i]);
        
        while (heap.getSize() >= 2 && heap.peek() < K) {
            mix = heap.pop() + (heap.pop() << 1);
            heap.insert(mix);
            answer += 1;
        }
        
        if (heap.isEmpty() || heap.peek() < K)
            return -1;

        return answer;
    }
}

class Heap {
    
    List<Integer> heap;
    
    Heap() {
        heap = new ArrayList<Integer>();
        heap.add(-1);
    }
    
    public int pop() {
        int res = heap.get(1);
        
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        
        int idx = 1, minIdx, min, tmp;
        while ((idx << 1) < heap.size()) {
            min = heap.get(idx << 1);
            minIdx = idx << 1;
            
            if ((idx << 1) + 1 < heap.size()) {
                if (heap.get((idx << 1) + 1) < min) {
                    min = heap.get((idx << 1) + 1);
                    minIdx = (idx << 1) + 1;
                }
            }
            
            if (heap.get(idx) < min)
                break;
            
            tmp = heap.get(idx);
            heap.set(idx, min);
            heap.set(minIdx, tmp);
            
            idx = minIdx;
        }
        
        return res;
    }
    
    public int peek() {
        return heap.get(1);
    }
    
    public void insert(int data) {
        heap.add(data);
        
        int idx = heap.size() - 1, tmp;
        while (idx > 1 && heap.get(idx) < heap.get(idx >> 1)) {
            tmp = heap.get(idx);
            heap.set(idx, heap.get(idx >> 1));
            heap.set(idx >> 1, tmp);
            idx >>= 1;
        }
    }
    
    public boolean isEmpty() {
        return heap.size() == 1;
    }
    
    public int getSize() {
        return heap.size() - 1;
    }
}