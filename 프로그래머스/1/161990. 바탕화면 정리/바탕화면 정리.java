class Solution {
    public int[] solution(String[] wallpaper) {
        
        int[] answer = new int[4];
        int x_min = Integer.MAX_VALUE, x_max = Integer.MIN_VALUE;
        int y_min = Integer.MAX_VALUE, y_max = Integer.MIN_VALUE;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    x_min = (i < x_min) ? i : x_min;
                    x_max = (i + 1 > x_max) ? i + 1 : x_max;
                    y_min = (j < y_min) ? j : y_min;
                    y_max = (j + 1 > y_max) ? j + 1: y_max;
                }
            }
        }
        
        answer[0] = x_min;
        answer[1] = y_min;
        answer[2] = x_max;
        answer[3] = y_max;
        
        return answer;
    }
}