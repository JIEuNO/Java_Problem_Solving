import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[answers.length];
        int max = Integer.MIN_VALUE, maxIdx = 0, cnt = 0;
        Question[] q = new Question[3];
        q[0] = new Question(new int[] {1, 2, 3, 4, 5});
        q[1] = new Question(new int[] {2, 1, 2, 3, 2, 4, 2, 5});
        q[2] = new Question(new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5});
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < q.length; j++) {
                if (answers[i] == q[j].ans[q[j].idx]) {
                    q[j].sc += 1;
                }
                q[j].idx = (q[j].idx + 1) % (q[j].ans.length);
            }
        }
        
        for (int i = 0; i < q.length; i++) {
            if (q[i].sc > max) {
                max = q[i].sc;
                cnt = 0;
                answer[cnt] = i + 1;
            }
            else if (q[i].sc == max) {
                cnt += 1;
                answer[cnt] = i + 1;
            }
        }
        
        answer = Arrays.copyOfRange(answer, 0, cnt + 1);
        Arrays.sort(answer);
        
        return answer;
    }
}

class Question {
    int[] ans;
    int idx, sc;
    
    Question(int[] ans) {
        this.ans = ans;
        this.idx = 0;
        this.sc = 0;
    }
}