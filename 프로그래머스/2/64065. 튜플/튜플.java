import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        int[] answer;
        Map<String, Integer> map = new HashMap<>();
        String c;
        
        s = s.replace("{", "");
        s = s.replace("}", "");
        String[] s2 = s.split(",");
        
        for (int i = 0; i < s2.length; i++) {
            if (map.containsKey(s2[i]))
                map.put(s2[i], map.get(s2[i]) + 1);
            else
                map.put(s2[i], 1);
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        answer = new int[map.size()];
        for (int i = 0; i < map.size(); i++)
            answer[i] = Integer.parseInt(list.get(i));
        
        return answer;
    }
}