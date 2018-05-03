package com.dkkcorp.mybankapp.command;
import com.dkkcorp.mybankapp.domain.enums.AccountType;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class AccountCommand {

    @NotNull
    @Size(min = 8,max = 20)
    private Long accountNo;
    private AccountType accountType;

    @Size(max = 15)
    private Float balance;
    private Long userId;
}
