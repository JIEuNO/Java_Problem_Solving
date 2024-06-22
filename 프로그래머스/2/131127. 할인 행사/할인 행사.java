import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    Map<String, Integer> wantMap;
    Map<String, Integer> disMap;
    int cnt = 10;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0, len = discount.length;
        wantMap = new HashMap<>();
        disMap = new HashMap<>();
        
        init(want, number, discount);
        
        if (isContain())
            answer += 1;
        
        for (int i = 0; i < len - cnt; i++) {           
            if (disMap.get(discount[i]) == 1)
                disMap.remove(discount[i]);
            else
                disMap.put(discount[i], disMap.get(discount[i]) - 1);
        
            if (disMap.containsKey(discount[i + cnt]))
                disMap.put(discount[i + cnt], disMap.get(discount[i + cnt]) + 1);
            else
                disMap.put(discount[i + cnt], 1);
            
            if (isContain())
                answer += 1;
        }
        
        return answer;
    }
    
    public boolean isContain() {
        return wantMap.equals(disMap);
    }
    
    public void init(String[] want, int[] number, String[] discount) {
        for (int i = 0; i < want.length; i++)
            wantMap.put(want[i], number[i]);
        
        for (int i = 0; i < cnt; i++) {
            if (disMap.containsKey(discount[i]))
                disMap.put(discount[i], disMap.get(discount[i]) + 1);
            else
                disMap.put(discount[i], 1);
        }
    }
}