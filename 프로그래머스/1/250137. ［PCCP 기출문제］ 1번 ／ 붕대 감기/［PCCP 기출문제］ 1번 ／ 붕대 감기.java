class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int last = 0, duration;
        for (int i = 0; i < attacks.length; i++) {
            duration = attacks[i][0] - last - 1;
            answer = addHealth(health, answer, duration * bandage[1] + bandage[2] * (int)(duration / bandage[0]));
            answer -= attacks[i][1];
            last = attacks[i][0];
            
            if (answer <= 0) {
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
    
    public static int addHealth(int max, int now, int plus) {
        return (now + plus >= max) ? max : (now + plus);
    }
}