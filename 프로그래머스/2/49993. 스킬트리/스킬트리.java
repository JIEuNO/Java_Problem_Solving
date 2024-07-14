import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0, idx;
        char c;
        boolean isPos;
        Map<Character, Integer> s = new HashMap<>();
        
        for (int i = 0; i < skill.length(); i++)
            s.put(skill.charAt(i), i);
        
        for (int i = 0; i < skill_trees.length; i++) {
            idx = 0;
            isPos = true;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                c = skill_trees[i].charAt(j);
                if (s.containsKey(c)) {
                    if (idx == s.get(c))
                        idx += 1;
                    else
                        isPos = false;
                }
            }
            
            if (isPos)
                answer += 1;
        }
        
        return answer;
    }
}