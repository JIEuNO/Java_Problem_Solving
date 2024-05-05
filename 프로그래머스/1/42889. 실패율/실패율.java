import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int len = stages.length, s = 0, e = 0, cur, cnt = 0;
        Info[] infos = new Info[N];
        
        Arrays.sort(stages);
        cur = 1;
        for (int i = 0; i < N; i++)
            infos[i] = new Info(i + 1, 0);
        
        while (e < len) {
            if (stages[e] > cur) {
                infos[cur - 1].val = (double)(e - s) / (double)(len - s);
                s = e;
                cur += 1;
            }
            else {
                e += 1;
                if (e == len && cur <= N) {
                    infos[cur - 1].val = (double)(e - s) / (double)(len - s);
                }
            }
        }
        
        Collections.sort(Arrays.asList(infos));

        for (Info info : infos) {
            answer[cnt] = info.key;
            cnt += 1;
        }
        
        return answer;
    }
}
class Info implements Comparable<Info> {
    int key;
    double val;
    
    Info(int key, double val) {
        this.key = key;
        this.val = val;
    }
    
    @Override
	public int compareTo(Info info) {
        if (this.val == info.val)
            return 0;
        else if (this.val > info.val)
            return -1;
        else
            return 1;
    }
}