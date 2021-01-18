package ee.bcs.valiit.tasks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Lesson2 {

    public static void main(String[] args) {


        exercise1(); // ei tagasta
        exercise2(5); // ei tagasta
        exercise3(3, 3); // ei tagasta
        exercise4(6); // tagastab v22rtuse aga seda ei kasutata
        System.out.println(exercise4(0));
        System.out.println(exercise4(1));
        System.out.println(exercise4(2));
        System.out.println(exercise4(3));
        System.out.println(exercise4(4));
        System.out.println(exercise4(5));
        System.out.println(exercise4(6));
        System.out.println(exercise4(7));
        System.out.println(exercise4(8));
        System.out.println(exercise4(9));

        System.out.println(exercise5(1, 10));
        seqLenght(2);
        // TODO siia saab kirjutada koodi testimiseks
    }

    // TODO loo 10 elemendile täisarvude massiv
    // TODO loe sisse konsoolist 10 täisarvu
    // TODO trüki arvud välja vastupidises järiekorras

    public static void exercise1() {
        String[] a = new String[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.next();
            scanner.nextLine();
        }
        for (int i = a.length - 1; i != 0; i--) {
            System.out.println(a[i]);
        }
    }


    // TODO prindi välja x esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10

    public static void exercise2(int x) {
        /* int paarisarv = 2;
        while (paarisarv <= x * 2) {
            System.out.println(paarisarv);
            paarisarv += 2;
        }
         */
        for (int i = 1; i <= x; i++) {
            System.out.println(i * 2);
        }

    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    //kuidas teha korrutustabel
    public static void exercise3(int x, int y) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element
    public static int exercise4(int n) {
        /* See on vana
        int a = 0;
        int b = 1;
         */
        int previousFib = 0;
        int fib = 1;
        for (int i = 0; i <= n; i++) {
            int nextFib = previousFib + fib;
            previousFib = fib;
            fib = nextFib;

            System.out.println(fib + " ");
        }
        return fib;

        /*  See on vana mis tootas
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            for (int i = 1; i < n; i++) {
                int tmp = a;
                a = b;
                b = b + tmp;
            }
            return b;

    }
        */
    }

    // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
// TODO 1 (tee alamfunktsioon) mis leiab 3n+1 sequenci pikkuse
// kui on paaris / 2 kui on paaritu *3+1
// TODO 2 tee tsükkel mis leiab i -> j kõige suurema tsükkli pikkuse
//
    public static String exercise5(int x, int y) {
        int maxLenght = 0; //tsykkli pikkus alguses, 1,10,20 ??
        for (int i = x; i <= y; i++) {
            int seqLenght = seqLenght(i);
            if (seqLenght > maxLenght) {
                maxLenght = seqLenght; // k]ige pikem jada pikkus?
            }
        }
        return x + " " + y + " " + maxLenght;

    }

    public static int seqLenght(int n) { //alamfunktsioon, mis peaks leidma jada pikkuse
        int count = 1; //jada algab, sisend 1
        while (n > 1) { //kui on t6ene...
            count++; // ..siis liida 1 juurde
            if (n % 2 == 0) { //jagatud kahega et saada
                n = n / 2; //kui tykkel on paarisarv
            } else {
                n = n * 3 + 1; //kui tsykkel on paaritu arv
            }
        }
        return count;

    }
}




