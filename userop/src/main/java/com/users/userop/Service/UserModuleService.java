package com.users.userop.Service;

import com.data.models.Repositories.Users.UserActivityLogRepository;
import com.data.models.Repositories.Users.UserPermissionRepository;
import com.data.models.Repositories.Users.UserRepository;
import com.data.models.Repositories.Users.UserRoleRepository;
import com.data.models.enums.PageName;
import com.data.models.users.User;
import com.data.models.users.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.data.models.store.Heplers.UserPermission;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/22/2020  : 19:47
 */
@Service
public class UserModuleService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    private UserPermissionRepository userPermissionRepository;
    @Autowired
    private UserActivityLogRepository activityLogRepository;

/*	public UserModuleService(UserPermissionRepository userPermissionRepository, UserActivityLogRepository activityLogRepository, UserRepository userRepository, UserRoleRepository userRoleRepository) {
		this.userPermissionRepository = userPermissionRepository;
		this.activityLogRepository = activityLogRepository;
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}*/

    // Login

    public Optional<User> logIn(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password);
    }

    public com.data.models.store.Heplers.UserPermission isAuthorized(User user, String pageName) {
        UserPermission pagePermission = null;
        if (user != null && user.getUserRole() != null && user.getUserRole().getUserPermissions() != null) {
            for (UserPermission p : user.getUserRole().getUserPermissions())
                if (p.isStatus() && p.getPageName().equals(pageName) ) //&& PagesFinder.getPages().contains(pageName))
                    pagePermission = p;
        }
        return pagePermission;
    }

    public UserPermission isAuthorized(User user, String page, PageName pageName, HttpServletRequest request, Object entity)
            throws Exception {
        if (user.getUserRole() != null && user.getUserRole().getUserPermissions() != null) {
            for (UserPermission p : user.getUserRole().getUserPermissions())
                if (p.isStatus() && p.getPageName().equals(page) ){ //&& PagesFinder.getPages().contains(page)) {
                    return p;
                } else {
                    // do nothing
                }
        } else {
            // do nothing
            return null;
        }
		/*ejLogger.saveUserActivity(activityLogRepository, user.getUserName(), IPAddressFinder.getUserIp(request),
				pageName, EjmConstant.Messages.DONT_HAVE_PAGE_PERMISSION + entity, false);
		throw new EjmException(EjmErrorTypes.DONT_HAVE_PAGE_PERMISSION, pageName);*/
        throw new Exception ();//;(EjmErrorTypes.DONT_HAVE_PAGE_PERMISSION, pageName);
    }

    // User CRUD

    public void addUser(User user) {
        if (user.getId() > 0) {
            LocalDateTime registeredDate = getUser(user.getId()).getRegisteredDate();
            user.setRegisteredDate(registeredDate);
        }
        userRepository.save(user);
    }

    public User getUser(long userId) {
        return userRepository.findById(userId).orElseGet(User::new);
    }

    public void removeUser(long userId) {
        userRepository.deleteById(userId);
    }

    public void changeUserStatus(long userId, boolean status) {
        User user = getUser(userId);
        user.setStatus(status);
        addUser(user);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public boolean changePassword(String userName, String oldPassword, String newPassword) {
        Optional<User> optUser = userRepository.findByUserNameAndPassword(userName, oldPassword);
        if (optUser.isPresent()) {
            optUser.get().setPassword(newPassword);
            addUser(optUser.get());
            return true;
        }
        return false;
    }

    public void changeUserSessionStatus(long userId, boolean sessionStatus) {
        User user = getUser(userId);
        user.setSessionActive(sessionStatus);
        addUser(user);
    }

    // Role CRUD

    public void addUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    public UserRole getUserRole(long roleId) {
        return userRoleRepository.findById(roleId).orElseGet(UserRole::new);
    }

    /*public void removeUserRole(long roleId) {
        List<User> users = userRepository.findByUserRole(getUserRole(roleId));
        users.forEach(user -> {
            user.setUserRole(null);
            user.setSessionActive(false);
            addUser(user);
        });
        userRoleRepository.deleteById(roleId);
    }*/

    public void changeUserRoleStatus(long userRoleId, boolean status) {
        UserRole userRole = getUserRole(userRoleId);
        userRole.setStatus(status);
        addUserRole(userRole);
    }

    public List<UserRole> getAllUserRoles() {
        List<UserRole> roles = new ArrayList<>();
        userRoleRepository.findAll().forEach(roles::add);
        return roles;
    }

    public List<UserRole> getAllActiveRoles() {
        List<UserRole> userRoles = new ArrayList<>();
        userRoleRepository.findByStatus(true).forEach(userRoles::add);
        return userRoles;
    }

    public UserRole getRoleByName(String name) {
        return userRoleRepository.findByName(name);
    }

    // Permission CRUD

    public void addUserPermission(UserPermission userPermission) {
        userPermissionRepository.save(userPermission);
    }

    public UserPermission getUserPermission(long permissionId) {
        return userPermissionRepository.findById(permissionId).orElseGet(UserPermission::new);
    }

    public void removeUserPermission(long permissionId) {
        userPermissionRepository.deleteById(permissionId);
    }

    public void changePermissionStatus(long permissionId, boolean status) {
        UserPermission permission = getUserPermission(permissionId);
        permission.setStatus(status);
        addUserPermission(permission);
    }

    public List<UserPermission> getAllUserPermissions() {
        List<UserPermission> userPermissions = new ArrayList<>();
        userPermissionRepository.findAll().forEach(userPermissions::add);
        return userPermissions;
    }

    public List<UserPermission> getAllActivePermissions() {
        List<UserPermission> userPermissions = new ArrayList<>();
        userPermissionRepository.findByStatus(true).forEach(userPermissions::add);
        return userPermissions;
    }

    public List<UserPermission> getPermissionsByNames(List<String> names) {
        return userPermissionRepository.findByNameIn(names);
    }

    public boolean isPermissionExist(String permissionName) {
        return userPermissionRepository.findByName(permissionName).isPresent();
    }
}
