package hr.tvz.bestak.studapp.model;

import lombok.Data;

public class AuthorityDTO {
    private final String role;

    public AuthorityDTO(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
