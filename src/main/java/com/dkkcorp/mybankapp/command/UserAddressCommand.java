package com.dkkcorp.mybankapp.command;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserAddressCommand {
    private Long id;
    private String country;
    private String city;
    private String street;
    private String number;
    private String zipCode;
    private Long userId;
}
