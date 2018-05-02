package com.dkkcorp.mybankapp.command;

import com.dkkcorp.mybankapp.domain.User;
import com.dkkcorp.mybankapp.domain.enums.TypeContact;
import lombok.Data;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserContactCommand {
    private Long id;
    private TypeContact typeContact;
    private Integer ContactNumber;
    private Long userId;
}
