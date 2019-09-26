package com.cpp.bible.Services;

import com.cpp.bible.Exceptions.Exception.DatabaseNotFoundException;
import com.cpp.bible.Exceptions.Exception.DuplicateAccountException;
import com.cpp.bible.Models.AppUser;
import com.cpp.bible.Models.Role;
import com.cpp.bible.Models.UserRole;
import com.cpp.bible.Repository.RoleRepo;
import com.cpp.bible.Repository.UserRepo;
import com.cpp.bible.Requests.UserSignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    UserRepo userRepo;

    public AppUser createUser(UserSignUpRequest userSignUpRequest){

        System.out.println(userSignUpRequest.getUsername());
        if (userRepo.findByUsername(userSignUpRequest.getUsername()) != null) {
            throw new DuplicateAccountException("Username '" + userSignUpRequest.getUsername() + "' already exists.");
        }

        AppUser appUser = new AppUser();
        appUser.setUsername(userSignUpRequest.getUsername());
        appUser.setPassword(userSignUpRequest.getPassword());
        appUser.setFirstname(userSignUpRequest.getFirstname());
        appUser.setLastname(userSignUpRequest.getLastname());
        appUser.setChinesename(userSignUpRequest.getChinesename());
        Set<UserRole> set = new HashSet<>();
        Role role = roleRepo.findRoleByName("STUDENT");
        if (role == null) {
            throw new DatabaseNotFoundException("Role type not found in database." );
        }
        set.add(new UserRole(appUser, role));
        appUser.setUserRoles(set);

        return userRepo.save(appUser);

    }






}
