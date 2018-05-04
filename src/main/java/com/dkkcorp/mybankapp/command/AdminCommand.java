package com.dkkcorp.mybankapp.command;

import com.dkkcorp.mybankapp.domain.enums.Positions;
import lombok.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AdminCommand {

    private Long id;
    @NotNull
    @Email
    private String adminEmail;
    private Date lastLogin;
    @NotNull
    @Size(min = 8,max = 128)
    private String adminPassword;
    private Positions position;
}
