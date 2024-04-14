import java.util.Map;
import java.util.HashMap;

class Solution {
    public static Map<String, Integer> idx = new HashMap<String, Integer>();
    public static String[] answer;
    
    public String[] solution(String[] players, String[] callings) {
        answer = new String[players.length];
        int p_idx;
        
        for (int i = 0; i < players.length; i++) {
            idx.put(players[i], i);
            answer[i] = players[i];
        }

        for (int i = 0; i < callings.length; i++) {
            p_idx = idx.get(callings[i]);
            idx_swap(answer[p_idx - 1], callings[i]);
            p_swap(p_idx - 1, p_idx);
        }
        
        return answer;
    }
    
    public static void idx_swap(String start, String end) {
        int tmp = idx.get(start);
        idx.put(start, idx.get(end));
        idx.put(end, tmp);
    }
    
    public static void p_swap(int start, int end) {
        String tmp = answer[start];
        answer[start] = answer[end];
        answer[end] = tmp;
    }
}