package az.edu.orient.validation;

import org.junit.jupiter.api.Test;
import org.springframework.transaction.event.TransactionalEventListener;

import static org.junit.jupiter.api.Assertions.*;

class ValidAccountNameValidatorTest {
    ValidAccountNameValidator validator = new ValidAccountNameValidator();
    //his is for first if that check numbers digits
    @Test
    void isValidGivenOnlyDigitValuesThenReturnFalse() {
        //teacher divided into 3 parts

        //setup ( value needed or depending on other class)
        String value = "12345";
        //when ( ready, when called), null is context that will be what it will say in that condition
        boolean result = validator.isValid(value, null);
        //expect ( after calling method, is value I want or not
        assertFalse(result);
    }
    @Test
    void isValidGivenNotOnlyLetterValuesThenReturnFalse() {
        String value = "123aa**!!%";
        boolean result = validator.isValid(value, null);
        assertFalse(result);
    }
    @Test
    void isValidGivenOnlyLetterValuesThenReturnTrue() {
        String value = "Nurlan";
        boolean result = validator.isValid(value, null);
        assertTrue(result);
    }
    @Test
    void isValidGivenValueLessThanFourThenReturnFalse() {
        String value = "Eli";
        boolean result = validator.isValid(value, null);
        assertFalse(result);
    }
    @Test
    void isValidGivenValueMoreThanTwelveThenReturnFalse() {
        String value = "drtgbdfgrgtdgbrtberbdr";
        boolean result = validator.isValid(value, null);
        assertFalse(result);
    }
}