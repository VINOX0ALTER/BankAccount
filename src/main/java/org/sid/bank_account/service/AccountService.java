package org.sid.bank_account.service;

import org.sid.bank_account.dto.BankAccountRequestDTO;
import org.sid.bank_account.dto.BankAccountResponseDTO;
import org.sid.bank_account.entities.BankAccount;

public interface AccountService {

    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);



}
