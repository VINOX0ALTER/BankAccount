package org.sid.bank_account.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bank_account.enums.AccountType;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BankAccountResponseDTO {
    private String id;
    private Date createAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
