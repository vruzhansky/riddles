package com.wr.riddles.misc;

/**
 * <a href="http://www.geeksforgeeks.org/segregate-even-and-odd-numbers/">http://www.geeksforgeeks.org/segregate-even-and-odd-numbers</a>
 * <p/>
 * Segregate Even and Odd numbers
 * Given an array A[], write a function that segregates even and odd numbers. The functions should put all even numbers first,
 * and then odd numbers.
 * <p>
 * Example
 * <p>
 * Input  = {12, 34, 45, 9, 8, 90, 3}
 * Output = {12, 34, 8, 90, 45, 9, 3}
 * In the output, order of numbers can be changed, i.e., in the above example 34 can come before 12 and 3 can come before 9.
 * <p>
 * The problem is very similar to our old post Segregate 0s and 1s in an array, and both of these problems are variation of
 * famous Dutch national flag problem.
 * <p>
 * <p>
 * Algorithm: segregateEvenOdd()
 * 1) Initialize two index variables left and right: left = 0,  right = size -1
 * 2) Keep incrementing left index until we see an odd number.
 * 3) Keep decrementing right index until we see an even number.
 * 4) If lef < right then swap arr[left] and arr[right]
 */
class EvenOdd {

    static int[] evensFirst(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] % 2 == 0) {
                if (numbers[j] % 2 == 1) {
                    j--;
                }
                i++;
            } else {
                if (numbers[j] % 2 == 0) {
                    int k = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = k;
                    i++;
                    j--;
                } else {
                    j--;
                }
            }
        }
        return numbers;
    }

    static int[] evensFirst2(int numbers[]) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            while (numbers[i] % 2 == 0 && i < j) {
                i++;
            }
            while (numbers[j] % 2 == 1 && i < j) {
                j--;
            }
            if (i < j) {
                int k = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = k;
                i++;
                j--;
            }
        }
        return numbers;
    }
}
