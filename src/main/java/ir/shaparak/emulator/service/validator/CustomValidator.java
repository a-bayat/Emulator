package ir.shaparak.emulator.service.validator;

import java.util.function.Predicate;

public class CustomValidator {
    public static Boolean check(Predicate<String> in, String input) {
        return in.test(input);
    }

    public static Boolean isNumber(String s) {
        if (s == null)
            return false;

        try {
            double d = Double.parseDouble(s);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
