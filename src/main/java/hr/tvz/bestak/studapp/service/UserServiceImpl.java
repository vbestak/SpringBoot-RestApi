package hr.tvz.bestak.studapp.service;

import hr.tvz.bestak.studapp.dao.UserJPARepository;
import hr.tvz.bestak.studapp.model.AuthorityDTO;
import hr.tvz.bestak.studapp.model.User;
import hr.tvz.bestak.studapp.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserJPARepository userRepository;

    @Autowired
    public UserServiceImpl(UserJPARepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDTO> findByUsernameIs(String username) {
        return this.userRepository.findByUsernameIs(username).map(this::mapUserToDTO);
    }

    @Override
    public UserDTO mapUserToDTO(User user) {
        List<String> authorities = user.getAuthorities().stream().map( authority -> authority.getName() ).collect(Collectors.toList());
        return new UserDTO(user.getId(), user.getUsername(), user.getFirstname(), user.getLastname(), authorities);
    }
}
