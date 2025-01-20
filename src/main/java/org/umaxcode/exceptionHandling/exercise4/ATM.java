package org.umaxcode.exceptionHandling.exercise4;

import java.math.BigDecimal;

public class ATM {

    private final BigDecimal amountTORedraw;
    private final BigDecimal USER_AMOUNT = BigDecimal.valueOf(1000.0);

    public ATM(BigDecimal amount) {
        this.amountTORedraw = amount;
    }

    public static void main(String[] args) {

        ATM atm = new ATM(BigDecimal.valueOf(1000000.0));
        try {
            atm.redraw();
        } catch (InsufficientFundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void redraw() {

        if (USER_AMOUNT.compareTo(amountTORedraw) < 0) {
            throw new InsufficientFundException("You don't have enough funds to redraw");
        }

        System.out.println("You have redrawn " + amountTORedraw);
        System.out.println("You have " + USER_AMOUNT.subtract(amountTORedraw) + " left.");
    }

}
