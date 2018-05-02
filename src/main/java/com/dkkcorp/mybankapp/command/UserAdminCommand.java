package com.dkkcorp.mybankapp.command;

import com.dkkcorp.mybankapp.domain.enums.Positions;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserAdminCommand extends UserCommand{
    private String adminPassword;
    private Positions position;
}
