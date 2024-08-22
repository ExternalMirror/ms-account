package az.edu.orient.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidAccountNameValidator implements ConstraintValidator<ValidAccountName, String> {
    private boolean required;

    //this custom validation checks if name's validation
    @Override
    //inside we can get and take
    public void initialize(ValidAccountName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        required = constraintAnnotation.required();
    }

    @Override
    //if valid or not
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.matches("\\d+")) {
            return false;
        }
        if (!value.matches("[a-zA-Z]*")) {
            return false;
        }
        if (value.length() < 4 || value.length() > 20) {
            return false;
        }
        return true;
    }
}
//if (value == null && required) {
//        context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate("Account name is required").addConstraintViolation();
//            return false;
//                    }
//                    //check number
//                    if (value != null) {
//        if (value.matches("\\d*")) {
//        context.disableDefaultConstraintViolation();
//                context.buildConstraintViolationWithTemplate("Account name should not contain only numbers").addConstraintViolation();
//                return false;
//                        }
//                        //check letter
//                        if (value.matches("[a-zA-Z]*")) {
//        context.disableDefaultConstraintViolation();
//                context.buildConstraintViolationWithTemplate("Account name should include both letters and numbers").addConstraintViolation();
//                return false;
//                        }
//                        //check length
//                        if (value.length() <= 4 || value.length() >= 20) {
//        context.disableDefaultConstraintViolation();
//                context.buildConstraintViolationWithTemplate("Account name length should be between 4 and 20 characters").addConstraintViolation();
//                return false;
//                        }
//                        }
//                        return true;