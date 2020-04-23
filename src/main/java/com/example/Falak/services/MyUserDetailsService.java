package com.example.Falak.services;

import com.example.Falak.model.MyUserDetails;
import com.example.Falak.model.User;
import com.example.Falak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public MyUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("testing: in loadUserByUsername method, passed email="+email);

        User user = userRepository.findByEmail(email);
        if (user == null){
            System.out.println("User Null");
            throw new UsernameNotFoundException(email +" is not found");}
        System.out.println("User = "+user.toString());
        MyUserDetails myUserDetails = new MyUserDetails(user);
        System.out.println("testing: out off loadUserByUsername method, email="+email);

        return myUserDetails;

    }

}
