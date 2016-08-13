package com.login.dao;

import java.util.HashSet;
import java.util.Set;
 
import javax.inject.Inject;
import javax.inject.Named;
 
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
 
import com.login.model.UserModel;
import com.login.persistence.Role;
import com.login.persistence.User;
 
@Named
@Transactional("transactionManager")
public class UserDAO {
 
    @Inject
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    public void addUser(UserModel model) {
        User user = new User();
        user.setUserName(model.getUsername());
        user.setPassword(model.getPassword());
        user.setEnabled(1);
        Role role = (Role) sessionFactory.getCurrentSession()
                .createQuery("from Role where RoleName='ROLE_USER'").uniqueResult();
        if (role == null) {
            role = new Role();
            role.setRoleName("ROLE_USER");
            role.setRoleStatus("Ordinary User Access");
            sessionFactory.getCurrentSession().save(role);
        }
        Set<Role> roles = new HashSet<Role>();
        roles.add(role);
        user.setRoles(roles);
        sessionFactory.getCurrentSession().save(user);
    }
}
