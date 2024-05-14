import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new stComparator(n));
        
        return strings;
    }
}

class stComparator implements Comparator<String> {
    int n;
    
    stComparator(int n) {
        this.n = n;
    }
    
    @Override
    public int compare(String s1, String s2) {
        int cmp = Character.compare(s1.charAt(n), s2.charAt(n));
        
        if (cmp == 0) {
            return s1.compareTo(s2);
        }
        
        return cmp;
    }
    
}