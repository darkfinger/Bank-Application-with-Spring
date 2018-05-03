package com.dkkcorp.mybankapp.command;

import java.util.Date;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class TransactionsCommand {
    private Long id;

    @Size(min = 8,max = 20)
    private AccountCommand fromAccount;
    @NotNull
    @Size(min = 8,max = 20)
    private AccountCommand toAccount;
    private Date dateOfTransaction;

    @NotNull
    @Size(max = 20)
    private Float amount;
}
