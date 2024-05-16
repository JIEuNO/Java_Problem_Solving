import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0, len = nums.length, n = len >> 1;
        Map<Integer, Boolean> mon = new HashMap<>();
        
        for (int i = 0; i < len && answer < n; i++) {
            if (!mon.containsKey(nums[i])) {
                answer += 1;
                mon.put(nums[i], true);
            }
        }
        
        return answer;
    }
}