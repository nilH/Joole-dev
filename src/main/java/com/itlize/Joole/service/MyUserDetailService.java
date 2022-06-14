package com.itlize.Joole.service;

import com.itlize.Joole.entity.Project;
import com.itlize.Joole.entity.User;
import com.itlize.Joole.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByName(username).orElse(null);
        if(user==null){
            throw new UsernameNotFoundException(username);
        }

        return new MyUserDetails(user);
    }
    public class MyUserDetails implements UserDetails{
        User myuser;
        MyUserDetails(User user){
            myuser=user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> authorities=new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(myuser.getRole()));
            return authorities;
        }
        @Override
        public String getUsername() {
            return myuser.getName();
        }
        @Override
        public boolean isEnabled() {
            return true;
        }
        @Override
        public String getPassword() {
            return myuser.getPassword();
        }
        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }
        @Override
        public boolean isAccountNonExpired() {
            return true;
        }
        @Override
        public boolean isAccountNonLocked() {
            return true; 
        }

        public List<String> getProjectNames(){
            List<String> projectNames=new ArrayList<>();
            for(Project project:myuser.getProject()){
                projectNames.add(project.getProjectName());
            }
            return projectNames;
        }
        public List<Integer> getProjectIds(){
            List<Integer> projectIds=new ArrayList<>();
            for(Project project:myuser.getProject()){
                projectIds.add(project.getId());
            }
            return projectIds;
        }
    }

}
