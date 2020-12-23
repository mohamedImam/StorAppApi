package com.data.models.Repositories;

import com.data.models.users.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	List<UserRole> findByStatus(boolean status);

	UserRole findByName(String name);

}
