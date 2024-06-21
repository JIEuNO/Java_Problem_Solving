import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0, len = tangerine.length, idx = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list;
        
        for (int i = 0; i < len; i++) {
            if (map.containsKey(tangerine[i]))
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            else
                map.put(tangerine[i], 1);
        }
        
        list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        while (k > 0) {
            k -= map.get(list.get(idx));
            idx += 1;
            answer += 1;
        }
        
        return answer;
    }
}