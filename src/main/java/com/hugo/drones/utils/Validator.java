package com.hugo.drones.utils;

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
}
