class Solution {
    boolean[] isVisited;
    int len, answer = 0, max = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        isVisited = new boolean[len];
        
        perm(dungeons, k, 0);
        
        return answer;
    }
    
    public void perm(int[][] dungeons, int point, int cnt) {
        if (point < 0 || cnt > len)
            return;
        
        if (cnt > answer)
            answer = cnt;
        
        for (int i = 0; i < len; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                if (point >= dungeons[i][0])
                    perm(dungeons, point - dungeons[i][1], cnt + 1);
                isVisited[i] = false;
            }
        }
    }
}