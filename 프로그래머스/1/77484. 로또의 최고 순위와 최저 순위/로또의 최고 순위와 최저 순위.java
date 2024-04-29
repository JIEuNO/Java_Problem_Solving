class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt = 0, winCnt = 0;
        
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0)
                zeroCnt += 1;
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    winCnt += 1;
                }
            }
        }
        
        answer[0] = countRank(winCnt + zeroCnt);
        answer[1] = countRank(winCnt);
        
        return answer;
    }
    
    public static int countRank(int cnt) {
        if (cnt >= 2)
            return 7 - cnt;
        else
            return 6;
    }
}