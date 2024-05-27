import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        int[] sum = new int[len];
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sum[j] += elements[(j + i) % len];
                if (!set.contains(sum[j]))
                    set.add(sum[j]);
            }
        }
        
        return set.size();
    }
}