package ir.maktabsharif.util;

import ir.maktabsharif.exception.ValidationException;

public class Rule {

    private Rule(){}


    public static void check(Boolean condition,String message)throws ValidationException{
        if (condition)throw new ValidationException(message);
    }
}
