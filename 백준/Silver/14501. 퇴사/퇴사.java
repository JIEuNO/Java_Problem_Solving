import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        int sum = 0;
        int bitIdx = 0;
        int next = -1;
        int max = 0;
        boolean isValid = true;

        // logic
        for (int i = 0; i < (1 << n); i++) {
            sum = 0;
            next = -1;
            isValid = true;
            for (int j = 0; j < n; j++) { // bit check
                bitIdx = n - j - 1;
                if ((i & (1 << bitIdx)) != 0) { // bit up
                    if (j > next) {
                        sum += p[j];
                        next = j + (t[j] - 1);
                        if (next >= n) {
                            isValid = false;
                            break;
                        }
                    }
                    else {
                        isValid = false;
                        break;
                    }
                }
            }
            if (isValid && (sum > max))
                max = sum;
        }

        // output
        System.out.println(max);
    }

}