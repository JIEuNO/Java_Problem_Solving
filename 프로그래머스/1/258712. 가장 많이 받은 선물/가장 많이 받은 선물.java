import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int len = friends.length;
        int[][] status = new int[len][len];
        int[] level = new int[len];
        String[] ab = new String[2];
        int[] recv = new int[len];
        HashMap<String, Integer> idx = new HashMap<String, Integer>();
        
        for (int i = 0; i < len; i++)
            idx.put(friends[i], i);

        for (int i = 0; i < gifts.length; i++) {
            ab = gifts[i].split(" ");
            status[idx.get(ab[0])][idx.get(ab[1])] += 1;
            level[idx.get(ab[0])] += 1;
            level[idx.get(ab[1])] -= 1;
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (i == j)
                    continue;
                if (status[i][j] > status[j][i]) 
                    recv[i] += 1;
                else if (status[i][j] == status[j][i]) {
                    if (level[i] > level[j])
                        recv[i] += 1;
                    else if (level[j] > level[i])
                        recv[j] += 1;
                }
                else
                    recv[j] += 1;
             }
        }
        
        for (int i = 0; i < len; i++)
            if (recv[i] > answer)
                answer = recv[i];
        
        return answer;
    }
}