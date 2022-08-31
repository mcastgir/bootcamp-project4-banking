package com.nttdata.bootcamp.banking.util;

public class StringUtil {

    public static String toString(Object object) {
        try {
            if (object != null) {
                return String.valueOf(object);
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }

}
