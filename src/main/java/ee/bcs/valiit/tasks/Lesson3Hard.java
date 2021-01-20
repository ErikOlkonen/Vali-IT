package ee.bcs.valiit.tasks;

public class Lesson3Hard {
    public static int evenFibonacci(int x) {
        int a = 0;
        int b = 1;
        int sum = 0;
        while (b <= x) {
            if (b % 2 == 0) {
                sum += b;
            }
            int tmp = a;
            a = b;
            b = tmp + b;
        }
        return sum;


        // return 0;

        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
        // 0, 1, 1, 2, 3, 5, 8, 13, 21
    }

    public static void randomGame(int a) {
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
        // Scanner scanner = new Scanner(System.in);

        /*

        Random random = new Random();
        String answer = " ";
        int count = 0;
        int randomNumber = random.nextInt(100);
        for (int i = 0; i <= a.length; i++) {
            if (a > randomNumber) {
                answer = "Sinu number oli liiga suur. Arva uuesti!";
                count++;
            } else {
                answer = "Sinu number oli liiga v2ike. Arva uuesti!";
                count++;
            }

        }
        return answer;
    }

         */
    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        return "";
    }
}
