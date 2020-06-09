package hr.tvz.bestak.studapp.security;

import hr.tvz.bestak.studapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Id> {
    Optional<User> findOneByUsername(String username);
}
