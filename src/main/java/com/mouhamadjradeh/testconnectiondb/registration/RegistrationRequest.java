package com.mouhamadjradeh.testconnectiondb.registration;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
 @AllArgsConstructor
@ToString
public class RegistrationRequest {
    private final String firstname;
    private final String lastname;
    private final String password;
    private final String email;

}
