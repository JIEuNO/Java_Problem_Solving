import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        boolean isHit;
        List<String> cache = new ArrayList<>();
        
        if (cacheSize == 0)
            return 5 * cities.length;
        
        for (int i = 0; i < cities.length; i++) {
            isHit = false;
            
            for (int j = 0; j < cache.size(); j++) {
                if (cache.get(j).equalsIgnoreCase(cities[i])) {
                    isHit = true;
                    answer += 1;
                    cache.remove(j);
                    cache.add(cities[i]);
                    break;
                }
            }
            
            if (!isHit) {
                answer += 5;
                if (cache.size() >= cacheSize)
                    cache.remove(0);
                cache.add(cities[i]);
            }
        }
        
        return answer;
    }
}