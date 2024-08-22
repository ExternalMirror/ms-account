package az.edu.orient.service;

import az.edu.orient.dto.AccountDto;
import az.edu.orient.entity.AccountEntity;
import az.edu.orient.handler.AccountNotFoundException;
import az.edu.orient.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    //we create fake repository so that it doesn't connect real database because we will put value ourselves
    //this is before adding extendWith, Mock and InjectMock annotations
    //AccountRepository accountRepository = Mockito.mock(AccountRepository.class);
    //AccountService accountService = new AccountService(accountRepository);
    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    AccountService accountService;
    //we use void, result isn't used, test methods are all void
    @Test
    void updateAccountGivenValidIdThenReturnUpdatedAccountDto(){
        //setup
        //whatever comes return updated account entity
        Long id = 1L;
        AccountDto request = new AccountDto();
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName("Mock");
        Mockito.when(accountRepository.findById(id)).thenReturn(Optional.of(accountEntity));
        Mockito.when(accountRepository.save(accountEntity)).thenReturn(accountEntity);
        //when
        //account service will call updateAccount, and account service did take accountRepository
        //and accountRepository did take from fake AccountRepository
        AccountDto result = accountService.updateAccount(id, request);
        //expect (then)
        assertNotNull(result); //after this we need also check if result is saved
        //accountRepository -  mocked object, times how may time called and save(accountEntity)- which method with which parameter
        Mockito.verify(accountRepository, Mockito.times(1)).save(accountEntity);
    }
    @Test
    void updateAccountGivenNotValidIdThenThrowUpdatedAccountNotFoundException(){
        //setup
        Long id = 1L;
        Mockito.when(accountRepository.findById(id)).thenReturn(Optional.empty());
        //when
        AccountNotFoundException result = assertThrows(AccountNotFoundException.class, ()->accountService.updateAccount(id, new AccountDto()));
        //expect(then)
        assertNotNull(result);
        assertEquals("Account not found: "+id, result.getMessage());
    }
}