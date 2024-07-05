import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] topping) {
        int answer = 0, len = topping.length;
        int[] l = new int[len], r = new int[len];
        Set<Integer> ls = new HashSet<>(), rs = new HashSet<>();
        
        l[0] = 1;
        ls.add(topping[0]);
        r[len - 1] = 1;
        rs.add(topping[len - 1]);
        
        for (int i = 1; i < len; i++) {
            if (!ls.contains(topping[i])) {
                ls.add(topping[i]);
                l[i] = l[i - 1] + 1;
            }
            else 
                l[i] = l[i - 1];
            
            if (!rs.contains(topping[len - 1 - i])) {
                rs.add(topping[len - 1 - i]);
                r[len - 1 - i] = r[len - i] + 1;
            }
            else
                r[len - 1 - i] = r[len - i]; 
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (l[i] == r[i + 1])
                answer += 1;
        }
        
        return answer;
    }
}