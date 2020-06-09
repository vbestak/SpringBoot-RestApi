package hr.tvz.bestak.studapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(targetEntity = User.class, mappedBy = "authorities")
    List<User> users;

    public Authority(){}

    public Authority(int id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
