package com.data.models.Repositories;

import com.data.models.store.users.UserActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserActivityLogRepository extends JpaRepository<UserActivityLog, Long> {

}
