package org.umaxcode.exceptionHandling.exercise1;

/**
 * Demonstrates handling of checked and unchecked exceptions in Java.
 */
public class CheckedAndUnCheckedExceptionDemo {

    /**
     * Method that throws a checked exception.
     * <p>
     * Checked Exception (CheckedException):
     * <ul>
     *     <li>Requires explicit declaration in the method signature using {@code throws}.</li>
     *     <li>Must be handled using a try-catch block or declared to be thrown by the calling method.</li>
     * </ul>
     *
     * @throws CheckedException if an error occurs
     */
    public static void methodThatThrowsCheckedException() throws CheckedException {
        throw new CheckedException("This is a checked exception!");
    }

    /**
     * Method that throws an unchecked exception.
     * <p>
     * Unchecked Exception (UncheckedException):
     * <ul>
     *     <li>Does not require explicit declaration in the method signature.</li>
     *     <li>Can be caught in a try-catch block, but it is not mandatory.</li>
     * </ul>
     *
     * @throws UncheckedException if an error occurs
     */
    public static void methodThatThrowsUncheckedException() {
        throw new UncheckedException("This is an unchecked exception!");
    }

    public static void main(String[] args) {

        // Handling checked exception
        try {
            methodThatThrowsCheckedException();
        } catch (CheckedException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }

        // Handling unchecked exception
        try {
            methodThatThrowsUncheckedException();
        } catch (Exception e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }
    }
}
