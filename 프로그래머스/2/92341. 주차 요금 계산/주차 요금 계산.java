import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int len = records.length, cal;
        int[] answer;
        Map<String, String> park = new HashMap<>();
        Map<String, Integer> store = new HashMap<>();
        String[] str;
        
        for (int i = 0; i < len; i++) {
            str = records[i].split(" ");
            if (park.containsKey(str[1])) {
                cal = calculateMin(park.get(str[1]), str[0]);
                if (store.containsKey(str[1]))
                    store.put(str[1], store.get(str[1]) + cal);
                else
                    store.put(str[1], cal);
                park.remove(str[1]);
            }
            else
                park.put(str[1], str[0]);
        }
        
        for (String key : park.keySet()) {
            cal = calculateMin(park.get(key), "23:59");
            if (store.containsKey(key))
                    store.put(key, store.get(key) + cal);
            else
                store.put(key, cal);
        }
        
        answer = new int[store.size()];
        List<String> sortedKey = new ArrayList<>(store.keySet());
        Collections.sort(sortedKey);
        
        for (int i = 0; i < sortedKey.size(); i++)
            answer[i] = calculate(fees, store.get(sortedKey.get(i)));
        
        return answer;
    }
    
    public int calculate(int[] fees, int t) {
        if (t <= fees[0])
            return fees[1];
        return fees[1] + (int) Math.ceil((double)(t - fees[0]) / fees[2]) * fees[3];
    }
    
    public int calculateMin(String start, String end) {
        int s_hour = Integer.parseInt(start.substring(0, 2)), s_min = Integer.parseInt(start.substring(3, 5));
        int e_hour = Integer.parseInt(end.substring(0, 2)), e_min = Integer.parseInt(end.substring(3, 5));
        
        if (e_min < s_min){
            e_hour -= 1;
            e_min += 60;
        }
        
        return (e_hour - s_hour) * 60 + e_min - s_min;  
    }
}