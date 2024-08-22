package az.edu.orient.validation;

import az.edu.orient.dto.AccountDto;
import az.edu.orient.entity.AccountEntity;
import az.edu.orient.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountValidator implements Validator {

    private final AccountRepository accountRepository;
    // what class for we write this, support if it is account type, like if it is account, validate will work if not then not
    //isAssignableFrom checks if type of AccountDto is same as given type, it supports AccountDto types, equals can't
    @Override
    public boolean supports(Class<?> clazz) {
        return AccountDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //these are account we get
        AccountDto accountDto = (AccountDto) target;
        Optional<AccountEntity> accountDtoInDB = accountRepository.findAllByUserIdAndCurrency(accountDto.getUserId(), accountDto.getCurrency());
        if(accountDtoInDB.isPresent()){
            errors.rejectValue("currency", "","User already have account in this currency");
        }
    }
}