import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> solution(String[] record) {
        int len = record.length;
        String[] str;
        List<String> answer = new ArrayList<>();
        Map<String, String> name = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            str = record[i].split(" ");
            if (!str[0].equals("Leave")) 
                name.put(str[1], str[2]);
        }
        
        for (int i = 0; i < len; i++) {
            str = record[i].split(" ");
            if (str[0].equals("Enter"))
                answer.add(name.get(str[1]) + "님이 들어왔습니다.");
            else if (str[0].equals("Leave"))
                answer.add(name.get(str[1]) + "님이 나갔습니다.");
        }
        
        return answer;
    }
}