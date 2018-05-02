package com.dkkcorp.mybankapp.command;
import com.dkkcorp.mybankapp.domain.enums.AccountType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AccountCommand {
    private Long accountNo;
    private AccountType accountType;
    private Float balance;
    private Long userId;
}
