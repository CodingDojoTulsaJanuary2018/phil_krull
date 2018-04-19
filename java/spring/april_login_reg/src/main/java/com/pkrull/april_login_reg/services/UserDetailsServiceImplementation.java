package com.pkrull.april_login_reg.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import com.pkrull.april_login_reg.models.Role;
import com.pkrull.april_login_reg.models.User;
import com.pkrull.april_login_reg.repositories.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	private final UserRepository userRepository;
//	private final AuthenticationManager authenticationManager;
//	, AuthenticationManager authenticationManager
    public UserDetailsServiceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;
//        this.authenticationManager = authenticationManager;
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // email is sent in here instead of username for login process
    	User user = userRepository.findByEmail(email);
        System.out.println("===========================");
        System.out.println(user.getPassword());
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities(user));
    }
    
    // 2
    public List<GrantedAuthority> getAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
    
//    public void authWithAuthManager(HttpServletRequest request, String username, String password) {
//        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
//        authToken.setDetails(new WebAuthenticationDetails(request));
//         
//        Authentication authentication = authenticationManager.authenticate(authToken);
//         
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//    }

}
