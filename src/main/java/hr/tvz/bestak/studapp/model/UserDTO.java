package hr.tvz.bestak.studapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

public class UserDTO {
    private final int id;
    private final String username;
    private final String firstname;
    private final String lastname;
    private final List<String> authorities;

    public UserDTO(int id, String username, String firstname, String lastname, List<String> authorities) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<String> getAuthorities() {
        return authorities;
    }
}
