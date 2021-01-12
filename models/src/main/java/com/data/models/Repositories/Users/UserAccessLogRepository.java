package com.data.models.Repositories.Users;


import com.data.models.store.Heplers.UserAccessLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserAccessLogRepository extends JpaRepository<UserAccessLog,Long> {

}
