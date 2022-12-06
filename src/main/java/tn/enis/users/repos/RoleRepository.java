package tn.enis.users.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enis.users.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}
