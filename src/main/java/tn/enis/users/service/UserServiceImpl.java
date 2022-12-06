package tn.enis.users.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.enis.users.entities.Role;
import tn.enis.users.entities.User;
import tn.enis.users.repos.RoleRepository;
import tn.enis.users.repos.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public User addRoleToUser(String username, String rolename) {
		User usr = userRepository.findByUsername(username);
		Role r = roleRepository.findByRole(rolename);
		usr.getRoles().add(r);
		return usr;
	}
	
	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}
	
	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
}

