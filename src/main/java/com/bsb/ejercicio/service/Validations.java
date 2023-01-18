package com.bsb.ejercicio.service;

public class Validations {

    public static boolean validationString(String text) {
        return text.matches("^[a-zA-Z]+$");
    }

    public static boolean validateAgeM0(int age) {
        return age > 0;
    }

    public static boolean validateAgem0(int age) {
        return age < 120;
    }

}
