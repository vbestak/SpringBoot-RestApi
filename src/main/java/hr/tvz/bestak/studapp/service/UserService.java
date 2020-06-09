package hr.tvz.bestak.studapp.service;

import hr.tvz.bestak.studapp.model.User;
import hr.tvz.bestak.studapp.model.UserDTO;

import java.util.Optional;

public interface UserService {

    Optional<UserDTO> findByUsernameIs(String username);

    UserDTO mapUserToDTO(User user);
}
