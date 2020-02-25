package com.slotvinskiy;

//Число Фибоначчи. Написать метод который возвращает N-е число Фибоначчи.

import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("Please enter positive number!");
            n = scanner.nextInt();
        } while (n < 0);
        if (n < 92) {
            System.out.println(printFibonacci(n));
        } else {
            System.out.println(printBigFibonacci(n));
        }
    }

    private static long printFibonacci(int n) {

        if (n >= 0 && n < 2) {
            return n;
        }
        if (n > 92) {
            System.out.println("Warning!!! Data type long overload!");
            return -1;
        } else {
            long sum = 1;
            long previousSum = 0;
            long temp;
            for (int i = 2; i <= n; i++) {
                temp = sum;
                sum = previousSum + sum;
                previousSum = temp;
            }
            return sum;
        }
    }

    private static BigInteger printBigFibonacci(int n) {
        if (n >= 0 && n < 2) {
            return new BigInteger(String.valueOf(n));
        }
        BigInteger sum = new BigInteger("1");
        BigInteger previousSum = new BigInteger("0");
        BigInteger temp;
        for (int i = 2; i < n; i++) {
            temp = sum;
            sum = sum.add(previousSum);
            previousSum = temp;
        }
        return sum;
    }
}
