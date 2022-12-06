package tn.enis.users.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enis.users.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername(String username);
}
