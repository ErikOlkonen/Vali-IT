package ee.bcs.valiit.tasks;

public class Lesson1MathUtil {
    private String test;

    // TODO kirjuta ise (if/else) ära kasuta java.lang.Math
    public Lesson1MathUtil(String test) {
        this.test = test;
    }

    public static void main(String[] args) {
    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        System.out.println(min(3, 5));
        System.out.println(min(-1, -9));
        return 0;
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a >= 0) {
            return -a;
        } else {
            return a;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        } else {
        }
        return false;
    }


    // TODO tagasta kolmest arvust kõige väiksem
    public static int min(int a, int b, int c) {
        if (a <= b && b <= c) {
            return a;
        } else if (a >= b && b >= c) {
            return b;
        } else {
            return c;
        }

    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max(int a, int b, int c) {
        int max = max(a, b);
        return max(max, c);
    }

}
