package org.sid.bank_account.web;

import org.sid.bank_account.dto.BankAccountRequestDTO;
import org.sid.bank_account.dto.BankAccountResponseDTO;
import org.sid.bank_account.entities.BankAccount;
import org.sid.bank_account.repositories.BankAccountRepository;
import org.sid.bank_account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQlController {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;

    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount accountsListById(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Account %s not found",id))
        );
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){

        return accountService.addAccount(bankAccount);
    }


}
