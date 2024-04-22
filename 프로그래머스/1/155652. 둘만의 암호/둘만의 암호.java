class Solution {
    
    public static int start = 97, end = 122; // a: 97, z: 122
    
    public String solution(String s, String skip, int index) {
        String answer = "";
        int cnt, now;
        boolean[] isSkip = new boolean[end - start + 2];
        
        for (int i = 0; i < skip.length(); i++)
            isSkip[skip.charAt(i) - start] = true;
        
        for (int i = 0; i < s.length(); i++) {
            cnt = 0;
            now = s.charAt(i);
            while (cnt < index) {
                now = (now + 1) > end ? start : now + 1;
                if (!isSkip[now - start])
                    cnt += 1;
            }
            answer += (char)(now);
        }
        
        return answer;
    }
}