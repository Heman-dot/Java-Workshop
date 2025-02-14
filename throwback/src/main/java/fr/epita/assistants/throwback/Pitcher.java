package fr.epita.assistants.throwback;


import java.math.BigInteger;

public class Pitcher {
    public static void throwException(String message) throws PositiveIntegerException, NegativeIntegerException,
            ShortStringException, LongStringException, UnknownException {
        if (message.matches("^-?\\d+$")) { // Check if it's an integer
            BigInteger num = new BigInteger(message);
            if (num.signum() >= 0) {
                throw new PositiveIntegerException(message);
            } else {
                throw new NegativeIntegerException(message);
            }
        } else if (message.matches("^[a-zA-Z ,.']+$")) { // Check if it's a valid sentence
            if (message.length() >= 100) {
                throw new LongStringException(message);
            } else {
                throw new ShortStringException(message);
            }
        } else { // Any other case
            throw new UnknownException(message);
        }
    }
}