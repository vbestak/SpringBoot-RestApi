package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsernameIs(String username);
}
