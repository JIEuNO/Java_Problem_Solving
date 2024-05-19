class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String tmp = "";
        int cnt = 0, attempt = 0, total = 0;
        
        while (!s.equals("1")) {
            cnt = 0;
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == '0')
                    cnt += 1;
            attempt += 1;
            total += cnt;
            
            s = Integer.toBinaryString(s.length() - cnt);
        }
        
        answer[0] = attempt;
        answer[1] = total;
        
        return answer;
    }
}