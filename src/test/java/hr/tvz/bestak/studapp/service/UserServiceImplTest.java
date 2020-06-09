package hr.tvz.bestak.studapp.service;

import hr.tvz.bestak.studapp.dao.UserJPARepository;
import hr.tvz.bestak.studapp.model.Authority;
import hr.tvz.bestak.studapp.model.User;
import hr.tvz.bestak.studapp.model.UserDTO;
import hr.tvz.bestak.studapp.security.UserRepository;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {


    UserJPARepository userRepository;
    UserService userService;
    User expectedUser;
    String TEST_USERNAME="admin";

    @BeforeEach
    void init(){
        userRepository = EasyMock.createNiceMock(UserJPARepository.class);
        userService = new UserServiceImpl(userRepository);
        expectedUser = new User(0, TEST_USERNAME, "pass", "John", "Doe", Arrays.asList(new Authority()));
    }

    @Test
    void findByUsernameIs() {
        EasyMock.expect(userRepository.findByUsernameIs(TEST_USERNAME)).andReturn(Optional.of(expectedUser));
        replay(userRepository);
        Optional<UserDTO> user = userService.findByUsernameIs(TEST_USERNAME);

        assertEquals(expectedUser.getUsername(), user.get().getUsername());
    }

    @Test
    void mapUserToDTO() {
        User user = new User(0, "admin", "pass", "Ivan", "Horvat", Arrays.asList(new Authority()));
        List<String> authorities = user.getAuthorities().stream().map(authority -> authority.getName() ).collect(Collectors.toList());

        UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getFirstname(), user.getLastname(), authorities);
        assertNotNull(userDTO);
    }
}
