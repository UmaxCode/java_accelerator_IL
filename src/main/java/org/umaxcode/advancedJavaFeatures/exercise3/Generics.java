package org.umaxcode.advancedJavaFeatures.exercise3;

public class Generics {

    public static <T> boolean validate(T data) {

        if (data instanceof Number) {
            Number number = (Number) data;
            return validateNumber(number);
        } else if (data instanceof String) {
            String str = (String) data;
            return validateString(str);
        }

        // For other types, return false as we don't have validation criteria
        return false;
    }

    // Validation for Numbers: Check if the number is positive
    private static boolean validateNumber(Number number) {
        return number.doubleValue() > 0;
    }

    // Validation for Strings: Check if the string is not empty
    private static boolean validateString(String str) {
        return str != null && !str.isEmpty();
    }


    public static void main(String[] args) {

        // Testing with different data types

        // Test with a valid positive number
        System.out.println(validate(123));  // true

        // Test with a valid negative number
        System.out.println(validate(-1));   // false

        // Test with a valid non-empty string
        System.out.println(validate("Hello"));  // true

        // Test with an empty string
        System.out.println(validate(""));      // false

        // Test with an invalid type (e.g., a custom object)
        System.out.println(validate(new Object())); // false
    }
}
