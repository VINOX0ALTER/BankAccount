package org.sid.bank_account.service;

import io.swagger.v3.oas.annotations.servers.Server;
import org.sid.bank_account.dto.BankAccountRequestDTO;
import org.sid.bank_account.dto.BankAccountResponseDTO;
import org.sid.bank_account.entities.BankAccount;
import org.sid.bank_account.mapping.AccountMappers;
import org.sid.bank_account.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMappers accountMappers;


    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {

        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .type(bankAccountRequestDTO.getType())
                .currency(bankAccountRequestDTO.getCurrency())
                .build();

        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO = accountMappers.fromBankAccount(saveBankAccount);



        return bankAccountResponseDTO;
    }
}
