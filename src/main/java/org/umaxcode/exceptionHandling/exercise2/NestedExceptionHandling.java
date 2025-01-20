package org.umaxcode.exceptionHandling.exercise2;

import java.security.SecureRandom;

public class NestedExceptionHandling {

    public static void main(String[] args) {

        final int MAGIC_NUMBER = 42;

        int[] array = {0, 1, 2, 3, 4};
        SecureRandom random = new SecureRandom();
        int randomInt = random.nextInt(0, 6);


        try {
            int selectedInt = array[randomInt];

            try {
                int quotient = MAGIC_NUMBER / selectedInt;

                System.out.printf("The division of the magic number %d by the selected integer %d = %d",
                        MAGIC_NUMBER, selectedInt, quotient);
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException with division by zero");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException with index = " + randomInt);
        }


    }
}
