package com.data.models.Repositories.Users;

import com.data.models.store.Heplers.UserActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserActivityLogRepository extends JpaRepository<UserActivityLog, Long> {

}
