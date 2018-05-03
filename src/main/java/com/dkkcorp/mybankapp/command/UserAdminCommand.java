package com.dkkcorp.mybankapp.command;

import com.dkkcorp.mybankapp.domain.enums.Positions;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserAdminCommand extends UserCommand{

    @NotNull
    @Size(min = 8,max = 128)
    private String adminPassword;
    private Positions position;
}
