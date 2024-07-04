import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();
        int len = msg.length(), start = 0, end, cnt = 26;
        String str;
        
        for (int i = 1; i <= cnt; i++)
            dic.put(Character.toString(i + 64), i);
        
        while (start < len) {
            for (end = len; end > start; end--) {
                str = msg.substring(start, end);
                if (dic.containsKey(str)) {
                    answer.add(dic.get(str));
                    if (end + 1 <= len) {
                        dic.put(msg.substring(start, end + 1), ++cnt);
                    }
                    break;
                }
            }
            start = end;
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}