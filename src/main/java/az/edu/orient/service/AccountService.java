package az.edu.orient.service;

import az.edu.orient.dto.AccountDto;
import az.edu.orient.entity.AccountEntity;
import az.edu.orient.handler.AccountNotFoundException;
import az.edu.orient.mapper.AccountMapper;
import az.edu.orient.repository.AccountRepository;
import az.edu.orient.type.Status;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountDto createAccount(AccountDto accountDto){
        AccountEntity accountEntity = AccountMapper.INSTANCE.toAccountEntity(accountDto);
        accountEntity.setIban(Iban.random(CountryCode.AZ).toString());
        accountEntity.setStatus(Status.ACTIVE);
        AccountEntity saved = accountRepository.save(accountEntity);
        return AccountMapper.INSTANCE.toAccountDto(saved);
    }
    public List<AccountDto> getAllAccountList(){
        return AccountMapper.INSTANCE.toAccountDtoList(accountRepository.findAll());
    }

    public AccountDto updateAccount(Long id, AccountDto request) {
        //test take assertEquals words from here
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(()-> new AccountNotFoundException("Account not found: "+ id));
        AccountMapper.INSTANCE.updateAccount(request, accountEntity);
        AccountEntity updated = accountRepository.save(accountEntity);
        return AccountMapper.INSTANCE.toAccountDto(updated);
    }
}
//this is previous code of createAccount before MapConstruct
//AccountEntity accountEntity = new AccountEntity();
////Request to Entity
//        accountEntity.setName(accountDto.getName());
//        accountEntity.setBalance(accountDto.getBalance());
//        accountEntity.setIban(Iban.random(CountryCode.AZ).toString());
//        accountEntity.setStatus(Status.ACTIVE);
//        accountEntity.setCurrency(accountDto.getCurrency());
//
//AccountEntity saved = accountRepository.save(accountEntity);
////Entity to response, 2 mapper needed
//AccountDto savedAccountDto = new AccountDto();
//        savedAccountDto.setId(saved.getId());
//        savedAccountDto.setName(saved.getName());
//        savedAccountDto.setBalance(saved.getBalance());
//        savedAccountDto.setIban(saved.getIban());
//        savedAccountDto.setStatus(saved.getStatus());
//        savedAccountDto.setCurrency(saved.getCurrency());