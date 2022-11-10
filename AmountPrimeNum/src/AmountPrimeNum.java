import java.util.Scanner;
import java.math.*;

public class AmountPrimeNum {

    public static boolean isPrime(int num) {

        int sqrt = (int) Math.sqrt(num) + 1;
        for( int i = 2; i < sqrt; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }

           //speed up
    public static int amountPrimeEr(int num) {

        int amount = 0;
        boolean[] array = new boolean[num];

        for(int i = 2; i < num; i++)
            array[i] = true;

        for(int i = 2; i*i < num; i++) {

            if(isPrime(i)) {
                for (int j = i * i; j < num; j = j + i) {
                    if (array[j])
                        array[j] = false;
                }
            }
            if(i >= num)
                break;
        }

        for(int i = 0; i < num; i++)
            if(array[i])
                amount++;

        return amount;
    }


    public static int amountPrime(int num) {

        int amount = 1;

        for(int i = 3; i < num; i = i + 2)
            if(isPrime(i))
                amount++;

        return amount;
    }



    public static void main(String[] args) {

        int amount = 0;
        long startTime = System.nanoTime();

        int num = 1000000;

        if(isPrime(num))
            System.out.println(num + " is prime");
        else
            System.out.println(num + " is not prime");

        amount = amountPrime(num);
        System.out.println(amount + " - amount of prime numbers before the number " + num);

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println((double)elapsedTime/1000000000 + " seconds");

    }
}




