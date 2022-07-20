package ir.shaparak.emulator.service.validator;

import java.util.function.Predicate;

public class LengthValidator {
    public Boolean check(Predicate<String> in, String input) {
        return in.test(input);
    }
}
