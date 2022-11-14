package com.shop.e_shop.service;

import com.shop.e_shop.model.User;
import com.shop.e_shop.model.ShopUserDetails;
import com.shop.e_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(username);
        if (user.getEmail().equals(username)) {
            boolean adminFlag = user.getIsAdmin().equals("1");
            List<SimpleGrantedAuthority> authoritiesList = adminFlag ? Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")) : Collections.emptyList();
            return new ShopUserDetails(
                    user.getEmail(),
                    user.getPassword(),
                    authoritiesList);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}
