package hr.tvz.bestak.studapp.security.web;

import hr.tvz.bestak.studapp.model.UserDTO;
import hr.tvz.bestak.studapp.security.SecurityUtils;
import hr.tvz.bestak.studapp.security.jwt.JwtFilter;
import hr.tvz.bestak.studapp.security.jwt.TokenProvider;
import hr.tvz.bestak.studapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserService userService;

    @Autowired
    public LoginController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserService userService) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userService = userService;
    }

    @GetMapping(path = "/user/current-user")
    public ResponseEntity<UserDTO> currentUser(){
        String username = SecurityUtils.getCurrentUserUsername().get();
        Optional<UserDTO> user = userService.findByUsernameIs(username);

        if (user.isEmpty())
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(user.get());
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<JWTToken> authenticate(@RequestBody LoginController.LoginDTO login) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                login.getUsername(),
                login.getPassword()
        );

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);
        
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new JWTToken(jwt), httpHeaders, HttpStatus.OK);
    }

    /**
     * Return jwt token in body because Angular has problems with parsing plain string response entity
     */
    static class JWTToken {
        private String token;

        public JWTToken(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

    }
    
    static class LoginDTO {
        
        @NotNull
        private String username;

        @NotNull
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
