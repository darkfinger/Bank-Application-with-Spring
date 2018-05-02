package com.dkkcorp.mybankapp.command;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class TransactionsCommand {
    private Long id;
    private AccountCommand fromAccount;
    private AccountCommand toAccount;
    private Date dateOfTransaction;
    private Float amount;
}
