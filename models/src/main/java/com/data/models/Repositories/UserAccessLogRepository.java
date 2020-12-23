package com.data.models.Repositories;


import com.data.models.store.users.UserAccessLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserAccessLogRepository extends JpaRepository<UserAccessLog,Long> {

}
