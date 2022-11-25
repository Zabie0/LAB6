package org.Credits.Bank;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Bank {
    private final String name;
    private final int bankId;
    private final String address;
    private final String email;

    @Override
    public String toString() {
        return "Bank's name='" + name + '\n' +
                "Bank id=" + bankId + '\n' +
                "Address='" + address + '\n' +
                "Email='" + email + '\n';
    }
}
