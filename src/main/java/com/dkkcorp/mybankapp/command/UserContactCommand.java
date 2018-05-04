package com.dkkcorp.mybankapp.command;

import com.dkkcorp.mybankapp.domain.enums.TypeContact;
import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserContactCommand {
    private Long id;
    private TypeContact typeContact;
    @Size(max = 15)
    private Long ContactNumber;
    private Long userId;
}
