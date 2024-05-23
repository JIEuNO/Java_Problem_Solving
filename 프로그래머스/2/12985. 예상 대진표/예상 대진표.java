class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int gpA = (a - 1) / 2, gpB = (b - 1) / 2;
        
        while (gpA != gpB) {
            gpA /= 2;
            gpB /= 2;
            answer += 1;
        }

        return answer;
    }
}