import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int k;
    public static Belt[] belt;
    public static int cnt = 0;

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        belt = new Belt[(n << 1)];
        for (int i = 0; i < (n << 1); i++)
            belt[i] = new Belt(false, sc.nextInt());

        // logic
        while (checkEmpty() < k) {
            rotateBelt();
            rotateRobot();
            addRobot();
            cnt += 1;
        }

        // output
        System.out.println(cnt);
    }

    public static void rotateBelt() {
        Belt last = belt[(n << 1) - 1];
        for (int i = (n << 1) - 2; i >= 0; i--)
            belt[i + 1] = belt[i];
        belt[0] = last;
    }

    public static void rotateRobot() {
        belt[n - 1].isRobot = false; // move down

        for (int i = n - 2; i >= 0; i--) {
            if (!belt[i].isRobot)
                continue;
            if (!belt[i + 1].isRobot && belt[i + 1].durability > 0) {
                belt[i].isRobot = false;
                if (i + 1 != n - 1) // move down
                    belt[i + 1].isRobot = true;
                belt[i + 1].durability -= 1;
            }
        }
    }

    public static void addRobot() {
        if (!belt[0].isRobot && belt[0].durability > 0) {
            belt[0].isRobot = true;
            belt[0].durability -= 1;
        }
    }

    public static int checkEmpty() {
        int cnt = 0;
        for (int i = 0; i < (n << 1); i++)
            if (belt[i].durability == 0)
                cnt += 1;
        return cnt;
    }
}

class Belt {
    boolean isRobot;
    int durability;

    public Belt(boolean isRobot, int durability) {
        this.isRobot = isRobot;
        this.durability = durability;
    }
}