import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0, left = 0, right = people.length - 1;
        Arrays.sort(people);
        
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left += 1;
                right -= 1;
                answer += 1;
            }
            else {
                right -= 1;
                answer += 1;
            }
        }
        
        return answer;
    }
}