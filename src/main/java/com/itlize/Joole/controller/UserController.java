package com.itlize.Joole.controller;
//login register logout

import com.itlize.Joole.dto.UserInfo;
import com.itlize.Joole.entity.User;
import com.itlize.Joole.service.UserService;
import com.itlize.Joole.service.MyUserDetailService.MyUserDetails;
import com.itlize.Joole.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;


    @GetMapping("/login")
    public ResponseEntity<UserInfo> login(@RequestParam("username") String username,
                     @RequestParam("password") String password) throws Exception
    {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password",e);
        }
        final MyUserDetails userDetails=(MyUserDetails) userDetailsService.loadUserByUsername(username);
        final String jwt=jwtUtil.generateToken(userDetails);
        UserInfo userInfo=new UserInfo(username,"password", jwt, userDetails.getProjectIds(), userDetails.getProjectNames());
        return new ResponseEntity<UserInfo>(userInfo, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserInfo user)
    {
        if(userService.findByUsername(user.getUsername())!=null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        User user1=new User();
        user1.setPassword(user.getPassword());
        user1.setName(user.getUsername());
        user1.setTimeCreated(LocalDateTime.now());
        user1.setRole("User");
        return new ResponseEntity<>(userService.saveUser(user1).getName(), HttpStatus.CREATED);
    }
    

}
