package tn.enis.users.service;

import tn.enis.users.entities.Role;
import tn.enis.users.entities.User;

public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
}

