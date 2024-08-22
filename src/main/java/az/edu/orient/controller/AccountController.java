package az.edu.orient.controller;

import az.edu.orient.dto.AccountDto;
import az.edu.orient.service.AccountService;
import az.edu.orient.validation.AccountValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    private final AccountValidator accountValidator;
    //this is plus custom annotation that is why we use add not setValidator because it can replace our custom validator
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        //use support if it supports type if not don't validate
        if (binder.getTarget() != null && accountValidator.supports(binder.getTarget().getClass())) {
            binder.addValidators(accountValidator);
        }
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDto createAccount(@RequestBody @Valid AccountDto request){
        return accountService.createAccount(request);
    }
    @GetMapping
    public List<AccountDto> getAllAccountList(){
        return accountService.getAllAccountList() ;
    }
    @GetMapping(path = "{id}")
    public AccountDto getAccountById(@PathVariable Long id){
        return null;
    }
    @DeleteMapping(path = "{id}")
    public void deleteAccountById(@PathVariable Long id){
    }
    @PutMapping(path ="{id}")
    public AccountDto updateAccount(@PathVariable Long id,@RequestBody AccountDto request){
        return accountService.updateAccount(id, request);
    }
    @PatchMapping(path = "{id}/status")
    public AccountDto updateAccountStatus(@PathVariable Long id,@RequestBody AccountDto request){
        return  null;
    }
}
