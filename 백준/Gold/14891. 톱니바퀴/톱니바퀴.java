import java.util.Scanner;

public class Main {

    public static int gearNum = 4;
    public static int gearDir = 8;
    public static String gear[] = new String[gearNum];
    public static int rotateDir[] = new int[gearNum];

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < gearNum; i++)
            gear[i] = sc.next();
        int k = sc.nextInt();
        Rotate rotate;
        for (int i = 0; i < k; i++) {
            rotate = new Rotate(sc.nextInt() - 1, sc.nextInt());
            checkGear(rotate);
            rotateGear();
        }

        // output
        System.out.println(calculate());
    }

    public static void checkGear(Rotate rotate) {
        for (int i = 0; i < gearNum; i++)
            rotateDir[i] = 0;
        rotateDir[rotate.idx] = rotate.dir;

        // left side (6 meets 2)
        for (int i = rotate.idx; i > 0; i--) {
            if (gear[i].charAt(6) != gear[i - 1].charAt(2))
                rotateDir[i - 1] = -rotateDir[i];
            else
                break;
        }

        // right side (2 meets 6)
        for (int i = rotate.idx; i < gearNum - 1; i++) {
            if (gear[i].charAt(2) != gear[i + 1].charAt(6))
                rotateDir[i + 1] = -rotateDir[i];
            else
                break;
        }
    }

    public static void rotateGear() {
        for (int i = 0; i < gearNum; i++) {
            if (rotateDir[i] == 1)
                gear[i] = gear[i].charAt(gearDir - 1) + gear[i].substring(0, gearDir - 1);
            else if (rotateDir[i] == -1)
                gear[i] = gear[i].substring(1, gearDir) + gear[i].charAt(0);
        }
    }

    public static int calculate() {
        int sum = 0;

        for (int i = 0; i < gearNum; i++)
            if (gear[i].charAt(0) == '1')
                sum += (1 << i);

        return sum;
    }
}

class Rotate {
    int idx, dir;

    Rotate(int idx, int dir) {
        this.idx = idx;
        this.dir = dir;
    }
}