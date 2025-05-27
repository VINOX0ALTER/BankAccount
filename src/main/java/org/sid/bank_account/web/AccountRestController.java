package org.sid.bank_account.web;

import org.sid.bank_account.dto.BankAccountRequestDTO;
import org.sid.bank_account.dto.BankAccountResponseDTO;
import org.sid.bank_account.entities.BankAccount;
import org.sid.bank_account.mapping.AccountMappers;
import org.sid.bank_account.repositories.BankAccountRepository;
import org.sid.bank_account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AccountRestController {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountService accountService;


    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account %s not found",id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
        return accountService.addAccount(requestDTO);
    }



    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){

        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreateAt() != null) account.setCreateAt(bankAccount.getCreateAt());
        if (bankAccount.getType() != null) account.setType(bankAccount.getType());
        if (bankAccount.getCurrency() != null) account.setCurrency(bankAccount.getCurrency());


        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts")
    public void deleteAccount(@PathVariable String id){
         bankAccountRepository.deleteById(id);
    }
}
