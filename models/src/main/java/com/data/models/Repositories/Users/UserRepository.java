package com.data.models.Repositories.Users;



import com.data.models.users.User;
import com.data.models.users.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserNameAndPassword(String userName, String password);
	
	List<User> findByUserRole(UserRole userRole);

}
