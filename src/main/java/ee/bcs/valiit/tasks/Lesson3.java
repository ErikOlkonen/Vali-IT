package ee.bcs.valiit.tasks;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Lesson3 {
    public static void main(String[] args) {

        //sum(new int[](1,2,3))
/*
        int x [] = {1,2,3,4,5};
        System.out.println(sum(x));
        System.out.println(Arrays.toString(x));

 */
        //return sum(x);
    }
    public static int sum(int[] x) {
        // Todo liida kokku kõik numbrid massivis x
        /* ...
        int[] x = {10,20,30,40,50,60,70,80,90,100};    //array
        int sum = IntStream.of(x).sum();    //leiame summa
        System.out.println("Massiivi summa " + sum);

         */
        int sum = 0;
        for (int i = 0; i < x.length; i++)
            sum += x[i];  // sum = x[i]++ on ju vale!

        return sum;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 120
        int factorial = 1;
        for (int i = 1; i <= x; i++)
            factorial = factorial * i;

        return factorial;
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi.
        // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
        return new int[0];
    }

    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi
        return "";
    }

    public static boolean isPrime(int x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        return false;
    }
}
