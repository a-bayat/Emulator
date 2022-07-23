package ir.shaparak.emulator.service.validator;

import org.springframework.stereotype.Component;

@Component
public class PostalValidator implements IValidator {
    @Override
    public Boolean validate(String input) {
        return CustomValidator.check(String::isEmpty, input) ||
                CustomValidator.check(CustomValidator::isNumber, input) ||
                CustomValidator.check(s -> s.length() == 10, input);
    }
}
