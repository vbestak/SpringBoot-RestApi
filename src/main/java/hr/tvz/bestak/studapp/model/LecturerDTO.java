package hr.tvz.bestak.studapp.model;

import lombok.Data;

public class LecturerDTO {
    private Integer id;
    private String name;
    private String lastName;
    private String phoneNumber;

    public LecturerDTO(Integer id, String name, String lastName, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
