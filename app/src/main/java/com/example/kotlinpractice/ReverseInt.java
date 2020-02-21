package com.example.kotlinpractice;

public class ReverseInt {

    public static void main(String[] args) {

        long out = 0;
        int x = 123;
        int value = reverseInteger(x, out);
        System.out.println(value);
    }

    private static int reverseInteger(int x, long out) {
        while (x != 0) {
            out = out * 10 + x % 10;
            x = x / 10;
        }
        if (out > Integer.MAX_VALUE || out < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) out;
    }
}
