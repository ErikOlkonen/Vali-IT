package ee.bcs.valiit.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

        /* TODO tagasta string tagurpidi
        System.out.println("Sisesta string");
        Scanner in = new Scanner(System.in); // scanner on see mis loeb asju sisse
        String string = in.nextLine();
        System.out.println("Sisestatud string :" + string);
        char temp;
        char[] array = string.toCharArray(); //tagastab
        int length = array.length;
        for(int i = 0; i < string.length()/2; i++,length--){
            temp = array[i]; //See on ymber vahetamise osa, sarnane nagu sordi ylesande puhul
            array[i] = array[length-1];
            array[length-1] = temp;
        }

        System.out.println("Tagurpidi string :" + String.valueOf(array));

         */

/*
        Scanner scan = new Scanner(System.in);
        System.out.print("Sisesta number : ");
        int num = 0;
        num = scan.nextInt();
        int i = 0;
        for(i = 2; i < num; i++)
        {
            if(num % i == 0)
            {
                int count = 0;
                count++;
                break;
            }
        }
        int count = 0;
        if(count == 0)
        {
            System.out.print("Algarv");
        }
        else
        {
            System.out.print("Ei ole algarv");
        }

 */


        // TODO tagasta x faktoriaal.
        // int x [] = {1,2,3,4,5};
        // System.out.println(sum(x));


        //  Todo liida kokku kõik numbrid massivis x
        // int x [] = {1,2,3,4,5};
        // System.out.println(sum(x));
        // System.out.println(Arrays.toString(x)); // massiivi muutmine stringiks


        // return sum(x);
        //int number[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        // System.out.print(Arrays.toString(sort(new int[]{5, -6, 9, 12, 7})));

        // System.out.println(Arrays.toString(sort(int[] array)));

        // int kontroll[]= {1,2,3,4,5};
        // System.out.println(kontroll[3]);

        // System.out.println("Sisesta string");

    }

    public static int sum(int[] x) {
        int sum = 0;
        for (int i : x) {
            sum += i;
        }
        return sum;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 120
        // 5*5=25 4*4=16 3*3= 9 2*2=4 1*1=1
        int factorial = 1;
        for (int i = 1; i <= x; i++)
            factorial = factorial * i;

        return factorial;
    }

    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    // TODO SELECTION SORT
    public static int[] sort(int[] a) {
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length - 1 - j; i++) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                }
            }
        }
        return a;
    }



    /*public static void swap(int[] array, int vasak, int parem) {
        int temporary = array[vasak];
        array[vasak] = array[parem];
        array[parem] = array[vasak];


    }

     */

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)


    public static boolean isPrime(int n) {
        boolean result = true;
        for (int x = 2; x < n; x++) {
            if ((n % x) == 0) {
                result = false;
                break;
            }
        }
        return result;
    }


}