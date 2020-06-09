package hr.tvz.bestak.studapp.dao;

import hr.tvz.bestak.studapp.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserJPARepositoryTest {

    @Autowired
    UserJPARepository userJPARepository;

    @Test
    void findByUsernameIs() {
        String username = "admin";
        Optional<User> user = userJPARepository.findByUsernameIs(username);

        assertEquals(username, user.get().getUsername());
    }
}
