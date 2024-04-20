class Solution {
    public String solution(int[] food) {
        String answer = "";
        String a1 = "", a2 = "";
        for (int i = 1; i < food.length; i++) {
            int res = food[i] / 2;
            for (int j = 0; j < res; j++) {
                a1 += i + "";
                a2 = i + "" + a2;
            }
        }
        answer = a1 + "0" + a2;
        return answer;
    }
}