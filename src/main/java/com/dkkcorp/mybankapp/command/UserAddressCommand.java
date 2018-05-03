package com.dkkcorp.mybankapp.command;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserAddressCommand {
    private Long id;
    @NotNull
    @Size(max = 100)
    private String country;
    @NotNull
    @Size(max = 100)
    private String city;
    @NotNull
    @Size(max = 100)
    private String street;
    @Size(max = 100)
    private String number;
    @Size(max = 32)
    @NotNull
    private String zipCode;
    private Long userId;
}
