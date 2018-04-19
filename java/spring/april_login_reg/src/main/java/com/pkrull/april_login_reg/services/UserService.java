package com.pkrull.april_login_reg.services;

import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pkrull.april_login_reg.models.User;
import com.pkrull.april_login_reg.repositories.RoleRepository;
import com.pkrull.april_login_reg.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository uRepo;
	private final RoleRepository rRepo;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository uRepo, RoleRepository rRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
		// TODO Auto-generated constructor stub
		this.uRepo = uRepo;
		this.rRepo = rRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	 // 1
    public User saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(rRepo.findByName("ROLE_USER"));
        return uRepo.save(user);
    } 
    
    public User findByEmail(String email) {
    	return uRepo.findByEmail(email);
    }
    
    public void updateUser(User user) {
    	user.setUpdatedAt(new Date());
    	uRepo.save(user);
    }
 
}
