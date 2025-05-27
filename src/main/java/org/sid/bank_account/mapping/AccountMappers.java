package org.sid.bank_account.mapping;


import com.fasterxml.jackson.databind.util.BeanUtil;
import org.sid.bank_account.dto.BankAccountResponseDTO;
import org.sid.bank_account.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMappers {

public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
    BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
    BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
    return bankAccountResponseDTO;
}

}
