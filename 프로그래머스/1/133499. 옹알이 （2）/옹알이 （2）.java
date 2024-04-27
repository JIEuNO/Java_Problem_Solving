class Solution {
    public int solution(String[] babbling) {
        int answer = 0, idx, len;
        boolean isPossible;
        Character prev;
        
        for (int i = 0; i < babbling.length; i++) {
            idx = 0;
            len = babbling[i].length();
            isPossible = true;
            prev = null;
            
            while (idx < len && isPossible) {
                switch (babbling[i].charAt(idx)) {
                    case 'a':
                        if (canBeSpoken(babbling[i], "aya", idx, prev))
                            idx += 2;
                        else
                            isPossible = false;
                        prev = 'a';
                        break;
                    case 'y':
                        if (canBeSpoken(babbling[i], "ye", idx, prev))
                            idx += 1;
                        else
                            isPossible = false;
                        prev = 'y';
                        break;
                    case 'w':
                        if (canBeSpoken(babbling[i], "woo", idx, prev))
                            idx += 2;
                        else
                            isPossible = false;
                        prev = 'w';
                        break;
                    case 'm':
                        if (canBeSpoken(babbling[i], "ma", idx, prev)) 
                            idx += 1;
                        else
                            isPossible = false;
                        prev = 'm';
                        break;
                    default:
                        isPossible = false;
                        break;
                }
                idx += 1;
            }
            
            if (isPossible)
                answer += 1;
        }
        
        return answer;
    }
    
    public static boolean canBeSpoken(String bab, String pos, int idx, Character prev) {
        return idx + pos.length() <= bab.length()
            && bab.substring(idx, idx + pos.length()).equals(pos)
            && (prev == null || prev != pos.charAt(0));
    }
}