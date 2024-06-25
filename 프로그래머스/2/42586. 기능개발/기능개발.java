import java.util.List;
import java.util.ArrayList;

class Solution {
    
    int max = 100;
    
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length, dep, prev, cnt;
        List<Integer> answer = new ArrayList<>();
        int[] deploy = new int[len];
        
        prev = countDeploy(progresses[0], speeds[0]);
        cnt = 1;
        for (int i = 1; i < len; i++) {
            dep = countDeploy(progresses[i], speeds[i]);
            if (dep > prev) {
                answer.add(cnt);
                prev = dep;
                cnt = 1;
            }
            else {
                cnt += 1;
            }
        }
        
        answer.add(cnt);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public int countDeploy(int progress, int speed) {
        return (int)Math.ceil((double)(max - progress) / speed);
    }
}