package by.kanarski.profito.security;

import by.kanarski.profito.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Primary
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDto userDto = null;
        userDto = null;
        if (userDto == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return userDto;
    }

    private List<GrantedAuthority> getGrantedAuthorities(UserDto userDto) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<String> roleSet = userDto.getRoleSet();
        for (String role : roleSet) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}
