package com.hugo.drones.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hugo
 */
public class Validator {

    /**
     * Check if the object is null or not
     *
     * @param <T> Object type
     * @param obj Object to verify
     */
    public static <T> void notNull(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Check if the lenght of the string is less than len
     *
     * @param str String to check
     * @param len Maximum string lenght
     */
    public static void checkLenght(String str, int len) {
        if (str.length() > len) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Check the string for forbiden characters
     *
     * @param str String to check.
     */
    public static void validMedicationName(String str) {
        for (int i = 0; i < str.length(); i++) {
            char elem = str.charAt(i);
            if (!(elem >= 48 && elem <= 57 || elem >= 65 && elem <= 90 || elem >= 97 && elem <= 122 || elem == 95 || elem == 45)) {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * Check the string for forbiden characters
     *
     * @param str String to check.
     */
    public static void validCode(String str) {
        for (int i = 0; i < str.length(); i++) {
            char elem = str.charAt(i);
            if (!(elem >= 48 && elem <= 57 || elem >= 65 && elem <= 90 || elem == 95)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
