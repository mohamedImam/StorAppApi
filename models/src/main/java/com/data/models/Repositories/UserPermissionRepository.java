package com.data.models.Repositories;

import com.data.models.store.users.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {

	List<UserPermission> findByStatus(boolean status);

	List<UserPermission> findByNameIn(List<String> names);
	
	Optional<UserPermission> findByName(String name);

}
