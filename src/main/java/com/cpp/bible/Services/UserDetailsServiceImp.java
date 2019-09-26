package com.cpp.bible.Services;

import com.cpp.bible.Models.AppUser;
import com.cpp.bible.Models.UserRole;
import com.cpp.bible.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepo.findByUsername(username);
        if (appUser == null) {}
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<UserRole> userRoleSet = appUser.getUserRoles();
        for (UserRole userRole : userRoleSet) {
            authorities.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
        }

        return new User(username, appUser.getPassword(), authorities);
    }
}
