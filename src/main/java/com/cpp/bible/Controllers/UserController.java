package com.cpp.bible.Controllers;

import com.cpp.bible.Models.AppUser;
import com.cpp.bible.Requests.UserSignUpRequest;
import com.cpp.bible.Services.MapValidationErrorService;
import com.cpp.bible.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @Autowired
    UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserSignUpRequest userSignUpRequest, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
        {
            return errorMap;
        }

        AppUser appUser = userService.createUser(userSignUpRequest);

        return new ResponseEntity<>(appUser, HttpStatus.CREATED);
    }


}
